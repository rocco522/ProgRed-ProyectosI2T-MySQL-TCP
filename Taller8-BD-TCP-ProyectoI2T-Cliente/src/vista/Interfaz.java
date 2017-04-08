package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import control.EjecutarC;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JTextArea;

public class Interfaz extends JFrame {

	public static final String CONSULTA_i = "Crear tablas";
	public static final String CONSULTA_ii = "Ejecutar consulta ii";
	public static final String CONSULTA_iii = "Ejecutar consulta iii";
	public static final String CONSULTA_iv = "Ejecutar consulta iv";
	public static final String CONSULTA_v = "Ejecutar consulta v";
	public static final String AGREGAR_UN_REGISTRO = "Agregar un registro";
	public static final String AGREGAR_REGISTROS_AUTO = "Agregar registros (auto)";
	public static final String ELIMINAR_TABLAS = "Eliminar tablas";
	public static final String ELIMINAR_UN_REGISTRO = "Eliminar un registro";

	private JPanel contentPane;
	
	private EjecutarC e;

	private JButton btnCrearTablas;

	private JButton btnEjecutarConsulta_ii;

	private JButton btnEjecutarConsulta_iii;

	private JButton btnEjecutarConsulta_iv;

	private JButton btnEjecutarConsulta_v;
	private JTextArea textResultado;
	private JButton btnAgregarUnRegistro;
	private JButton btnAgregarRegistrosauto;
	private JButton btnEliminarUnRegistro;
	private JButton btnEliminarTablas;
	private JLabel lblGrupoDeInvestigacin;

