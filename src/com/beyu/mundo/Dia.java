package com.beyu.mundo;

import java.util.ArrayList;
import java.util.Date;

public class Dia {

	Date fecha;
	ArrayList<Servicio> serviciosDelDia;
	
	public Dia(Date fecha) {
		super();
		this.fecha = fecha;
		serviciosDelDia = new ArrayList<Servicio>();
	}
	
	public Date getFecha() {
		return fecha;
	}
}
