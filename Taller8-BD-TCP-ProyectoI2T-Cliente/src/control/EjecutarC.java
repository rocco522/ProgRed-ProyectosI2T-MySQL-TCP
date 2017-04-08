package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;

import modelo.Consultas;
import vista.Interfaz;

public class EjecutarC implements ActionListener{
	
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
	private static final String HOST = "localhost";

	private static Connection conexion;
	private static Statement st;
	private static ResultSet resultado;
	
	private Socket canal;
	
	private DataOutputStream dos;
	private DataInputStream dis;
	private OutputStream os;
	private InputStream is;

	public static void main(String[] args) {
		EjecutarC e = new EjecutarC();
		e.iniciarInterfazGrafica();
		e.iniciarModelo();
		try {
			e.iniciarSocket();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	private void iniciarSocket() throws UnknownHostException, IOException {
		canal = new Socket(HOST, PUERTO);
		
	}
	
	private void escucharServidor() throws IOException{
		System.out.println("Se empezó a escuchar al servidor");
//		BufferedReader in = new BufferedReader(new InputStreamReader(canal.getInputStream()));
		DataInputStream in = new DataInputStream(canal.getInputStream());
		System.out.println("Se obtuvo el mensaje");
		String mensaje = in.readUTF();
		while(mensaje != null ){
			System.out.println("Respuesta del servidor");
		System.out.println(mensaje);
		}
		
		canal.close();
	}

	private void iniciarModelo() {
		consultas = new Consultas(this);
	}

	
	public void consulta_i() throws SQLException, ClassNotFoundException, IOException{
		if(canal.isClosed())
			iniciarSocket();
		dos = new DataOutputStream(canal.getOutputStream());
		dos.writeUTF("consulta_i");
		System.out.println("Se envio mensaje al servidor");
		escucharServidor();
		canal.close();
		
	}
	
	public void consulta_ii() throws SQLException, ClassNotFoundException, IOException{
		if(canal.isClosed())
			iniciarSocket();
		dos = new DataOutputStream(canal.getOutputStream());
		dos.writeUTF("consulta_i");
		canal.close();
	}
	
	public void consulta_iii() throws SQLException, ClassNotFoundException, IOException{	
		if(canal.isClosed())
			iniciarSocket();
		dos = new DataOutputStream(canal.getOutputStream());
		dos.writeUTF("consulta_i");
		canal.close();
	}
	
	public void consulta_iv() throws SQLException, ClassNotFoundException, IOException{	
		if(canal.isClosed())
			iniciarSocket();
		dos = new DataOutputStream(canal.getOutputStream());
		dos.writeUTF("consulta_i");
		canal.close();
	}
	
	public void consulta_v() throws SQLException, ClassNotFoundException, IOException{	
		if(canal.isClosed())
			iniciarSocket();
		dos = new DataOutputStream(canal.getOutputStream());
		dos.writeUTF("consulta_i");
		canal.close();
	}
	
	public void consultaCrearRegistrosAuto() throws SQLException, ClassNotFoundException, IOException{
		if(canal.isClosed())
			iniciarSocket();
		dos = new DataOutputStream(canal.getOutputStream());
		dos.writeUTF("consulta_i");
		canal.close();
	}
	
	public void consultaEliminarTablas() throws SQLException, ClassNotFoundException, IOException{
		if(canal.isClosed())
			iniciarSocket();
		dos = new DataOutputStream(canal.getOutputStream());
		dos.writeUTF("consulta_i");
		canal.close();
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
			try {
				consulta_i();
			} catch (ClassNotFoundException | SQLException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		else if( comando.equals(Interfaz.CONSULTA_ii) ){
			
		}
		
		else if( comando.equals(Interfaz.CONSULTA_iii) ){
		}
		
		else if( comando.equals(Interfaz.CONSULTA_iv) ){
		}
		
		else if( comando.equals(Interfaz.CONSULTA_v) ){
		}
		
		else if( comando.equals(Interfaz.ELIMINAR_UN_REGISTRO) ){
			System.out.println("Escucha eliminar un registro");
			ventana.getTextResultado().setText("Se ejecutó eliminar un registro");
		}
		
		else if( comando.equals(Interfaz.ELIMINAR_TABLAS) ){
			
		}
		
		else if( comando.equals(Interfaz.AGREGAR_UN_REGISTRO) ){
			System.out.println("Escucha consulta agregar un registro");
			ventana.getTextResultado().setText("Se ejecutó la consulta agregar un registro");
		}
		
		else if( comando.equals(Interfaz.AGREGAR_REGISTROS_AUTO) ){
		}
	}

	public String getConsultaGeneral() {
		return consultaGeneral;
	}

	public void setConsultaGeneral(String consultaGeneral) {
		this.consultaGeneral = consultaGeneral;
	}
}
