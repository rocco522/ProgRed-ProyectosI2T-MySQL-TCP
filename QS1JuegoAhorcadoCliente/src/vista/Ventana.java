package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.EjecutarC;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Ventana extends JFrame {

	public static final String JUGAR = "Jugar";
	public static final String INICIAR = "Iniciar";
	public static final String ADIVINAR = "Adivinar";
	public static final String ARRIESGARSE = "Arriesgarse";
	public static final String OTRAVEZ = "Jugar de nuevo";
	public static final String PUNTAJE = "Enviar puntaje";
	private JPanel panel;


	private EjecutarC e;

	private JTextField txtNombre;
	private JButton btnJugar;
	private JLabel lblEscribaSuNombre;
	private JLabel lblSeleccioneUnaCategora;
	private JComboBox comboBox;
	private JButton btnIniciar;
	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lbl3;
	private JLabel lbl4;
	private JLabel lbl5;
	private JLabel lbl6;
	private JLabel lbl7;
	private JLabel lbl8;
	private JLabel lbl9;
	private JLabel lbl10;
	private JLabel lbl11;
	private JLabel lblEscribaUnaLetra;
	private JTextField txtLetra;
	private JButton btnAdivinar;
	private JLabel lblL1;
	private JLabel lblL2;
	private JLabel lblL3;
	private JLabel lblL4;
	private JLabel lblL5;
	private JLabel lblL6;
	private JLabel lblL7;
	private JLabel lblL8;
	private JLabel lblL9;
	private JLabel lblL10;
	private JLabel lblL11;
	private JLabel lblArbol1;
	private JLabel lblArbol2;
	private JLabel lblCuerda;
	private JLabel lblTronco;
	private JLabel lblCabeza;
	private JLabel lblBrazos;
	private JLabel lblPies;
	private JLabel lblPalabraCompleta;
	private JTextField txtPalabraCompleta;
	private JButton btnArriesgarse;
	private JLabel lblJugadasRealizadas;
	private JLabel lblJugadasRealizadas1;
	private JLabel lblJugadasRealizadas2;
	private JLabel lblHasSidoDerrotadoa;
	private JButton btnJugarDeNuevo;
	private JButton btnEnviarPuntaje;


	/**
	 * Create the frame.
	 * @param ejecutarC 
	 */
	public Ventana(EjecutarC ejecutarC) {

		this.e = ejecutarC;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		panel = new JPanel();
		panel.setBackground(SystemColor.text);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		lblHasSidoDerrotadoa = new JLabel();
		lblHasSidoDerrotadoa.setHorizontalAlignment(SwingConstants.CENTER);
		lblHasSidoDerrotadoa.setForeground(SystemColor.textHighlight);
		lblHasSidoDerrotadoa.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblHasSidoDerrotadoa.setBounds(10, 135, 900, 100);
		lblHasSidoDerrotadoa.setVisible(false);
		panel.add(lblHasSidoDerrotadoa);
		
		btnJugarDeNuevo = new JButton();
		btnJugarDeNuevo.setForeground(Color.WHITE);
		btnJugarDeNuevo.setBackground(SystemColor.textHighlight);
		btnJugarDeNuevo.setBounds(272, 319, 143, 32);
		btnJugarDeNuevo.setVisible(false);
		inicializarBtnJugarDeNuevo();
		panel.add(btnJugarDeNuevo);
		
		btnEnviarPuntaje = new JButton();
		btnEnviarPuntaje.setForeground(Color.WHITE);
		btnEnviarPuntaje.setBackground(SystemColor.textHighlight);
		btnEnviarPuntaje.setBounds(503, 322, 143, 32);
		btnEnviarPuntaje.setVisible(false);
		inicializarBtnPuntaje();
		panel.add(btnEnviarPuntaje);

		lblEscribaSuNombre = new JLabel("Escriba su nombre");
		lblEscribaSuNombre.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEscribaSuNombre.setBounds(26, 118, 117, 21);
		panel.add(lblEscribaSuNombre);

		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtNombre.setBounds(26, 150, 137, 32);
		panel.add(txtNombre);
		txtNombre.setColumns(10);

		btnJugar = new JButton();
		btnJugar.setForeground(SystemColor.text);
		btnJugar.setBackground(SystemColor.textHighlight);
		btnJugar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnJugar.setBounds(184, 150, 110, 32);
		inicializarBtnJugar();
		panel.add(btnJugar);

		lblSeleccioneUnaCategora = new JLabel("Seleccione una categor\u00EDa");
		lblSeleccioneUnaCategora.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSeleccioneUnaCategora.setBounds(26, 231, 268, 21);
		panel.add(lblSeleccioneUnaCategora);

		comboBox = new JComboBox();
		comboBox.setBounds(26, 263, 137, 32);
		panel.add(comboBox);

		btnIniciar = new JButton(INICIAR);
		btnIniciar.setForeground(SystemColor.text);
		btnIniciar.setBackground(SystemColor.textHighlight);
		btnIniciar.setBounds(184, 263, 110, 32);
		inicializarBtnIniciar();
		panel.add(btnIniciar);

		int ancho = 77;
		lbl1 = new JLabel("");
		lbl1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl1.setBounds(30, 405, ancho, 14);
		panel.add(lbl1);

		lbl2 = new JLabel("");
		lbl2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl2.setBounds(30+ancho, 405, ancho, 14);
		panel.add(lbl2);

		lbl3 = new JLabel("");
		lbl3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl3.setBounds(30+ancho*2, 405, ancho, 14);
		panel.add(lbl3);

		lbl4 = new JLabel("");
		lbl4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl4.setBounds(30+ancho*3, 405, ancho, 14);
		panel.add(lbl4);

		lbl5 = new JLabel("");
		lbl5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl5.setBounds(30+ancho*4, 405, ancho, 14);
		panel.add(lbl5);

		lbl6 = new JLabel("");
		lbl6.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl6.setBounds(30+ancho*5, 405, ancho, 14);
		panel.add(lbl6);

		lbl7 = new JLabel("");
		lbl7.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl7.setBounds(30+ancho*6, 405, ancho, 14);
		panel.add(lbl7);

		lbl8 = new JLabel("");
		lbl8.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl8.setBounds(30+ancho*7, 405, ancho, 14);
		panel.add(lbl8);

		lbl9 = new JLabel("");
		lbl9.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl9.setBounds(30+ancho*8, 405, ancho, 14);
		panel.add(lbl9);

		lbl10 = new JLabel("");
		lbl10.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl10.setBounds(30+ancho*9, 405, ancho, 14);
		panel.add(lbl10);

		lbl11 = new JLabel("");
		lbl11.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl11.setBounds(30+ancho*10, 405, ancho, 14);
		panel.add(lbl11);

		lblL1 = new JLabel("");
		lblL1.setHorizontalAlignment(SwingConstants.CENTER);
		lblL1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblL1.setBounds(10, 380, ancho, 32);
		panel.add(lblL1);

		lblL2 = new JLabel("");
		lblL2.setHorizontalAlignment(SwingConstants.CENTER);
		lblL2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblL2.setBounds(10+ancho*1, 380, ancho, 32);
		panel.add(lblL2);

		lblL3 = new JLabel("");
		lblL3.setHorizontalAlignment(SwingConstants.CENTER);
		lblL3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblL3.setBounds(10+ancho*2, 380, ancho, 32);
		panel.add(lblL3);

		lblL4 = new JLabel("");
		lblL4.setHorizontalAlignment(SwingConstants.CENTER);
		lblL4.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblL4.setBounds(10+ancho*3, 380, ancho, 32);
		panel.add(lblL4);

		lblL5 = new JLabel("");
		lblL5.setHorizontalAlignment(SwingConstants.CENTER);
		lblL5.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblL5.setBounds(10+ancho*4, 380, ancho, 32);
		panel.add(lblL5);

		lblL6 = new JLabel("");
		lblL6.setHorizontalAlignment(SwingConstants.CENTER);
		lblL6.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblL6.setBounds(10+ancho*5, 380, ancho, 32);
		panel.add(lblL6);

		lblL7 = new JLabel("");
		lblL7.setHorizontalAlignment(SwingConstants.CENTER);
		lblL7.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblL7.setBounds(10+ancho*6, 380, ancho, 32);
		panel.add(lblL7);

		lblL8 = new JLabel("");
		lblL8.setHorizontalAlignment(SwingConstants.CENTER);
		lblL8.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblL8.setBounds(10+ancho*7, 380, ancho, 32);
		panel.add(lblL8);

		lblL9 = new JLabel("");
		lblL9.setHorizontalAlignment(SwingConstants.CENTER);
		lblL9.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblL9.setBounds(10+ancho*8, 380, ancho, 32);
		panel.add(lblL9);

		lblL10 = new JLabel("");
		lblL10.setHorizontalAlignment(SwingConstants.CENTER);
		lblL10.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblL10.setBounds(10+ancho*9, 380, ancho, 32);
		panel.add(lblL10);

		lblL11 = new JLabel("");
		lblL11.setHorizontalAlignment(SwingConstants.CENTER);
		lblL11.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblL11.setBounds(10+ancho*10, 380, ancho, 32);
		panel.add(lblL11);

		JLabel lblJuegoDelAhorcado = new JLabel("Juego del ahorcado");
		lblJuegoDelAhorcado.setIcon(new ImageIcon("./data/images/banner.png"));
		lblJuegoDelAhorcado.setForeground(SystemColor.textHighlight);
		lblJuegoDelAhorcado.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblJuegoDelAhorcado.setBounds(0, 0, 900, 100);
		panel.add(lblJuegoDelAhorcado);

		lblEscribaUnaLetra = new JLabel("Escriba una letra:");
		lblEscribaUnaLetra.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEscribaUnaLetra.setBounds(26, 458, 94, 14);
		panel.add(lblEscribaUnaLetra);

		txtLetra = new JTextField(1);
		txtLetra.setHorizontalAlignment(SwingConstants.CENTER);
		txtLetra.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtLetra.setColumns(1);
		txtLetra.setBounds(130, 449, 40, 32);
		txtLetra.addKeyListener(new KeyListener(){

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyTyped(KeyEvent e) {				 
				if (txtLetra.getText().length()== 1)	 
					e.consume();
			}
		});
		txtLetra.setVisible(false);
		panel.add(txtLetra);

		btnAdivinar = new JButton(ADIVINAR);
		btnAdivinar.setForeground(Color.WHITE);
		btnAdivinar.setBackground(SystemColor.textHighlight);
		btnAdivinar.setBounds(184, 449, 110, 32);
		btnAdivinar.setVisible(false);
		inicializarBtnAdivinar();
		panel.add(btnAdivinar);

		lblArbol1 = new JLabel("");
		lblArbol1.setIcon(new ImageIcon("./data/images/arbol1.png"));
		lblArbol1.setBounds(521, 75, 280, 140);
		panel.add(lblArbol1);

		lblArbol2 = new JLabel("");
		lblArbol2.setIcon(new ImageIcon("./data/images/arbol2.png"));
		lblArbol2.setBounds(625, 214, 175, 161);
		panel.add(lblArbol2);

		lblCuerda = new JLabel("");
		lblCuerda.setIcon(new ImageIcon("./data/images/cuerda.png"));
		lblCuerda.setBounds(525, 214, 102, 27);
		lblCuerda.setVisible(false);
		panel.add(lblCuerda);

		lblBrazos = new JLabel("");
		lblBrazos.setIcon(new ImageIcon("./data/images/brazos.png"));
		lblBrazos.setBounds(525, 285, 102, 5);
		lblBrazos.setVisible(false);
		panel.add(lblBrazos);

		lblTronco = new JLabel("");
		lblTronco.setIcon(new ImageIcon("./data/images/tronco.png"));
		lblTronco.setBounds(525, 285, 102, 35);
		lblTronco.setVisible(false);
		panel.add(lblTronco);

		lblCabeza = new JLabel("");
		lblCabeza.setIcon(new ImageIcon("./data/images/cabeza.png"));
		lblCabeza.setBounds(525, 241, 102, 45);
		lblCabeza.setVisible(false);
		panel.add(lblCabeza);

		lblPies = new JLabel("");
		lblPies.setIcon(new ImageIcon("./data/images/pies.png"));
		lblPies.setBounds(525, 319, 102, 35);
		lblPies.setVisible(false);
		panel.add(lblPies);

		lblPalabraCompleta = new JLabel("Palabra completa:");
		lblPalabraCompleta.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPalabraCompleta.setBounds(26, 505, 94, 14);
		lblPalabraCompleta.setVisible(false);
		panel.add(lblPalabraCompleta);

		txtPalabraCompleta = new JTextField();
		txtPalabraCompleta.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtPalabraCompleta.setColumns(10);
		txtPalabraCompleta.setBounds(130, 496, 137, 32);
		txtPalabraCompleta.setVisible(false);
		panel.add(txtPalabraCompleta);

		btnArriesgarse = new JButton();
		btnArriesgarse.setForeground(Color.WHITE);
		btnArriesgarse.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnArriesgarse.setBackground(SystemColor.textHighlight);
		btnArriesgarse.setBounds(277, 496, 110, 32);
		btnArriesgarse.setVisible(false);
		inicializarBtnArriesgarse();
		panel.add(btnArriesgarse);

		lblJugadasRealizadas = new JLabel("Jugadas realizadas:");
		lblJugadasRealizadas.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblJugadasRealizadas.setBounds(586, 449, 137, 14);
		panel.add(lblJugadasRealizadas);

		lblJugadasRealizadas1 = new JLabel();
		lblJugadasRealizadas1.setHorizontalAlignment(SwingConstants.CENTER);
		lblJugadasRealizadas1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblJugadasRealizadas1.setBounds(503, 474, 262, 32);
		panel.add(lblJugadasRealizadas1);

		lblJugadasRealizadas2 = new JLabel();
		lblJugadasRealizadas2.setHorizontalAlignment(SwingConstants.CENTER);
		lblJugadasRealizadas2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblJugadasRealizadas2.setBounds(503, 517, 262, 32);
		panel.add(lblJugadasRealizadas2);


	}

	private void inicializarBtnIniciar() {
		e.inicializarBtnIniciar(btnIniciar, INICIAR);

	}

	private void inicializarBtnAdivinar() {
		e.inicializarBtnAdivinar(btnAdivinar, ADIVINAR);

	}

	public void inicializarBtnJugar( ){
		e.inicializarBtnConsultar(btnJugar, JUGAR);
	}

	public void inicializarBtnJugarDeNuevo( ){
		e.inicializarBtnJugarDeNuevo(btnJugarDeNuevo, OTRAVEZ);
	}
	
	public void inicializarBtnPuntaje( ){
		e.inicializarBtnPuntaje(btnEnviarPuntaje, PUNTAJE);
	}
	
	public void inicializarBtnArriesgarse( ){
		e.inicializarBtnArriesgarse(btnArriesgarse, ARRIESGARSE);
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JComboBox getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}

	public JLabel getLbl1() {
		return lbl1;
	}

	public void setLbl1(JLabel lbl1) {
		this.lbl1 = lbl1;
	}

	public JLabel getLbl2() {
		return lbl2;
	}

	public void setLbl2(JLabel lbl2) {
		this.lbl2 = lbl2;
	}

	public JLabel getLbl3() {
		return lbl3;
	}

	public void setLbl3(JLabel lbl3) {
		this.lbl3 = lbl3;
	}

	public JLabel getLbl4() {
		return lbl4;
	}

	public void setLbl4(JLabel lbl4) {
		this.lbl4 = lbl4;
	}

	public JLabel getLbl5() {
		return lbl5;
	}

	public void setLbl5(JLabel lbl5) {
		this.lbl5 = lbl5;
	}

	public JLabel getLbl6() {
		return lbl6;
	}

	public void setLbl6(JLabel lbl6) {
		this.lbl6 = lbl6;
	}

	public JLabel getLbl7() {
		return lbl7;
	}

	public void setLbl7(JLabel lbl7) {
		this.lbl7 = lbl7;
	}

	public JLabel getLbl8() {
		return lbl8;
	}

	public void setLbl8(JLabel lbl8) {
		this.lbl8 = lbl8;
	}

	public JLabel getLbl9() {
		return lbl9;
	}

	public void setLbl9(JLabel lbl9) {
		this.lbl9 = lbl9;
	}

	public void refrescarCantidadPalabras(int tamanio) {
		System.out.println("Cual es el tamanio "+tamanio);
		if( tamanio == 1 ){
			lbl1.setText("______");
		}

		else if( tamanio == 2 ){
			lbl1.setText("______");
			lbl2.setText("______");
		}

		else if( tamanio == 3 ){
			lbl1.setText("______");
			lbl2.setText("______");
			lbl3.setText("______");
		}

		else if( tamanio == 4 ){
			lbl1.setText("______");
			lbl2.setText("______");
			lbl3.setText("______");
			lbl4.setText("______");
		}

		else if( tamanio == 5 ){
			lbl1.setText("______");
			lbl2.setText("______");
			lbl3.setText("______");
			lbl4.setText("______");
			lbl5.setText("______");
		}

		else if( tamanio == 6 ){
			lbl1.setText("______");
			lbl2.setText("______");
			lbl3.setText("______");
			lbl4.setText("______");
			lbl5.setText("______");
			lbl6.setText("______");
		}

		else if( tamanio == 7 ){
			lbl1.setText("______");
			lbl2.setText("______");
			lbl3.setText("______");
			lbl4.setText("______");
			lbl5.setText("______");
			lbl6.setText("______");
			lbl7.setText("______");
		}

		else if( tamanio == 8 ){
			lbl1.setText("______");
			lbl2.setText("______");
			lbl3.setText("______");
			lbl4.setText("______");
			lbl5.setText("______");
			lbl6.setText("______");
			lbl7.setText("______");
			lbl8.setText("______");
		}

		else if( tamanio == 9 ){
			lbl1.setText("______");
			lbl2.setText("______");
			lbl3.setText("______");
			lbl4.setText("______");
			lbl5.setText("______");
			lbl6.setText("______");
			lbl7.setText("______");
			lbl8.setText("______");
			lbl9.setText("______");
		}

		else if( tamanio == 10 ){
			lbl1.setText("______");
			lbl2.setText("______");
			lbl3.setText("______");
			lbl4.setText("______");
			lbl5.setText("______");
			lbl6.setText("______");
			lbl7.setText("______");
			lbl8.setText("______");
			lbl9.setText("______");
			lbl10.setText("______");
		}

		else if( tamanio >= 11 ){
			lbl1.setText("______");
			lbl2.setText("______");
			lbl3.setText("______");
			lbl4.setText("______");
			lbl5.setText("______");
			lbl6.setText("______");
			lbl7.setText("______");
			lbl8.setText("______");
			lbl9.setText("______");
			lbl10.setText("______");
			lbl11.setText("______");
		}
	}

	public JLabel getLbl10() {
		return lbl10;
	}

	public void setLbl10(JLabel lbl10) {
		this.lbl10 = lbl10;
	}

	public JLabel getLbl11() {
		return lbl11;
	}

	public void setLbl11(JLabel lbl11) {
		this.lbl11 = lbl11;
	}

	public void ocultarElementosInicio() {
		txtNombre.setVisible(false);
		btnJugar.setVisible(false);
		lblEscribaSuNombre.setVisible(false);
		lblSeleccioneUnaCategora.setVisible(false);
		comboBox.setVisible(false);
		btnIniciar.setVisible(false);
	}

	public void mostrarElementosJuego() {
		btnAdivinar.setVisible(true);
		lblEscribaUnaLetra.setVisible(true);
		txtLetra.setVisible(true);
		btnArriesgarse.setVisible(true);
		lblPalabraCompleta.setVisible(true);
		txtPalabraCompleta.setVisible(true);

	}

	public JTextField getTxtLetra() {
		return txtLetra;
	}

	public void setTxtLetra(JTextField txtLetra) {
		this.txtLetra = txtLetra;
	}

	public JLabel getLblL1() {
		return lblL1;
	}

	public void setLblL1(JLabel lblL1) {
		this.lblL1 = lblL1;
	}

	public JLabel getLblL2() {
		return lblL2;
	}

	public void setLblL2(JLabel lblL2) {
		this.lblL2 = lblL2;
	}

	public JLabel getLblL3() {
		return lblL3;
	}

	public void setLblL3(JLabel lblL3) {
		this.lblL3 = lblL3;
	}

	public JLabel getLblL4() {
		return lblL4;
	}

	public void setLblL4(JLabel lblL4) {
		this.lblL4 = lblL4;
	}

	public JLabel getLblL5() {
		return lblL5;
	}

	public void setLblL5(JLabel lblL5) {
		this.lblL5 = lblL5;
	}

	public JLabel getLblL6() {
		return lblL6;
	}

	public void setLblL6(JLabel lblL6) {
		this.lblL6 = lblL6;
	}

	public JLabel getLblL7() {
		return lblL7;
	}

	public void setLblL7(JLabel lblL7) {
		this.lblL7 = lblL7;
	}

	public JLabel getLblL8() {
		return lblL8;
	}

	public void setLblL8(JLabel lblL8) {
		this.lblL8 = lblL8;
	}

	public JLabel getLblL9() {
		return lblL9;
	}

	public void setLblL9(JLabel lblL9) {
		this.lblL9 = lblL9;
	}

	public JLabel getLblL10() {
		return lblL10;
	}

	public void setLblL10(JLabel lblL10) {
		this.lblL10 = lblL10;
	}

	public JLabel getLblL11() {
		return lblL11;
	}

	public void setLblL11(JLabel lblL11) {
		this.lblL11 = lblL11;
	}

	public JLabel getLblPalabraCompleta() {
		return lblPalabraCompleta;
	}

	public void setLblPalabraCompleta(JLabel lblPalabraCompleta) {
		this.lblPalabraCompleta = lblPalabraCompleta;
	}

	public JLabel getLblJugadasRealizadas1() {
		return lblJugadasRealizadas1;
	}

	public void setLblJugadasRealizadas1(JLabel lblJugadasRealizadas1) {
		this.lblJugadasRealizadas1 = lblJugadasRealizadas1;
	}

	public JLabel getLblJugadasRealizadas2() {
		return lblJugadasRealizadas2;
	}

	public void setLblJugadasRealizadas2(JLabel lblJugadasRealizadas2) {
		this.lblJugadasRealizadas2 = lblJugadasRealizadas2;
	}

	public JLabel getLblCuerda() {
		return lblCuerda;
	}

	public void setLblCuerda(JLabel lblCuerda) {
		this.lblCuerda = lblCuerda;
	}

	public JLabel getLblTronco() {
		return lblTronco;
	}

	public void setLblTronco(JLabel lblTronco) {
		this.lblTronco = lblTronco;
	}

	public JLabel getLblCabeza() {
		return lblCabeza;
	}

	public void setLblCabeza(JLabel lblCabeza) {
		this.lblCabeza = lblCabeza;
	}

	public JLabel getLblBrazos() {
		return lblBrazos;
	}

	public void setLblBrazos(JLabel lblBrazos) {
		this.lblBrazos = lblBrazos;
	}

	public JLabel getLblPies() {
		return lblPies;
	}

	public void setLblPies(JLabel lblPies) {
		this.lblPies = lblPies;
	}

	public void ocultarTodosLosElementos(String resultado) {
		lblEscribaSuNombre.setVisible(false);

		txtNombre.setVisible(false);

		btnJugar.setVisible(false);

		lblSeleccioneUnaCategora.setVisible(false);

		comboBox.setVisible(false);

		btnIniciar.setVisible(false);

		lbl1.setVisible(false);

		lbl2.setVisible(false);

		lbl3.setVisible(false);

		lbl4.setVisible(false);

		lbl5.setVisible(false);

		lbl6.setVisible(false);

		lbl7.setVisible(false);

		lbl8.setVisible(false);

		lbl9.setVisible(false);

		lbl10.setVisible(false);

		lbl11.setVisible(false);

		lblL1.setVisible(false);

		lblL2.setVisible(false);

		lblL3.setVisible(false);

		lblL4.setVisible(false);

		lblL5.setVisible(false);

		lblL6.setVisible(false);

		lblL7.setVisible(false);

		lblL8.setVisible(false);

		lblL9.setVisible(false);

		lblL10.setVisible(false);

		lblL11.setVisible(false);

		lblEscribaUnaLetra.setVisible(false);

		txtLetra.setVisible(false);

		btnAdivinar.setVisible(false);

		lblArbol1.setVisible(false);

		lblArbol2.setVisible(false);

		lblCuerda.setVisible(false);

		lblBrazos.setVisible(false);

		lblTronco.setVisible(false);

		lblCabeza.setVisible(false);

		lblPies.setVisible(false);

		lblPalabraCompleta.setVisible(false);

		txtPalabraCompleta.setVisible(false);

		btnArriesgarse.setVisible(false);

		lblJugadasRealizadas.setVisible(false);

		lblJugadasRealizadas1.setVisible(false);

		lblJugadasRealizadas2.setVisible(false);
		
		btnJugarDeNuevo.setVisible(true);
		
		btnEnviarPuntaje.setVisible(true);
		lblHasSidoDerrotadoa.setText(resultado);
		lblHasSidoDerrotadoa.setVisible(true);
		
	}
	
	
}
