package com.beyu.mundo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;

public class RegistroFacturas {
	
	CreadorRecibos reciboEfectuado;
	Usuario usuarioEncargado;
	String nombreCliente;
	
	public RegistroFacturas(CreadorRecibos reciboEfectuado, Usuario usuarioEncargado, String nombreCliente) {
		this.reciboEfectuado = reciboEfectuado;
		this.usuarioEncargado = usuarioEncargado;
		this.nombreCliente = nombreCliente.substring(0,1).toUpperCase() + nombreCliente.substring(1);
	}
	
	public void exportarRecibo() {
		try {
			Date hoy = new Date();
			int year = 1900 + hoy.getYear();
			int month = 1 + hoy.getMonth();
			String date = " (" + hoy.getDate() + "-" + month + "-" + year + ")";
			File file = new File("./data/facturas/"+usuarioEncargado.darNombre().replace(" ", "")+"/ventas"+ date +".btf");
			file.getParentFile().mkdirs();
			file.createNewFile();
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
			out.println("-----Servicio a Cliente_" + nombreCliente + "_----------");
			for(Servicio servicio: reciboEfectuado.darServicios()) {
				out.println(servicio.darNombre() + "_" + (int)servicio.darCosto()
						+"_" + servicio.darComisionUsuario() + "_" + servicio.darGananciaPeluqueria());
			}
			out.println("Descuento_" + reciboEfectuado.descuento);
			out.println("-----Total_" + (int)reciboEfectuado.darTotal() + "----------");
			out.close();
		} catch(Exception exc) {
			exc.printStackTrace();
		}
	}
}