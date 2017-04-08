package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketImpl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;

import modelo.Consultas;
import vista.Interfaz;

public class Ejecutar implements ActionListener{
	
	private Interfaz ventana;
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
		ss = new ServerSocket(PUERTO);
		Socket cs = ss.accept();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(cs.getInputStream()));
		String mensaje = "";
		System.out.println("Escuchando al cliente");
		
		while((mensaje=in.readLine()) != null){
			System.out.println("Entrando al while del servidor");
			mensaje = in.readLine();
			if( mensaje.equals("consulta_i") ){
				System.out.println("Cliente envió una consulta");
				System.out.println(mensaje);
				consulta_i();
				
				String respuesta = "Se crearon las tablas ejecutando la siguiente consulta: \n"+consultaGeneral;
				salida = new DataOutputStream(cs.getOutputStream());
				salida.writeUTF(respuesta);
				cs.close();
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
	
	public void iniciarInterfazGrafica(){
		ventana = new Interfaz(this);
		ventana.setVisible(true);
	}

	public void inicializarBtnCrearTablas(JButton boton, String etiqueta) {
		boton.setText( etiqueta );
        boton.setFocusable( false );
        boton.setActionCommand( etiqueta );
        boton.addActionListener( this );
	}

	public void inicializarBtnEjecutarConsulta_ii(JButton boton, String etiqueta) {
		boton.setText( etiqueta );
        boton.setFocusable( false );
        boton.setActionCommand( etiqueta );
        boton.addActionListener( this );
	}

	public void inicializarBtnEjecutarConsulta_iii(JButton boton, String etiqueta) {
		boton.setText( etiqueta );
        boton.setFocusable( false );
        boton.setActionCommand( etiqueta );
        boton.addActionListener( this );
	}

	public void inicializarBtnEjecutarConsulta_iv(JButton boton, String etiqueta) {
		boton.setText( etiqueta );
        boton.setFocusable( false );
        boton.setActionCommand( etiqueta );
        boton.addActionListener( this );
	}

	public void inicializarBtnEjecutarConsulta_v(JButton boton, String etiqueta) {
		boton.setText( etiqueta );
        boton.setFocusable( false );
        boton.setActionCommand( etiqueta );
        boton.addActionListener( this );
	}
	
	public void inicializarBtnAgregarUnRegistro(JButton boton, String etiqueta) {
		boton.setText( etiqueta );
        boton.setFocusable( false );
        boton.setActionCommand( etiqueta );
        boton.addActionListener( this );
		
	}

	public void inicializarBtnAgregarRegistrosauto(JButton boton, String etiqueta) {
		boton.setText( etiqueta );
        boton.setFocusable( false );
        boton.setActionCommand( etiqueta );
        boton.addActionListener( this );
	}

	public void inicializarBtnEliminarUnRegistro(JButton boton, String etiqueta) {
		boton.setText( etiqueta );
        boton.setFocusable( false );
        boton.setActionCommand( etiqueta );
        boton.addActionListener( this );
	}

	public void inicializarBtnEliminarTablas(JButton boton, String etiqueta) {
		boton.setText( etiqueta );
        boton.setFocusable( false );
        boton.setActionCommand( etiqueta );
        boton.addActionListener( this );
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String comando = e.getActionCommand();
		
		if( comando.equals(Interfaz.CONSULTA_i) ){
			ventana.getTextResultado().setText("Se ejecutó la consulta 1");
			try {
				consulta_i();
				
				ventana.getTextResultado().setText("Se crearon las tablas ejecutando la siguiente consulta: \n"+consultaGeneral);
			} catch (SQLException e1) {
				ventana.getTextResultado().setText(e1.getMessage());
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				ventana.getTextResultado().setText(e1.getMessage());
				e1.printStackTrace();
			}
		}
		
		else if( comando.equals(Interfaz.CONSULTA_ii) ){
			try {
				int valor = consulta_ii();
				ventana.getTextResultado().setText("El presupuesto total dado a los proyectos de la línea \"Análisis de imagen\" es = $"
				+valor + " \n\nSe obtuvo el resultado usando la siguiente consulta \n" + consultaGeneral);
			} catch (ClassNotFoundException | SQLException e1) {
				ventana.getTextResultado().setText(e1.getMessage());
				e1.printStackTrace();
			}
			
		}
		
		else if( comando.equals(Interfaz.CONSULTA_iii) ){
			try {
				String datos = consulta_iii();
				ventana.getTextResultado().setText("Los líderes de proyectos y su título académico son: \n"
						+datos + " \n\nSe obtuvo el resultado usando la siguiente consulta \n" + consultaGeneral);
			} catch (ClassNotFoundException | SQLException e1) {
				ventana.getTextResultado().setText(e1.getMessage());
				e1.printStackTrace();
			}
		}
		
		else if( comando.equals(Interfaz.CONSULTA_iv) ){
			try {
				String datos = consulta_iv();
				ventana.getTextResultado().setText("Los proyectos y su presupuesto cuyo líder tiene título doctoral, son los siguientes: \n"
						+datos + " \n\nSe obtuvo el resultado usando la siguiente consulta \n" + consultaGeneral);
			} catch (ClassNotFoundException | SQLException e1) {
				ventana.getTextResultado().setText(e1.getMessage());
				e1.printStackTrace();
			}
		}
		
		else if( comando.equals(Interfaz.CONSULTA_v) ){
			try {
				String datos = consulta_v();
				ventana.getTextResultado().setText("Los investigadores que trabajan en el proyecto \"Diseño de aplicación móvil para detección de enfermedades\", son los siguientes: \n"
						+datos + " \n\nSe obtuvo el resultado usando la siguiente consulta \n" + consultaGeneral);
			} catch (ClassNotFoundException | SQLException e1) {
				ventana.getTextResultado().setText(e1.getMessage());
				e1.printStackTrace();
			}
		}
		
		else if( comando.equals(Interfaz.ELIMINAR_UN_REGISTRO) ){
			System.out.println("Escucha eliminar un registro");
			ventana.getTextResultado().setText("Se ejecutó eliminar un registro");
		}
		
		else if( comando.equals(Interfaz.ELIMINAR_TABLAS) ){
			try {
				consultaEliminarTablas();
				ventana.getTextResultado().setText("Las tablas fueron eliminadas ejecutando la siguiente consulta \n"+consultaGeneral);
			} catch (ClassNotFoundException | SQLException e1) {
				ventana.getTextResultado().setText(e1.getMessage());
				e1.printStackTrace();
			}
			
		}
		
		else if( comando.equals(Interfaz.AGREGAR_UN_REGISTRO) ){
			System.out.println("Escucha consulta agregar un registro");
			ventana.getTextResultado().setText("Se ejecutó la consulta agregar un registro");
		}
		
		else if( comando.equals(Interfaz.AGREGAR_REGISTROS_AUTO) ){
			try {
				consultaCrearRegistrosAuto();
				ventana.getTextResultado().setText("Los registros fueron creados usando la siguiente consulta \n"+consultaGeneral);
			} catch (ClassNotFoundException | SQLException e1) {
				ventana.getTextResultado().setText(e1.getMessage());
				e1.printStackTrace();
			}
		}
	}

	public String getConsultaGeneral() {
		return consultaGeneral;
	}

	public void setConsultaGeneral(String consultaGeneral) {
		this.consultaGeneral = consultaGeneral;
	}
}
