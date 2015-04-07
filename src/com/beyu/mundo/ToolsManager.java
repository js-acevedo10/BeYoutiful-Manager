package com.beyu.mundo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import com.beyu.interfaz.PanelTool;

public class ToolsManager {

	PanelTool panelTools;

	int i = 0;

	public ToolsManager(ArrayList<Usuario> usuarios, PanelTool panelTool) {

		panelTools = panelTool;
		rellenarInformacion(usuarios);

	}

	@SuppressWarnings({ "rawtypes", "deprecation", "unchecked" })
	public void rellenarInformacion(ArrayList<Usuario> usuarios) {

		Date dateActual;
		int diaActual;
		int mesActual;
		int anioActual;
		String fechaDisplay;

		dateActual = new Date();
		diaActual = dateActual.getDate();
		mesActual = dateActual.getMonth() + 1;
		anioActual = dateActual.getYear() + 1900;

		fechaDisplay = diaActual + "-" + mesActual + "-" + anioActual;
		int tot = 0;

		for(Usuario usuario: usuarios) {
			tot = 0;
			ArrayList servicios = new ArrayList();

			String carpeta = usuario.darNombre().replace(" ", "");
			String pathname = "./data/facturas/" + carpeta + "/ventas (" + fechaDisplay + ").btf";
			File archivoDiaActual = new File(pathname);
			if(archivoDiaActual.exists()) {
				try {
					BufferedReader in = new BufferedReader(new FileReader(archivoDiaActual));
					String lectura = in.readLine();
					Servicio temp = null;
					String cliente = "";

					while(lectura != null) {
						if(lectura.contains("Total")) {

						} else if(lectura.contains("Descuento")) {

						} else if(lectura.contains("Cliente")) {
							String[] lineaActual = lectura.split("_");
							cliente = lineaActual[1];
						} else {
							String[] lineaActual = lectura.split("_");
							String nomServicio = lineaActual[0];
							int costoServicio = Integer.parseInt(lineaActual[1]);

							temp = new Servicio(nomServicio, costoServicio, usuario, cliente);
							servicios.add(temp);
							tot += costoServicio;
						}
						lectura = in.readLine();
					}
					in.close();
				} catch(Exception e) {
					JOptionPane.showMessageDialog(null, "No se puede leer la informacion de " + usuario.darNombre());
				}
			}

			llenarInformacionEnBotones(servicios, usuario, tot);

		}

	}

	private void llenarInformacionEnBotones(ArrayList<Servicio> servicios, Usuario user, int tot) {
		i++;
		panelTools.actualizarListas(servicios, i, user, tot);
	}
}
