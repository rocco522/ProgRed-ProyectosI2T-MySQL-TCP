package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import control.EjecutarC;

public class Juego {

	//	private static final String RUTA = "./data/";
	private EjecutarC e;
	private Jugador j;
	private String palabra;
	private int tamanio;
	private boolean cuerda;
	private boolean cabeza;
	private boolean tronco;
	private boolean brazos;
	private boolean piernas;

	public Juego(Jugador jugador, EjecutarC ejecutarS, String palabra) {
		this.e = ejecutarS;
		this.j = jugador;
		//TODO eliminar asignación
		this.palabra = palabra;
		this.tamanio = palabra.length();
		cuerda = false;
		cabeza = false;
		tronco = false;
		brazos = false;
		piernas = false;
		
	}

	public void iniciarJuego() {

		e.ocultarElementosInicio();
		e.refrescarPalabras();
		e.mostrarElementosJuego();
	}

	public void procesarJugada(String text) {
		System.out.println("En procesar jugada llegó la letra "+text+" y la palabra a adivinar es "+palabra);
		char letra = text.charAt(0);
		boolean validar = e.validar();
		if(!validar && palabra.contains(text)){
			System.out.println("Se adivinó una letra");

			for(int i=0; i<palabra.length(); i++){
				if(palabra.charAt(i)==letra)
					e.refrescarLbl(i,text);
			}
		}
		else if(validar)
			e.win();
		else{
			System.out.println("Al parecer no se adivinó la letra");
			if(!validar ){
				if(!cuerda){
					cuerda = true;
					e.dibujar("cuerda");
				}
				else if(!cabeza){
					cabeza = true;
					e.dibujar("cabeza");
				}
				else if(!tronco){
					tronco = true;
					e.dibujar("tronco");
				}
				else if(!brazos){
					brazos = true;
					e.dibujar("brazos");
				}
				else if(!piernas){
					piernas = true;
					e.dibujar("piernas");
				}
				else{
					e.gameOver();
				}
			}
			else
				e.win();

		}

	}


}