	/**
	 * Create the frame.
	 * @param ejecutar 
	 */
	public Interfaz(EjecutarC ejecutar) {
		this.e = ejecutar;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCrearTablas = new JLabel("i. Crear todas las tablas propuestas en el modelo");
		lblCrearTablas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCrearTablas.setBounds(10, 65, 400, 40);
		contentPane.add(lblCrearTablas);
		
		JLabel lblConsultarMonto = new JLabel("<html>ii. Consultar el monto total de dinero dado a los proyectos <br> "
				+ "de investigación asociados a la línea \"Análisis de imágen\"</html>");
		lblConsultarMonto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblConsultarMonto.setBounds(10, 157, 400, 40);
		contentPane.add(lblConsultarMonto);
		
		JLabel lblIdentificacionLideres = new JLabel("<html>iii. Identificación, nombre y máximo título académico de <br> "
				+ "aquellos investigadores que son líderes de proyectos</html>");
		lblIdentificacionLideres.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIdentificacionLideres.setBounds(10, 254, 400, 40);
		contentPane.add(lblIdentificacionLideres);
		
		JLabel lblConsultaLiderTituloDoctoral = new JLabel("<html>iv. Consultar el nombre y presupuesto asignado de los proyectos <br> "
				+ "cuyo lider tenga título doctoral</html>");
		lblConsultaLiderTituloDoctoral.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblConsultaLiderTituloDoctoral.setBounds(412, 65, 400, 40);
		contentPane.add(lblConsultaLiderTituloDoctoral);
		
		JLabel lblNombreInvest = new JLabel("<html>V. Nombre de los investigadores que están participando en el <br> "
				+ "proyecto \"Diseño de aplicación móvil para detección de enfermedades\"</html>");
		lblNombreInvest.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombreInvest.setBounds(412, 157, 400, 40);
		contentPane.add(lblNombreInvest);
		
		btnCrearTablas = new JButton(CONSULTA_i);
		btnCrearTablas.setForeground(SystemColor.inactiveCaptionBorder);
		btnCrearTablas.setBackground(SystemColor.textHighlight);
		btnCrearTablas.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCrearTablas.setBounds(20, 106, 184, 30);
		e.inicializarBtnCrearTablas(btnCrearTablas, CONSULTA_i);
		contentPane.add(btnCrearTablas);
		
		btnEjecutarConsulta_ii = new JButton(CONSULTA_ii);
		btnEjecutarConsulta_ii.setForeground(SystemColor.inactiveCaptionBorder);
		btnEjecutarConsulta_ii.setBackground(SystemColor.textHighlight);
		btnEjecutarConsulta_ii.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEjecutarConsulta_ii.setBounds(20, 198, 184, 30);
		e.inicializarBtnEjecutarConsulta_ii(btnEjecutarConsulta_ii, CONSULTA_ii);
		contentPane.add(btnEjecutarConsulta_ii);
		
		btnEjecutarConsulta_iii = new JButton(CONSULTA_ii);
		btnEjecutarConsulta_iii.setForeground(SystemColor.inactiveCaptionBorder);
		btnEjecutarConsulta_iii.setBackground(SystemColor.textHighlight);
		btnEjecutarConsulta_iii.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEjecutarConsulta_iii.setBounds(20, 295, 184, 30);
		e.inicializarBtnEjecutarConsulta_iii(btnEjecutarConsulta_iii, CONSULTA_iii);
		contentPane.add(btnEjecutarConsulta_iii);
		
		btnEjecutarConsulta_iv = new JButton(CONSULTA_iv);
		btnEjecutarConsulta_iv.setForeground(SystemColor.inactiveCaptionBorder);
		btnEjecutarConsulta_iv.setBackground(SystemColor.textHighlight);
		btnEjecutarConsulta_iv.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEjecutarConsulta_iv.setBounds(422, 106, 184, 30);
		e.inicializarBtnEjecutarConsulta_iv(btnEjecutarConsulta_iv, CONSULTA_iv);
		contentPane.add(btnEjecutarConsulta_iv);
		
		btnEjecutarConsulta_v = new JButton(CONSULTA_v);
		btnEjecutarConsulta_v.setForeground(SystemColor.inactiveCaptionBorder);
		btnEjecutarConsulta_v.setBackground(SystemColor.textHighlight);
		btnEjecutarConsulta_v.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEjecutarConsulta_v.setBounds(422, 198, 184, 30);
		e.inicializarBtnEjecutarConsulta_v(btnEjecutarConsulta_v, CONSULTA_v);
		contentPane.add(btnEjecutarConsulta_v);
		
		textResultado = new JTextArea();
		textResultado.setWrapStyleWord(true);
		textResultado.setForeground(SystemColor.text);
		textResultado.setBackground(SystemColor.textHighlight);
		textResultado.setEditable(false);
		textResultado.setBounds(10, 416, 864, 134);
		contentPane.add(textResultado);
		
		//luego creamos un JScrollPane que contendra el text area
        JScrollPane scroll = new JScrollPane( textResultado );
        scroll.setBounds(10, 416, 864, 134);
        
        //finalmente se agrega el scroll pane al formulario
        contentPane.add( scroll, BorderLayout.CENTER );
		
		JLabel label = new JLabel("<html>Resultado de la consulta</html>");
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setBounds(10, 365, 400, 40);
		contentPane.add(label);
		
		JLabel lblAccionesAdicionales = new JLabel("Acciones adicionales:");
		lblAccionesAdicionales.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAccionesAdicionales.setBounds(412, 254, 400, 40);
		contentPane.add(lblAccionesAdicionales);
		
		btnAgregarUnRegistro = new JButton(AGREGAR_UN_REGISTRO);
		btnAgregarUnRegistro.setForeground(SystemColor.inactiveCaptionBorder);
		btnAgregarUnRegistro.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAgregarUnRegistro.setBackground(SystemColor.textHighlight);
		btnAgregarUnRegistro.setBounds(422, 300, 184, 30);
		e.inicializarBtnAgregarUnRegistro(btnAgregarUnRegistro, AGREGAR_UN_REGISTRO);
		contentPane.add(btnAgregarUnRegistro);
		
		btnAgregarRegistrosauto = new JButton(AGREGAR_REGISTROS_AUTO);
		btnAgregarRegistrosauto.setForeground(SystemColor.inactiveCaptionBorder);
		btnAgregarRegistrosauto.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAgregarRegistrosauto.setBackground(SystemColor.textHighlight);
		btnAgregarRegistrosauto.setBounds(628, 300, 184, 30);
		e.inicializarBtnAgregarRegistrosauto(btnAgregarRegistrosauto, AGREGAR_REGISTROS_AUTO);
		contentPane.add(btnAgregarRegistrosauto);
		
		btnEliminarUnRegistro = new JButton(ELIMINAR_UN_REGISTRO);
		btnEliminarUnRegistro.setForeground(SystemColor.inactiveCaptionBorder);
		btnEliminarUnRegistro.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEliminarUnRegistro.setBackground(SystemColor.textHighlight);
		btnEliminarUnRegistro.setBounds(422, 340, 184, 30);
		e.inicializarBtnEliminarUnRegistro(btnEliminarUnRegistro, ELIMINAR_UN_REGISTRO);
		contentPane.add(btnEliminarUnRegistro);
		
		btnEliminarTablas = new JButton(ELIMINAR_TABLAS);
		btnEliminarTablas.setForeground(SystemColor.inactiveCaptionBorder);
		btnEliminarTablas.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEliminarTablas.setBackground(SystemColor.textHighlight);
		btnEliminarTablas.setBounds(628, 340, 184, 30);
		e.inicializarBtnEliminarTablas(btnEliminarTablas, ELIMINAR_TABLAS);
		contentPane.add(btnEliminarTablas);
		
		lblGrupoDeInvestigacin = new JLabel("Grupo de investigaci\u00F3n I2T");
		lblGrupoDeInvestigacin.setForeground(SystemColor.textHighlight);
		lblGrupoDeInvestigacin.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblGrupoDeInvestigacin.setBounds(10, 11, 429, 40);
		contentPane.add(lblGrupoDeInvestigacin);
	}

	public JTextArea getTextResultado() {
		return textResultado;
	}

	public void setTextResultado(JTextArea textResultado) {
		this.textResultado = textResultado;
	}
}
