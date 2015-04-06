package com.beyu.mundo;

import java.util.ArrayList;

import com.beyu.interfaz.PanelServicios;

public class CreadorRecibos {
	
	public int descuento;
	public double sumaVenta;
	public ArrayList<Servicio> servicios;
	public PanelServicios principal;
	int counterButton;
	public Usuario user;
	
	public CreadorRecibos(PanelServicios ventana) {
		principal = ventana;
		servicios = new ArrayList<Servicio>();
		counterButton = 0;
		sumaVenta = 0;
	}
	
	public void agregarServicio(String nombre, double costo) {
		Servicio temp = new Servicio(nombre, costo, user, "");
		servicios.add(temp);
		sumaVenta += costo;
		String x = "-" + temp.darNombre() + "                                                     $" + temp.darCosto();
		principal.agregarServicioFactura(x, counterButton);
		counterButton++;
//		chequearCombo(temp);
	}
	
//	public void chequearCombo(Servicio temp) {
//		try {
//			File combos = new File("./data/combos.btf");
//			BufferedReader in = new BufferedReader(new FileReader(combos));
//			String actual = in.readLine();
//			
//			while(actual != null) {
//				String[] comboActual = actual.split("&");
//				actual = in.readLine();
//				boolean comboEncontrado = false;
//				
//				for(Servicio serv: servicios) {
//					if(temp.darNombre().equals(comboActual[0])) {
//						if(!serv.darEnCombo() && serv.darNombre().equals(comboActual[1])) {
//							comboEncontrado = true;
//							serv.combear();
//						}
//					}
//					if(temp.darNombre().equals(comboActual[1])) {
//						if(!serv.darEnCombo() && serv.darNombre().equals(comboActual[0])) {
//							comboEncontrado = true;
//							serv.combear();
//						}
//					}
//				}
//				
//				if(comboEncontrado) {
//					principal.agregarDescuentoPorCombo(comboActual[2]);
//				}
//			}
//		} catch (Exception e) {
//			
//		}
//	}
	
	public double darTotal() {
		return sumaVenta;
	}
	
	public void asignarUsuario(Usuario user) {
		this.user = user;
	}
	
	public Usuario darUsuario() {
		return user;
	}
	
	public ArrayList<Servicio> darServicios() {
		return servicios;
	}

}