package control;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejecutar{

	private Consultas consultas;
	private String consultaGeneral;
	public final static String BD = "P09728_1_1";
	public final static String URL = "jdbc:mysql://200.3.193.22:3306/";
	public final static String USUARIO = "P09728_1_1";
	public final static String CONTRASENA = "RMYVdRTZ";
	public final static String CONTROLADOR = "com.mysql.jdbc.Driver";
	public final static String TABLA_INVESTIGADORES = "Investigadores";
	public final static String TABLA_PROYECTO_INVESTIGADOR = "ProyectoInvestigador";
	public final static String TABLA_PROYECTOS = "Proyectos";
	private static final int PUERTO = 9500;

	private static Connection conexion;
	private static Statement st;
	private static ResultSet resultado;

	private DataInputStream entrada;
	private DataOutputStream salida;

	private ServerSocket ss;

	public static void main(String[] args) {
		Ejecutar e = new Ejecutar();
		//		e.iniciarInterfazGrafica();
		e.iniciarModelo();
		try {
			e.ss = new ServerSocket(PUERTO);
			e.escucharCliente();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private void escucharCliente() throws IOException, ClassNotFoundException, SQLException {

		while(true){
			if(ss.isClosed() == true){
				ss = new ServerSocket(PUERTO);
			}
			Socket cs = ss.accept();

			DataInputStream in = new DataInputStream(cs.getInputStream());
			String mensaje = "";
			System.out.println("Escuchando al cliente");
			int i=0;
			
			while(cs.isClosed()==false && (mensaje=in.readUTF()) != null){

				System.out.println("Entrando al while del servidor");
				System.out.println("Este es el mensaje recibido: "+mensaje);

				if( mensaje.equals("consulta_i") ){
					System.out.println("CLIENTE: "+mensaje);
					consulta_i();

					String respuesta = "Se crearon las tablas ejecutando la siguiente consulta: \n"+consultaGeneral;
					salida = new DataOutputStream(cs.getOutputStream());
					salida.writeUTF(respuesta);
					System.out.println("SERVER: Respuesta enviada "+i++);
					cs.close();
				}

				else if( mensaje.equals("consulta_ii") ){
					System.out.println("CLIENTE: "+mensaje);
					int valor = consulta_ii();

					String respuesta1 = "consulta2###El presupuesto total dado a los proyectos de la línea \"Análisis de imagen\" es = $"
							+valor+"\n";
					String respuesta2 = "consulta2###Se obtuvo el resultado usando la siguiente consulta \n";
					String respuesta3 = "consulta2###"+consultaGeneral+"\n";
					salida = new DataOutputStream(cs.getOutputStream());
					salida.writeUTF(respuesta1);
					salida.writeUTF(respuesta2);
					salida.writeUTF(respuesta3);
					cs.close();
				}

				else if( mensaje.equals("consulta_iii") ){
					System.out.println("CLIENTE: "+mensaje);
					String datos = consulta_iii();

					String respuesta1 = "consulta3###Los líderes de proyectos y su título académico son: \n";
					String respuesta2 = "consulta3###"+datos+"\n";
					String respuesta3 = "consulta3###Se obtuvo el resultado usando la siguiente consulta: \n";
					String respuesta4 = "consulta3###"+consultaGeneral+" \n";
					salida = new DataOutputStream(cs.getOutputStream());
					salida.writeUTF(respuesta1);
					salida.writeUTF(respuesta2);
					salida.writeUTF(respuesta3);
					salida.writeUTF(respuesta4);
					cs.close();
				}

				else if( mensaje.equals("consulta_iv") ){
					System.out.println("CLIENTE: "+mensaje);
					String datos = consulta_iv();

					String respuesta1 = "consulta4###Los proyectos y su presupuesto cuyo líder tiene título doctoral, son los siguientes: \n";
					String respuesta2 = "consulta4###"+datos+"\n";
					String respuesta3 = "consulta4###Se obtuvo el resultado usando la siguiente consulta: \n";
					String respuesta4 = "consulta4###"+consultaGeneral+" \n";
					salida = new DataOutputStream(cs.getOutputStream());
					salida.writeUTF(respuesta1);
					salida.writeUTF(respuesta2);
					salida.writeUTF(respuesta3);
					salida.writeUTF(respuesta4);
					cs.close();
				}

				else if( mensaje.equals("consulta_v") ){
					System.out.println("CLIENTE: "+mensaje);
					String datos = consulta_v();

					String respuesta1 = "consulta5###Los investigadores que trabajan en el proyecto \"Diseño de aplicación móvil para detección de enfermedades\", son los siguientes: \n";
					String respuesta2 = "consulta5###"+datos+"\n";
					String respuesta3 = "consulta5###Se obtuvo el resultado usando la siguiente consulta: \n";
					String respuesta4 = "consulta5###"+consultaGeneral+" \n";
					salida = new DataOutputStream(cs.getOutputStream());
					salida.writeUTF(respuesta1);
					salida.writeUTF(respuesta2);
					salida.writeUTF(respuesta3);
					salida.writeUTF(respuesta4);
					cs.close();
				}

				else if( mensaje.equals("consulta_vi") ){
					System.out.println("CLIENTE: "+mensaje);
					consultaCrearRegistrosAuto();
					String respuesta1 = "consulta6###Los registros fueron creados usando la siguiente consulta: \n";
					String respuesta2 = "consulta6###"+consultaGeneral+" \n";
					salida = new DataOutputStream(cs.getOutputStream());
					salida.writeUTF(respuesta1);
					salida.writeUTF(respuesta2);
					cs.close();
				}

				else if( mensaje.equals("consulta_vii") ){
					System.out.println("CLIENTE: "+mensaje);
					consultaEliminarTablas();
					String respuesta1 = "consulta7###Las tablas fueron eliminadas ejecutando la siguiente consulta: \n";
					String respuesta2 = "consulta7###"+consultaGeneral+" \n";
					salida = new DataOutputStream(cs.getOutputStream());
					salida.writeUTF(respuesta1);
					salida.writeUTF(respuesta2);
					cs.close();
				}

				else{
					System.out.println("SERVER: Nada que hacer");
					
				}
				
			}
			
			
		}
	}

	private void iniciarModelo() {
		consultas = new Consultas(this);
	}

	public static void conectarBD() throws ClassNotFoundException, SQLException{
		Class.forName(CONTROLADOR);
		conexion = DriverManager.getConnection(URL+BD, USUARIO, CONTRASENA);
	}

	public void consulta_i() throws SQLException, ClassNotFoundException{
		conectarBD();
		st = conexion.createStatement();
		consultas.consulta_i(st);		
	}

	public int consulta_ii() throws SQLException, ClassNotFoundException{
		conectarBD();
		st = conexion.createStatement();
		return consultas.consulta_ii(st, resultado);		
	}

	public String consulta_iii() throws SQLException, ClassNotFoundException{
		conectarBD();
		st = conexion.createStatement();
		return consultas.consulta_iii(st, resultado);		
	}

	public String consulta_iv() throws SQLException, ClassNotFoundException{
		conectarBD();
		st = conexion.createStatement();
		return consultas.consulta_iv(st, resultado);		
	}

	public String consulta_v() throws SQLException, ClassNotFoundException{
		conectarBD();
		st = conexion.createStatement();
		return consultas.consulta_v(st, resultado);		
	}

	public void consultaCrearRegistrosAuto() throws SQLException, ClassNotFoundException{
		conectarBD();
		st = conexion.createStatement();
		consultas.consultaCrearRegistrosAuto(st);
	}

	public void consultaEliminarTablas() throws SQLException, ClassNotFoundException{
		conectarBD();
		st = conexion.createStatement();
		consultas.consultaEliminarTablas(st);
	}
	
	public String getConsultaGeneral() {
		return consultaGeneral;
	}

	public void setConsultaGeneral(String consultaGeneral) {
		this.consultaGeneral = consultaGeneral;
	}
}
