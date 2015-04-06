package com.beyu.mundo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

import com.beyu.interfaz.InterfazPrincipal;
import com.beyu.interfaz.PanelAdmin;

public class Administrador {
	
	InterfazPrincipal principal;
	PanelAdmin panelAdmin;
	Manager manager;
	Date dateActual;
	int diaActual;
	int mesActual;
	int anioActual;
	String fechaDisplay;
	ArrayList<Usuario> usuarios;
	
	public Administrador(InterfazPrincipal principal, PanelAdmin panelAdmin) {
		this.principal = principal;
		this.panelAdmin = panelAdmin;
		manager = this.principal.darMundo();
		usuarios = manager.getUsuarios();
		leerDiaActual();
	}
	
	@SuppressWarnings("deprecation")
	public void leerDiaActual() {
		dateActual = new Date();
		diaActual = dateActual.getDate();
		mesActual = dateActual.getMonth() + 1;
		anioActual = dateActual.getYear() + 1900;
		actualizarInformacion();
	}
	
	@SuppressWarnings("deprecation")
	public void leerSiguienteDia() {
		//Calcula los valores del siguiente dia al actual
		Date diaHoy = new Date();
		
		if(diaHoy.getDate() == dateActual.getDate() &&
				diaHoy.getMonth() == dateActual.getMonth() &&
				diaHoy.getYear() == dateActual.getYear()) {
			JOptionPane.showMessageDialog(principal, "No es posible ver mas alla del presente.");
		} else {
			Calendar c = Calendar.getInstance();
			c.setTime(dateActual);
			c.add(Calendar.DATE, 1);
			dateActual = c.getTime();
			diaActual = dateActual.getDate();
			mesActual = dateActual.getMonth() + 1;
			anioActual = dateActual.getYear() + 1900;
			actualizarInformacion();
		}
	}
	
