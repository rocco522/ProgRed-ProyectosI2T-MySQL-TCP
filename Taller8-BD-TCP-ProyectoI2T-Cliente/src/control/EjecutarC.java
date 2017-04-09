package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.SQLException;
import javax.swing.JButton;

import vista.Interfaz;

public class EjecutarC implements ActionListener{

	private Interfaz ventana;
	private static final int PUERTO = 9500;
	private static final String HOST = "localhost";

	private Socket canal;

	private DataOutputStream dos;

	public static void main(String[] args) {
		EjecutarC e = new EjecutarC();
		e.iniciarInterfazGrafica();
	}

	private void iniciarSocket() throws UnknownHostException, IOException {
		System.out.println("ABIERTO: Conexión abierta con el servidor -------------------------------------------------------");
		System.out.println("Se empezó a escuchar al servidor");
		canal = new Socket(HOST, PUERTO);
	}

	public void cerrarSocket() throws IOException{
		canal.close();
		System.out.println("CERRADO: Conexión cerrada con el servidor -------------------------------------------------------");
	}

	private void escucharServidor() throws IOException{


		BufferedReader in = new BufferedReader(new InputStreamReader(canal.getInputStream()));
		System.out.println("Se obtuvo el mensaje");
		String mensaje = "";
		String imprimir = "";
		System.out.println("Tratando de ingresar al While");

		while((mensaje = in.readLine()) != null ){
			//Consulta_i
			if(mensaje.contains("CREATE TABLE IF NOT EXISTS") || mensaje.contains("Se crearon las tablas ejecutando la siguiente consulta")){
				System.out.println("SERVER: "+mensaje);
				imprimir += mensaje+"\n";
			}

			//Consulta_ii
			else if(mensaje.contains("consulta2")){
				System.out.println("SERVER: "+mensaje);
				String[] temp = mensaje.split("###");
				imprimir += temp[1]+"\n";

			}

			//Consulta_iii
			else if(mensaje.contains("consulta3")){
				System.out.println("SERVER: "+mensaje);
				String[] temp = mensaje.split("###");
				if(temp[1].contains("===")){
					String[] temp2 = temp[1].split("===");
					String datosTemp = "";
					for(int i=0; i<temp2.length; i++ ){
						datosTemp += temp2[i]+"\n";
					}
					temp[1] = datosTemp;
				}
				imprimir += temp[1]+"\n";	
			}

			//Consulta_iv
			else if(mensaje.contains("consulta4")){
				System.out.println("SERVER: "+mensaje);
				String[] temp = mensaje.split("###");
				if(temp[1].contains("===")){
					String[] temp2 = temp[1].split("===");
					String datosTemp = "";
					for(int i=0; i<temp2.length; i++ ){
						datosTemp += temp2[i]+"\n";
					}
					temp[1] = datosTemp;
				}
				imprimir += temp[1]+"\n";	
			}

			//Consulta_v
			else if(mensaje.contains("consulta5")){
				System.out.println("SERVER: "+mensaje);
				String[] temp = mensaje.split("###");
				if(temp[1].contains("===")){
					String[] temp2 = temp[1].split("===");
					String datosTemp = "";
					for(int i=0; i<temp2.length; i++ ){
						datosTemp += temp2[i]+"\n";
					}
					temp[1] = datosTemp;
				}
				imprimir += temp[1]+"\n";	
			}

			//Consulta_vi agregar registros automaticamente
			else if(mensaje.contains("consulta6")){
				System.out.println("SERVER: "+mensaje);
				String[] temp = mensaje.split("###");
				if(temp[1].contains("===")){
					String[] temp2 = temp[1].split("===");
					String datosTemp = "";
					for(int i=0; i<temp2.length; i++ ){
						datosTemp += temp2[i]+"\n";
					}
					temp[1] = datosTemp;
				}
				imprimir += temp[1]+"\n";	
			}

			//Consulta_vi agregar registros automaticamente
			else if(mensaje.contains("consulta7")){
				System.out.println("SERVER: "+mensaje);
				String[] temp = mensaje.split("###");
				if(temp[1].contains("===")){
					String[] temp2 = temp[1].split("===");
					String datosTemp = "";
					for(int i=0; i<temp2.length; i++ ){
						datosTemp += temp2[i]+"\n";
					}
					temp[1] = datosTemp;
				}
				imprimir += temp[1]+"\n";	
			}
			else{
				System.out.println("nada que hacer en esta pasada");
			}
		}
		imprimir = imprimir.replace("Ã¡", "á");
		imprimir = imprimir.replace("Ã­", "í");
		imprimir = imprimir.replace("Ã©", "é");
		imprimir = imprimir.replace("Ã³", "ó");
		imprimir = imprimir.replace("Ãº", "ú");
		imprimir = imprimir.replace("Ã±", "ñ");
		ventana.getTextResultado().setText(imprimir);



	}



