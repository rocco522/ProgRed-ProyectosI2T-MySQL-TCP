package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import control.EjecutarS;

public class Juego {
	
	private static final String RUTA = "./data/";
	private ArrayList<Palabra> acciones;
	private ArrayList<Palabra> deportes;
	private ArrayList<Palabra> animales;
	private EjecutarS e;

	public Juego(EjecutarS ejecutarS) {
		this.e = ejecutarS;
		deportes = new ArrayList<Palabra>();
		acciones = new ArrayList<Palabra>();
		animales = new ArrayList<Palabra>();
		
		try {
			cargarCategorias("animales");
			cargarCategorias("acciones");
			cargarCategorias("deportes");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
	
	public void cargarCategorias(String categoria) throws IOException{
		
		String archivo = RUTA+categoria;
		
		FileReader fr = new FileReader(archivo);
		BufferedReader br = new BufferedReader(fr);
		
		String cadena = "";
		
		while((cadena = br.readLine()) != null){
			if( categoria.equals("acciones") ){
				acciones.add(new Palabra("Acciones", cadena));
			}
			else if( categoria.equals("animales") ){
				animales.add(new Palabra("Animales", cadena));
			}
			else{
				deportes.add(new Palabra("Deportes", cadena));
			}
		}
		
		br.close();
		
	}

	public ArrayList<Palabra> getAcciones() {
		return acciones;
	}

	public void setAcciones(ArrayList<Palabra> acciones) {
		this.acciones = acciones;
	}

	public ArrayList<Palabra> getDeportes() {
		return deportes;
	}

	public void setDeportes(ArrayList<Palabra> deportes) {
		this.deportes = deportes;
	}

	public ArrayList<Palabra> getAnimales() {
		return animales;
	}

	public void setAnimales(ArrayList<Palabra> animales) {
		this.animales = animales;
	}

}
