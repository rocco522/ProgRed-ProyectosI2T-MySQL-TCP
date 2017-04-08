package control;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.JButton;

import modelo.Juego;
import modelo.Jugador;
import vista.Ventana;

public class EjecutarC implements ActionListener{

	public static int PUERTO = 6598;
	public static String IP = "localhost";

	private Ventana interfaz;
	private byte[] salida;
	private byte[] entrada;
	private DatagramSocket cs;
	private String categorias;

	private Juego juego;
	private Jugador jugador;
	private String palabra;
	private String idJugador;
	private String letrasJugadas1;
	private String letrasJugadas2;

	public EjecutarC() {
		palabra = "";
		idJugador = "";
		letrasJugadas1 = "";
		letrasJugadas2 = "";
	}

	private void inicializarModelo() {
		jugador = new Jugador(idJugador);
		juego = new Juego(jugador, this, palabra);

	}

	public static void main(String[] args) {
		EjecutarC e = new EjecutarC();

		e.iniciarInterfazGrafica();
		
	}

	private void iniciarInterfazGrafica() {

		interfaz = new Ventana(this);
		interfaz.setVisible(true);

	}

	private void iniciarConexion(String nombre) throws IOException{

		cs = new DatagramSocket();
		InetAddress IPAddress = InetAddress.getByName(IP);

		salida = new byte[64];
		entrada = new byte[64];

		//Conexion
		solicitarConexion();

		//Saludar
		saludar();

		//Enviar ID
		enviarID(nombre);

		//Solicitar categorias
		solicitarCategorias();

		escucharAlServidor();


	}

	private void escucharAlServidor() throws IOException{
						
		boolean fin = false;
			
		while( !fin ){
			
			if(cs.isClosed()){
				fin=true;
				System.out.println("-------------------------------- Conexion cerrada");
			}
			
			else{
				System.out.println("Cliente dice: Esperando al servidor");
				DatagramPacket paqueteRecibido = new DatagramPacket(entrada, entrada.length);
				cs.receive(paqueteRecibido);
				String sentencia = "";
				sentencia = new String(paqueteRecibido.getData());

				System.out.println("Server dice: "+sentencia);
				
				if(sentencia.contains("Hola Cliente")){
					System.out.println("Server dice: "+sentencia);
				}
				if(sentencia.contains("ClienteID")){
					System.out.println("Server dice: "+sentencia);
					String[] temp = sentencia.split(";");
					idJugador = temp[0];
				}
				if(sentencia.contains("animales;acciones;deportes")){
					System.out.println("Server dice: "+sentencia);
					ackCategorias(sentencia);
					cs.close();
				}
				if(sentencia.contains("palabraParaAdivinar")){
					String[] temp = sentencia.split(";");
					palabra = temp[0];
					System.out.println("Server dice: Palabra para adivinar = "+palabra);
					cs.close();
				}
			}
		}
	}

	private boolean ackPalabra() throws IOException {
		entrada = new byte[64];
		DatagramPacket paqueteEntrada = new DatagramPacket(entrada, entrada.length);
		cs.receive(paqueteEntrada);
		String palabra = new String(paqueteEntrada.getData());

		return true;
	}

	private void ackCategorias(String categorias) throws IOException {
		interfaz.getComboBox().setModel(refrescarComboBoxCategorias(categorias));
	}

	private DefaultComboBoxModel refrescarComboBoxCategorias(String categorias) {
//		String[] cat = categorias.split(";");
		System.out.println("Lista de categorias que envio el servidor: "+categorias);
		String[] cat = {"animales","deportes","acciones"};
		DefaultComboBoxModel modelo = new DefaultComboBoxModel<>(cat);

		return modelo;
	}

	private boolean ackID() throws IOException {
		entrada = new byte[64];
		DatagramPacket paqueteEntrada = new DatagramPacket(entrada, entrada.length);
		cs.receive(paqueteEntrada);
		String ackID = new String(paqueteEntrada.getData());

		if( ackID.contains("Recibido")){

			System.out.println("Server: "+ackID);
			return true;
		}

		return false;
	}

	private boolean acksaludar() throws IOException {
		entrada = new byte[64];
		DatagramPacket paqueteEntrada = new DatagramPacket(entrada, entrada.length);
		cs.receive(paqueteEntrada);
		String ackSaludar = new String(paqueteEntrada.getData());

		if( ackSaludar.contains("Hola Cliente")){

			System.out.println("Server: "+ackSaludar);
			return true;
		}

		return false;
	}

