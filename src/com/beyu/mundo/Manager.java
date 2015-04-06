package com.beyu.mundo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class Manager {
	
	public ArrayList<Usuario> usuarios;
	public ArrayList<Dia> dias;
	
	public Manager() {
		usuarios = readUsers();
		dias = readDias();
	}
	
	public ArrayList<Usuario> readUsers() {
		File userFile = new File("./data/usuarios.btf");
		ArrayList<Usuario> r = new ArrayList<Usuario>();
		try {
			@SuppressWarnings("resource")
			BufferedReader in = new BufferedReader(new FileReader(userFile));
			Usuario temp = null;
			String x = in.readLine();
			while(x != null) {
				String data[] = x.split("&");
				String nombre = data[0];
				String foto = data[1];
				temp = new Usuario(nombre, foto);
				r.add(temp);
				x = in.readLine();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}
	
	public ArrayList<Dia> readDias() {
		File diasFile = new File("./data/dias.btf");
		return null;
	}
	
	//getters
	
	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}
	
	public ArrayList<Dia> getDias() {
		return dias;
	}

	public boolean loginAdmin(String pass, File x) {
		try {
			BufferedReader in = new BufferedReader(new FileReader(x));
			String correcta = in.readLine();
			
			if(pass.equals(correcta))
				return true;
			return false;
		} catch(Exception e) {
			return false;
		}
	}
}