	@SuppressWarnings("deprecation")
	public void leerAnteriorDia() {
		
		if(diaActual == 1 && mesActual == 2 && anioActual == 2015) {
			JOptionPane.showMessageDialog(principal, "No existen registros anteriores al 1 de Febrero de 2015");
		} else {
			//Calcula los valores del dia anterior al actual
			Calendar c = Calendar.getInstance();
			c.setTime(dateActual);
			c.add(Calendar.DATE, -1);
			dateActual = c.getTime();
			diaActual = dateActual.getDate();
			mesActual = dateActual.getMonth() + 1;
			anioActual = dateActual.getYear() + 1900;
			actualizarInformacion();
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void actualizarInformacion() {
		
		ArrayList info = new ArrayList();
		fechaDisplay = diaActual + "-" + mesActual + "-" + anioActual;
		
		for(Usuario usuario: usuarios) {
			String carpeta = usuario.darNombre().replace(" ", "");
			String pathname = "./data/facturas/" + carpeta + "/ventas (" + fechaDisplay + ").btf";
			File archivoDiaActual = new File(pathname);
			if(archivoDiaActual.exists()) {
				int cantidadServicios = 0;
				int producidoSinDescuento = 0;
				int ventasTotal = 0;
				int comisionTotal = 0;
				int gananciasTotal = 0;
				int descuentoTotal = 0;
				try {
					BufferedReader in = new BufferedReader(new FileReader(archivoDiaActual));
					String lectura = in.readLine();
					
					while(lectura != null) {
						if(lectura.contains("Total")) {
							String[] lineaActual = lectura.replaceAll("-", "").split("_");
							int total = Integer.parseInt(lineaActual[1]);
							ventasTotal += total;
						} else if(lectura.contains("Descuento")) {
							String[] lineaActual = lectura.split("_");
							int valorDescuento = Integer.parseInt(lineaActual[1]);
							descuentoTotal += valorDescuento;
						} else {
							if(lectura.contains("Cliente")){
								
							} else {
							String[] lineaActual = lectura.split("_");
							String nomServicio = lineaActual[0];
							int costoServicio = Integer.parseInt(lineaActual[1]);
							int comisionServicio = Integer.parseInt(lineaActual[2]);
							int gananciaServicio = Integer.parseInt(lineaActual[3]);
							cantidadServicios++;
							comisionTotal += comisionServicio;
							gananciasTotal += gananciaServicio;
							producidoSinDescuento += costoServicio;}
						}
						lectura = in.readLine();
					}
					
					in.close();
				} catch(Exception e) {
					JOptionPane.showMessageDialog(principal, "No se puede leer el dia " + fechaDisplay);
				}
				
				int descuentoTotalEmpleado = (int) (descuentoTotal*0.48);				
				ArrayList infoUsuarioActual = new ArrayList();
				
				infoUsuarioActual.add(usuario.darNombre()); //Nombre del empleado USED
				infoUsuarioActual.add(cantidadServicios); //Cantidad de servicios dia USED
				infoUsuarioActual.add(comisionTotal); //Comision ganada por el empleado sin aplicar el descuento del mismo USED
				infoUsuarioActual.add(gananciasTotal); //Ganancias luego de pago al empleado aplicando el descuento USED
				infoUsuarioActual.add(producidoSinDescuento); //Total producido de la suma sin aplicar descuentos USED
				
				infoUsuarioActual.add(ventasTotal); //Total producido de la suma aplicando el descuento
				infoUsuarioActual.add(descuentoTotalEmpleado); //Parte del descuento que se le cobra al empleado				
				infoUsuarioActual.add(comisionTotal - descuentoTotalEmpleado); //Comision ganada por el empleado aplicandole descuentos
				infoUsuarioActual.add(gananciasTotal); //Ganancias luego de pago al empleado sin aplicar el descuento
				
				info.add(infoUsuarioActual);
			} else {
				ArrayList infoUsuarioActual = new ArrayList();
				infoUsuarioActual.add(usuario.darNombre());
				infoUsuarioActual.add(0);
				infoUsuarioActual.add(0);
				infoUsuarioActual.add(0);
				infoUsuarioActual.add(0);
				infoUsuarioActual.add(0);
				infoUsuarioActual.add(0);
				infoUsuarioActual.add(0);
				infoUsuarioActual.add(0);
				info.add(infoUsuarioActual);
			}
		}
		llenarInformacionEnBotones(info);
	}

	private void llenarInformacionEnBotones(ArrayList info) {
		for(int i = 0; i < info.size(); i++) {
			ArrayList actual = (ArrayList) info.get(i);
			panelAdmin.actualizarInformacion(actual, i, fechaDisplay);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void leerSemana(Date dateInicio, Date dateFinal) {
		ArrayList info = new ArrayList();
		for(Usuario usuario: usuarios) {
			
			int numServicios = 0;
			int comision = 0;
			int ganancia = 0;
			int producido = 0;
			Date myDateInicial = dateInicio;
			Date myDateFinal = dateFinal;
			
			while(myDateInicial.before(myDateFinal)) {
				int dia = myDateInicial.getDate();
				int mes = myDateInicial.getMonth() + 1;
				int anio = myDateInicial.getYear() + 1900;
				String fecha = dia + "-" + mes + "-" + anio;
				String carpeta = usuario.darNombre().replace(" ", "");
				String pathname = "./data/facturas/" + carpeta + "/ventas (" + fecha + ").btf";
				File archivoActual = new File(pathname);
				if(!archivoActual.exists()) {
					Calendar c = Calendar.getInstance();
					c.setTime(myDateInicial);
					c.add(Calendar.DATE, 1);
					myDateInicial = c.getTime();
					continue;
				}
				
				try {
					BufferedReader in = new BufferedReader(new FileReader(archivoActual));
					String lectura = in.readLine();
					
					while(lectura != null) {
						if(lectura.contains("Total")) {
							String[] lineaActual = lectura.replaceAll("-", "").split("_");
							int total = Integer.parseInt(lineaActual[1]);
							producido += total;
						} else if(lectura.contains("Descuento") || lectura.contains("Cliente")) {
							
						} else {
							String[] lineaActual = lectura.split("_");
							int comisionServicio = Integer.parseInt(lineaActual[2]);
							int gananciaServicio = Integer.parseInt(lineaActual[3]);
							numServicios++;
							comision += comisionServicio;
							ganancia += gananciaServicio;
						}
						lectura = in.readLine();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				Calendar c = Calendar.getInstance();
				c.setTime(myDateInicial);
				c.add(Calendar.DATE, 1);
				myDateInicial = c.getTime();
			}
			ArrayList infoUsuarioActual = new ArrayList();
			infoUsuarioActual.add(usuario.darNombre()); //Nombre del empleado
			infoUsuarioActual.add(numServicios);
			infoUsuarioActual.add(comision);
			infoUsuarioActual.add(ganancia);
			infoUsuarioActual.add(producido);
			info.add(infoUsuarioActual);
		}
		actualizarInformacionDeSemana(info);
	}

	private void actualizarInformacionDeSemana(ArrayList info) {
		for(int i = 0; i < info.size(); i++) {
			int j = i + 10;
			ArrayList actual = (ArrayList) info.get(i);
			panelAdmin.actualizarInformacion(actual, j, fechaDisplay);
		}
	}
}
