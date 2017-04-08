package control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;

import modelo.Juego;
import modelo.Palabra;

public class EjecutarS {
	
//	public static int PUERTO = 6598;
	public static String IP = "localhost";

	private Juego juego;
	
	public EjecutarS(){
		juego = new Juego(this);
	}
	
	public static void main(String[] args) {
		EjecutarS e = new EjecutarS();
		
		try {
			e.esperarConexionUDP();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
//			e1.getStackTrace();
		}

	}
	
	public void esperarConexionUDP() throws IOException{
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(System.in));
		DatagramSocket ss = new DatagramSocket(6598);
		byte[] entrada = new byte[64];
		byte[] salida = new byte[64];
		
		boolean fin = true;
		while(fin ){
			
			DatagramPacket paqueteRecibido = new DatagramPacket(entrada, entrada.length);
			ss.receive(paqueteRecibido);
			String sentencia = "";
			String mensajeEnviar = "";
			sentencia = new String(paqueteRecibido.getData());
			String categoria = "";
			
			InetAddress IPAddress = paqueteRecibido.getAddress();
			int port = paqueteRecibido.getPort();
			
			System.out.println("Esperando conexion");
			if( sentencia.contains("conexion") ){
				System.out.println("Cliente dice: "+sentencia);
				System.out.println("Cliente conectado");
				sentencia = "";
				//Enviar ACK
				
				salida = new byte[64];
				mensajeEnviar = "";
				mensajeEnviar = "Bienvenido";
				salida = mensajeEnviar.getBytes();
								
				DatagramPacket enviarPaquete = new DatagramPacket(salida, salida.length, IPAddress, port);
				ss.send(enviarPaquete);
			}
			
			if( sentencia.contains("Hello MarcoPolo") ){
				System.out.println("Cliente dice: "+sentencia);
				System.out.println("Cliente saludó");
				
				//Enviar ACK
				salida = new byte[64];
				mensajeEnviar = "";
				mensajeEnviar = "Hola Cliente";
				salida = mensajeEnviar.getBytes();
								
				DatagramPacket enviarPaquete = new DatagramPacket(salida, salida.length, IPAddress, port);
				ss.send(enviarPaquete);
			}
			
			if( sentencia.contains("idcliente")){
				System.out.println("Cliente dice: "+sentencia);
				
				//Definir ID para cliente
				int numeroAleatorio = (int) (Math.random()*1000+1);
				String[] datosID = sentencia.split(",");
				String temp = "";
				for(int i=0; i<datosID[1].length(); i++){
					if(datosID[1].charAt(i)==' ')
						i=datosID[1].length();
					else
						temp+=datosID[1].charAt(i);
				}
				String id = numeroAleatorio+temp;
				System.out.println("Se definió el ID para el cliente :"+id);
				
				//Enviar ACK
				salida = new byte[64];
				mensajeEnviar = "";
				mensajeEnviar = id+";clienteID";
				salida = mensajeEnviar.getBytes();
								
				DatagramPacket enviarPaquete = new DatagramPacket(salida, salida.length, IPAddress, port);
				ss.send(enviarPaquete);
			}
			
			if( sentencia.contains("CategoriasDisponibles")){
				System.out.println("Server dice: "+sentencia);
				System.out.println("Cliente solicitó categorias");
				//Enviar categorias
				salida = new byte[64];
				mensajeEnviar = "";
				mensajeEnviar = obtenerCategorias();
				salida = mensajeEnviar.getBytes();
								
				DatagramPacket enviarPaquete = new DatagramPacket(salida, salida.length, IPAddress, port);
				ss.send(enviarPaquete);
				
				System.out.println("Server envió la lista de categorías: "+ mensajeEnviar);
			}
			
			if( sentencia.contains("animales") || sentencia.contains("acciones") || sentencia.contains("deportes")){
				System.out.println("Cliente seleccionó la categoría: "+sentencia);
				categoria = sentencia;
				
				//Enviar una palabra para adivinar
				
				mensajeEnviar = "";
				mensajeEnviar = seleccionarPalabraAleatoria(categoria)+";palabraParaAdivinar";
				salida = mensajeEnviar.getBytes();
				
				DatagramPacket enviarPaquete = new DatagramPacket(salida, salida.length, IPAddress, port);
				ss.send(enviarPaquete);
				System.out.println("Se envió la palabra al cliente: "+mensajeEnviar);
//				fin=false;
//				
//				ss.close();
			}
			
//			else if( sentencia.equals("Jugar") ){
//				System.out.println("Cliente Jugar: "+sentencia);
//				//Enviar una palabra para adivinar
//				String mensajeEnviar = seleccionarPalabraAleatoria(categoria);
//				salida = mensajeEnviar.getBytes();
//			}
			
//			if( sentencia.equals("puntajeJugador")){
//				System.out.println("Cliente: "+sentencia);
//				//Enviar puntaje
//				mensajeEnviar = "";
//				salida = mensajeEnviar.getBytes();
//			}
			
		}
	}

	private String seleccionarPalabraAleatoria(String categoria) {
		
		ArrayList<Palabra> palabras = new ArrayList<Palabra>();
		
		if( categoria.contains("animales") ){
			palabras = juego.getAnimales();
			System.out.println("palabra = "+palabras.get(0).getPalabra());
		}
		
		else if( categoria.contains("acciones") ){
			palabras = juego.getAcciones();
			System.out.println("palabra = "+palabras.get(0).getPalabra());
		}
		
		else{
			palabras = juego.getDeportes();
			System.out.println("palabra = "+palabras.get(0).getPalabra());
		}
		
		int aleatorio = (int) (Math.random()*(palabras.size()-1) +0);
		System.out.println(aleatorio);
		String palabra = palabras.get(aleatorio).getPalabra();
		
		return palabra;
	}

	private String obtenerCategorias() {
		String categorias = "animales;acciones;deportes";
		return categorias;
	}

}
