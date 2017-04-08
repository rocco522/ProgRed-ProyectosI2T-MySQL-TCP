package modelo;

import java.util.ArrayList;

public class Palabra {
	
	private String Categoria;
	private String Palabra;

	public Palabra(String categoria, String palabra) {
		super();
		Categoria = categoria;
		Palabra = palabra;
	}
	
	public String getCategoria() {
		return Categoria;
	}
	public void setCategoria(String categoria) {
		Categoria = categoria;
	}
	public String getPalabra() {
		return Palabra;
	}
	public void setPalabra(String palabra) {
		Palabra = palabra;
	}
}
