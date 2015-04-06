package com.beyu.mundo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;


public class databaseManager {
	
	File database;
	
	public databaseManager() {
		database = new File("./data/userDatabase.btf");
	}

	public void addUserToDatabase(String nombre, String apellido, String correo) {
		try {
			nombre = nombre.toLowerCase();
			nombre = Character.toString(nombre.charAt(0)).toUpperCase()+nombre.substring(1);
			apellido = apellido.toLowerCase();
			apellido = Character.toString(apellido.charAt(0)).toUpperCase()+apellido.substring(1);
			correo = correo.toLowerCase();
			database.getParentFile().mkdirs();
			database.createNewFile();
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(database, true)));
			out.println(correo + "," + nombre + "," + apellido);
			out.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al guardar el usuario.");
		}
		
	}

}