	private boolean ackconexion() throws IOException {
		entrada = new byte[64];
		DatagramPacket paqueteEntrada = new DatagramPacket(entrada, entrada.length);
		cs.receive(paqueteEntrada);
		String ackConectado = new String(paqueteEntrada.getData());

		if( ackConectado.contains("Bienvenido")){

			System.out.println("Server: "+ackConectado);
			return true;
		}

		return false;
	}

	private void solicitarCategorias() throws IOException {
		salida = new byte[64];
		String saludo = "CategoriasDisponibles";
		salida = saludo.getBytes();
		DatagramPacket paqueteSalida = new DatagramPacket(salida, salida.length, InetAddress.getByName(IP), PUERTO);
		cs.send(paqueteSalida);		
		System.out.println("Cliente: "+saludo);
	}

	private void solicitarConexion() throws IOException {
		salida = new byte[64];
		String saludo = "Conexion";
		salida = saludo.getBytes();
		DatagramPacket paqueteSalida = new DatagramPacket(salida, salida.length, InetAddress.getByName(IP), PUERTO);
		cs.send(paqueteSalida);		
		System.out.println("Cliente: "+saludo);

	}

	private void enviarPuntaje() throws IOException {
		salida = new byte[64];
		String puntaje = obtenerPuntaje();
		salida = puntaje.getBytes();
		DatagramPacket paquete = new DatagramPacket(salida, salida.length, InetAddress.getByName(IP), PUERTO);
		cs.send(paquete);

		System.out.println("Cliente: "+puntaje);
	}

	private String obtenerPuntaje() {
		// TODO Auto-generated method stub
		return 20+"";
	}



	private void enviarCategoria(String categoria) throws IOException {
		cs = new DatagramSocket();
		salida = new byte[64];
		salida = categoria.getBytes();
		DatagramPacket paqueteSalida = new DatagramPacket(salida, salida.length, InetAddress.getByName(IP), PUERTO);
		cs.send(paqueteSalida);
		System.out.println("Cliente: "+categoria);

	}

	private void enviarID(String nombre) throws IOException {
		salida = new byte[64];
		salida = ("idcliente,"+nombre).getBytes();
		DatagramPacket paqueteSalida = new DatagramPacket(salida, salida.length, InetAddress.getByName(IP), PUERTO);
		cs.send(paqueteSalida);
		System.out.println("Cliente: "+nombre);
	}