	public void consulta_i() throws SQLException, ClassNotFoundException, IOException{
		iniciarSocket();
		dos = new DataOutputStream(canal.getOutputStream());
		dos.writeUTF("consulta_i");
		System.out.println("Se envio mensaje al servidor");
		escucharServidor();	
		System.out.println("Se terminó de escuchar al servidor");
		cerrarSocket();
	}

	public void consulta_ii() throws SQLException, ClassNotFoundException, IOException{
		iniciarSocket();
		dos = new DataOutputStream(canal.getOutputStream());
		dos.writeUTF("consulta_ii");
		escucharServidor();
		cerrarSocket();
	}

	public void consulta_iii() throws SQLException, ClassNotFoundException, IOException{	

		iniciarSocket();
		dos = new DataOutputStream(canal.getOutputStream());
		dos.writeUTF("consulta_iii");
		escucharServidor();
		cerrarSocket();
	}

	public void consulta_iv() throws SQLException, ClassNotFoundException, IOException{	

		iniciarSocket();
		dos = new DataOutputStream(canal.getOutputStream());
		dos.writeUTF("consulta_iv");
		escucharServidor();
		cerrarSocket();
	}

	public void consulta_v() throws SQLException, ClassNotFoundException, IOException{	

		iniciarSocket();
		dos = new DataOutputStream(canal.getOutputStream());
		dos.writeUTF("consulta_v");
		escucharServidor();
		cerrarSocket();
	}

	public void consultaCrearRegistrosAuto() throws SQLException, ClassNotFoundException, IOException{

		iniciarSocket();
		dos = new DataOutputStream(canal.getOutputStream());
		dos.writeUTF("consulta_vi");
		escucharServidor();
		cerrarSocket();
	}

	public void consultaEliminarTablas() throws SQLException, ClassNotFoundException, IOException{

		iniciarSocket();
		dos = new DataOutputStream(canal.getOutputStream());
		dos.writeUTF("consulta_vii");
		escucharServidor();
		cerrarSocket();
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
			try {
				consulta_ii();
			} catch (ClassNotFoundException | SQLException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

		else if( comando.equals(Interfaz.CONSULTA_iii) ){
			try {
				consulta_iii();
			} catch (ClassNotFoundException | SQLException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		else if( comando.equals(Interfaz.CONSULTA_iv) ){
			try {
				consulta_iv();
			} catch (ClassNotFoundException | SQLException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		else if( comando.equals(Interfaz.CONSULTA_v) ){
			try {
				consulta_v();
			} catch (ClassNotFoundException | SQLException | IOException e1) {
				// TODO Auto-generated catch block
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
			} catch (ClassNotFoundException | SQLException | IOException e1) {
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
			} catch (ClassNotFoundException | SQLException | IOException e1) {
				ventana.getTextResultado().setText("Duplicate entry '1' for key 'PRIMARY'");
				e1.printStackTrace();
			}
		}
	}
}
