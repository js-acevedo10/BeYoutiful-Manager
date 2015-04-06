package com.beyu.mundo;

public class Servicio {
	public static final double COMISION = 0.48;
	public static final int KIT = 1000;
	public String nombre;
	public double costo;
	public boolean enCombo;
	public Usuario usuarioResponsable;
	public int comisionUsuario;
	public int gananciaPeluqueria;
	public String cliente;
	
	public Servicio(String nombre, double costo, Usuario usuarioResponsable, String cliente) {
		this.nombre = nombre;
		this.costo = costo;		
		this.cliente = cliente;
		enCombo = false;
		this.usuarioResponsable = usuarioResponsable;
		calcularComisiones();
	}
	
	public void calcularComisiones() {
		
		if(nombre.equals("Manicure Mujer") || nombre.equals("Manicure Hombre") || nombre.equals("Cambio Esmalte")) {
			comisionUsuario = (int) ((costo-1000)*0.48);
			gananciaPeluqueria = (int) (costo-comisionUsuario);
		} else if(nombre.equals("Pedicure")) {
			comisionUsuario = (int) ((costo-1500)*0.48);
			gananciaPeluqueria = (int) (costo-comisionUsuario);
		} else if(nombre.equals("Decoracion")) {
			comisionUsuario = (int) (costo*0.48);
			gananciaPeluqueria = (int) (costo-comisionUsuario);
		} else if(nombre.contains("Corte") || nombre.toLowerCase().equals("arreglo") || nombre.equals("Cepillado")) {
			comisionUsuario = (int) (costo/2);
			gananciaPeluqueria = (int) (costo-comisionUsuario);
		} else if(nombre.contains("Cera")) {
			comisionUsuario = (int) (costo*0.45);
			gananciaPeluqueria = (int) (costo-comisionUsuario);
		} else if(nombre.toLowerCase().contains("gel")) {
			comisionUsuario = 12500;
			gananciaPeluqueria = (int) (costo-comisionUsuario);
		} else if(nombre.contains("Pestanas")) {
			comisionUsuario = (int) (costo*0.45);
			gananciaPeluqueria = (int) (costo-comisionUsuario);
		} else if(nombre.toLowerCase().contains("trenza")) {
			comisionUsuario = (int)costo/2;
			gananciaPeluqueria = (int) (costo-comisionUsuario);
		} else if(nombre.equals("Corte y Cepillado")) {
			comisionUsuario = (int) (costo/2);
			gananciaPeluqueria = (int) (costo-comisionUsuario);
		} else if(nombre.contains("Combo Solo Manos")) {
			comisionUsuario = 4512;
			gananciaPeluqueria = (int) (costo-comisionUsuario);
		} else if(nombre.contains("Combo Solo Pies")) {
			comisionUsuario = 6912;
			gananciaPeluqueria = (int) costo-comisionUsuario;
		} else if(nombre.contains("Combo Manos y Pies")) {
			comisionUsuario = 11760;
			gananciaPeluqueria = (int) costo-comisionUsuario;
		} else if(nombre.contains("removedor")) {
			comisionUsuario = (int) ((int)(costo-3000)*0.48);
			gananciaPeluqueria = (int) costo-comisionUsuario;
		} else if(nombre.contains("plancha")) {
			comisionUsuario = (int) costo/2;
			gananciaPeluqueria = (int) costo-comisionUsuario;
		} else if(nombre.contains("capul") ||nombre.contains("Capul")) {
			comisionUsuario = (int) costo/2;
			gananciaPeluqueria = (int) costo-comisionUsuario;
		} else if(nombre.toLowerCase().contains("velaterapia")|| nombre.toLowerCase().contains("veloterapia")) {
			comisionUsuario = (int) ((int) (costo-4000)*0.48);
			gananciaPeluqueria = (int) costo-comisionUsuario;
		} else if(nombre.contains("daniela") || nombre.contains("Daniela")) {
			comisionUsuario = (int) ((int) (costo-10000)/2);
			gananciaPeluqueria = (int) costo-comisionUsuario;
		} else if(nombre.toLowerCase().contains("tips") || nombre.toLowerCase().contains("Tip")) {
			comisionUsuario = (int) ((int) (costo*.45));
			gananciaPeluqueria = (int) costo-comisionUsuario;
		} else if(nombre.contains("Keratina")) {
			comisionUsuario = (int) ((int) (costo*.40));
			gananciaPeluqueria = (int) costo-comisionUsuario;
		} else if(nombre.contains("Shampoo")) {
			comisionUsuario = 0;
			gananciaPeluqueria = (int) costo-comisionUsuario;
		} else {
			comisionUsuario = (int) (costo*0.48);
			gananciaPeluqueria = (int) costo-comisionUsuario;
		}
	}
	
	public int darComisionUsuario() {
		return comisionUsuario;
	}
	
	public int darGananciaPeluqueria() {
		return gananciaPeluqueria;
	}
	
	public Usuario darUsuarioResponsable() {
		return usuarioResponsable;
	}
	
	public String darNombre() {
		return nombre;
	}
	
	public double darCosto() {
		return costo;
	}
	
	public void combear() {
		enCombo = true;
	}
	
	public boolean darEnCombo() {
		return enCombo;
	}
}