	public void saludar() throws IOException{
		salida = new byte[64];
		String saludo = "Hello MarcoPolo";
		salida = saludo.getBytes();
		DatagramPacket paqueteSalida = new DatagramPacket(salida, salida.length, InetAddress.getByName(IP), PUERTO);
		cs.send(paqueteSalida);		
		System.out.println("Cliente: "+saludo);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();

		if( comando.equals(Ventana.JUGAR)){

			try {
				iniciarConexion(interfaz.getTxtNombre().getText());
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		if( comando.equals(Ventana.INICIAR)){
			
			String categoria = interfaz.getComboBox().getSelectedItem().toString();

			System.out.println("Cliente ha seleccionado la categoria: "+categoria);
			try {
				enviarCategoria(categoria);
				escucharAlServidor();
				
				inicializarModelo();
				
				juego.iniciarJuego();
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		if( comando.equals(Ventana.ADIVINAR)){
			String letraJugadaTemp = interfaz.getTxtLetra().getText();
			System.out.println("Tratando de adivinar la letra =" + letraJugadaTemp);
			juego.procesarJugada(letraJugadaTemp);
			interfaz.getTxtLetra().setText("");
			
			if(letrasJugadas1.length() <= 19){
				letrasJugadas1 += letraJugadaTemp.toUpperCase()+" ";
				interfaz.getLblJugadasRealizadas1().setText(letrasJugadas1);
			}
			else{
				letrasJugadas2 += letraJugadaTemp.toUpperCase()+" ";
				interfaz.getLblJugadasRealizadas2().setText(letrasJugadas2);
			}
		}
	}

	public void inicializarBtnConsultar(JButton btnJugar, String etiqueta) {
		btnJugar.setText(etiqueta);
		btnJugar.setActionCommand(etiqueta);
		btnJugar.addActionListener(this);

	}

	public void inicializarBtnIniciar(JButton btnIniciar, String etiqueta) {
		btnIniciar.setText(etiqueta);
		btnIniciar.setActionCommand(etiqueta);
		btnIniciar.addActionListener(this);

	}
	
	public void inicializarBtnAdivinar(JButton btnIniciar, String etiqueta) {
		btnIniciar.setText(etiqueta);
		btnIniciar.setActionCommand(etiqueta);
		btnIniciar.addActionListener(this);

	}
	
	public void inicializarBtnArriesgarse(JButton btnIniciar, String etiqueta) {
		btnIniciar.setText(etiqueta);
		btnIniciar.setActionCommand(etiqueta);
		btnIniciar.addActionListener(this);

	}
	
	public void inicializarBtnJugarDeNuevo(JButton btnIniciar, String etiqueta) {
		btnIniciar.setText(etiqueta);
		btnIniciar.setActionCommand(etiqueta);
		btnIniciar.addActionListener(this);

	}
	
	public void inicializarBtnPuntaje(JButton btnIniciar, String etiqueta) {
		btnIniciar.setText(etiqueta);
		btnIniciar.setActionCommand(etiqueta);
		btnIniciar.addActionListener(this);

	}

	public void ocultarElementosInicio() {
		interfaz.ocultarElementosInicio();
		
	}
	
	public void refrescarPalabras(){
		interfaz.refrescarCantidadPalabras(palabra.length());
	}

	public void mostrarElementosJuego() {
		interfaz.mostrarElementosJuego();
		
	}

	public void refrescarLbl1(String letra) {
		interfaz.getLblL1().setText(letra);		
	}
	
	public void refrescarLbl2(String letra) {
		interfaz.getLblL2().setText(letra);		
	}
	
	public void refrescarLbl3(String letra) {
		interfaz.getLblL3().setText(letra);		
	}
	
	public void refrescarLbl4(String letra) {
		interfaz.getLblL4().setText(letra);		
	}
	
	public void refrescarLbl5(String letra) {
		interfaz.getLblL5().setText(letra);		
	}
	
	public void refrescarLbl6(String letra) {
		interfaz.getLblL6().setText(letra);		
	}
	
	public void refrescarLbl7(String letra) {
		interfaz.getLblL7().setText(letra);		
	}
	
	public void refrescarLbl8(String letra) {
		interfaz.getLblL8().setText(letra);		
	}
	
	public void refrescarLbl9(String letra) {
		interfaz.getLblL9().setText(letra);		
	}
	
	public void refrescarLbl10(String letra) {
		interfaz.getLblL10().setText(letra);		
	}
	
	public void refrescarLbl11(String letra) {
		interfaz.getLblL11().setText(letra);		
	}

	public void refrescarLbl(int i, String text) {
		
		if(i==0)
			refrescarLbl1(text);
		if(i==1)
			refrescarLbl2(text);
		if(i==2)
			refrescarLbl3(text);
		if(i==3)
			refrescarLbl4(text);
		if(i==4)
			refrescarLbl5(text);
		if(i==5)
			refrescarLbl6(text);
		if(i==6)
			refrescarLbl7(text);
		if(i==7)
			refrescarLbl8(text);
		if(i==8)
			refrescarLbl9(text);
		if(i==9)
			refrescarLbl10(text);
		if(i==10)
			refrescarLbl11(text);
		
	}

	public void dibujar(String pal) {
		
		if(pal.equals("cuerda"))
			interfaz.getLblCuerda().setVisible(true);
		else if(pal.equals("cabeza"))
			interfaz.getLblCabeza().setVisible(true);
		else if(pal.equals("tronco"))
			interfaz.getLblTronco().setVisible(true);
		else if(pal.equals("brazos"))
			interfaz.getLblBrazos().setVisible(true);
		else if(pal.equals("piernas"))
			interfaz.getLblPies().setVisible(true);
	}

	public void gameOver() {
		interfaz.ocultarTodosLosElementos("Has sido derrotado/a");
		
	}
	
	public void win(){
		interfaz.ocultarTodosLosElementos("Has ganado");
	}
	
	public boolean validar(){
		boolean hayGanador = false;
		if(palabra.length()==1){
			if(!(interfaz.getLblL1().getText().equals("")) )
				hayGanador = true;
		}
		
		else if(palabra.length()==2){
			if(!(interfaz.getLblL1().getText().equals("")) && !(interfaz.getLblL2().getText().equals("")) )
				hayGanador = true;
		}
		
		else if(palabra.length()==3){
			if(!(interfaz.getLblL1().getText().equals("")) && !(interfaz.getLblL2().getText().equals("")) && !(interfaz.getLblL3().getText().equals("")) )
				hayGanador = true;
		}
		
		else if(palabra.length()==4){
			if(!(interfaz.getLblL1().getText().equals("")) && !(interfaz.getLblL2().getText().equals("")) && !(interfaz.getLblL3().getText().equals(""))
					 && !(interfaz.getLblL4().getText().equals("")))
				hayGanador = true;
		}
		
		else if(palabra.length()==5){
			if(!(interfaz.getLblL1().getText().equals("")) && !(interfaz.getLblL2().getText().equals("")) && !(interfaz.getLblL3().getText().equals(""))
					 && !(interfaz.getLblL4().getText().equals("")) && !(interfaz.getLblL5().getText().equals("")))
				hayGanador = true;
		}
		
		else if(palabra.length()==6){
			if(!(interfaz.getLblL1().getText().equals("")) && !(interfaz.getLblL2().getText().equals("")) && !(interfaz.getLblL3().getText().equals(""))
					 && !(interfaz.getLblL4().getText().equals("")) && !(interfaz.getLblL5().getText().equals("")) && !(interfaz.getLblL6().getText().equals("")))
				hayGanador = true;
		}
		
		else if(palabra.length()==7){
			if(!(interfaz.getLblL1().getText().equals("")) && !(interfaz.getLblL2().getText().equals("")) && !(interfaz.getLblL3().getText().equals(""))
					 && !(interfaz.getLblL4().getText().equals("")) && !(interfaz.getLblL5().getText().equals("")) && !(interfaz.getLblL6().getText().equals(""))
					 && !(interfaz.getLblL7().getText().equals("")) )
				hayGanador = true;
		}
		
		else if(palabra.length()==8){
			if(!(interfaz.getLblL1().getText().equals("")) && !(interfaz.getLblL2().getText().equals("")) && !(interfaz.getLblL3().getText().equals(""))
					 && !(interfaz.getLblL4().getText().equals("")) && !(interfaz.getLblL5().getText().equals("")) && !(interfaz.getLblL6().getText().equals(""))
					 && !(interfaz.getLblL7().getText().equals("")) && !(interfaz.getLblL8().getText().equals("")) )
				hayGanador = true;
		}
		
		else if(palabra.length()==9){
			if(!(interfaz.getLblL1().getText().equals("")) && !(interfaz.getLblL2().getText().equals("")) && !(interfaz.getLblL3().getText().equals(""))
					 && !(interfaz.getLblL4().getText().equals("")) && !(interfaz.getLblL5().getText().equals("")) && !(interfaz.getLblL6().getText().equals(""))
					 && !(interfaz.getLblL7().getText().equals("")) && !(interfaz.getLblL8().getText().equals("")) && !(interfaz.getLblL9().getText().equals("")) )
				hayGanador = true;
		}
		
		else if(palabra.length()==10){
			if(!(interfaz.getLblL1().getText().equals("")) && !(interfaz.getLblL2().getText().equals("")) && !(interfaz.getLblL3().getText().equals(""))
					 && !(interfaz.getLblL4().getText().equals("")) && !(interfaz.getLblL5().getText().equals("")) && !(interfaz.getLblL6().getText().equals(""))
					 && !(interfaz.getLblL7().getText().equals("")) && !(interfaz.getLblL8().getText().equals("")) && !(interfaz.getLblL9().getText().equals(""))
					 && !(interfaz.getLblL10().getText().equals("")) )
				hayGanador = true;
		}
		
		else if(palabra.length()==11){
			if(!(interfaz.getLblL1().getText().equals("")) && !(interfaz.getLblL2().getText().equals("")) && !(interfaz.getLblL3().getText().equals(""))
					 && !(interfaz.getLblL4().getText().equals("")) && !(interfaz.getLblL5().getText().equals("")) && !(interfaz.getLblL6().getText().equals(""))
					 && !(interfaz.getLblL7().getText().equals("")) && !(interfaz.getLblL8().getText().equals("")) && !(interfaz.getLblL9().getText().equals(""))
					 && !(interfaz.getLblL10().getText().equals("")) && !(interfaz.getLblL11().getText().equals("")))
				hayGanador = true;
		}
		
		return hayGanador;
		
	}

}
