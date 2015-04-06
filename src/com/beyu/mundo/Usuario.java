package com.beyu.mundo;

public class Usuario {

	String nombre, foto;

	public Usuario(String nombre, String foto) {
		super();
		this.nombre = nombre;
		this.foto = foto;
	}
	
	public String darNombre() {
		return this.nombre;
	}
	
	public String darFoto() {
		return this.foto;
	}
}
