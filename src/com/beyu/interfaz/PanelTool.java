package com.beyu.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import com.beyu.mundo.Servicio;
import com.beyu.mundo.ToolsManager;
import com.beyu.mundo.Usuario;
import com.beyu.mundo.databaseManager;

public class PanelTool extends JPanel {

	ToolsManager toolsManager;
	InterfazPrincipal principal;
	databaseManager databaseManager;
	public JList listUser1;
	public JList listUser2;
	public JList listUser3;
	public JList listUser4;
	public JButton btnCancelar;
	public JLabel lblUser1;
	public JLabel lblUser2;
	public JLabel lblUser3;
	public JLabel lblUser4;
	public JButton btnLlegada;
	public String[] ops = {"Marisol", "Stefany", "Raul"};

	/**
	 * Create the panel.
	 */
	public PanelTool(InterfazPrincipal ventana) {
		principal = ventana;
		databaseManager = new databaseManager();

		setLayout(new BorderLayout());

		JPanel panelBotonesSur = new JPanel();
		panelBotonesSur.setLayout(new GridLayout(1, 0));
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setPreferredSize(new Dimension(0, 100));
		btnCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				principal.restart();
			}
		});

		btnLlegada = new JButton("Registrar Llegada");
		btnLlegada.setPreferredSize(new Dimension(0, 100));
		btnLlegada.addActionListener(new ActionListener() {
			
			public void recrearArchivo(String usuario, String fecha) throws Exception {
				String path = "./data/turnosManager.btf";
				File archivo = new File(path);
				PrintWriter fos = new PrintWriter(archivo);
				fos.print("");
				fos.close();
				
				PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(archivo, true)));
				out.println("Fecha:" + fecha);
				out.println("3&Diana");
				out.close();
				escribirLlegada(usuario, 0);
			}
			
			public void escribirLlegada(String usuario, int puesto) throws Exception {
				String path = "./data/turnosManager.btf";
				File archivo = new File(path);
				PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(archivo, true)));
				out.println(puesto+"&"+usuario);
				out.close();
			}
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
				String pathname = "./data/turnosManager.btf";
				File archivoActual = new File(pathname);
				BufferedReader ini = new BufferedReader(new FileReader(archivoActual));
				String lec = ini.readLine();
				if(lec.contains("Fecha:")) {
					String date = lec.split(":")[1];
					Date fechaHoy = new Date();
					String diaHoy = fechaHoy.getDate()+"";
					int mesHoyInt = fechaHoy.getMonth()+1;
					String mesHoy = mesHoyInt+"";
					int anioHoyInt = fechaHoy.getYear() + 1900;
					String anioHoy = anioHoyInt+"";
					String fecha=diaHoy+"/"+mesHoy+"/"+anioHoy;
					if(date.equalsIgnoreCase(fecha)) {
						String x = "";
						String a = ini.readLine();
						while(a != null) {
							x+=a;
							a = ini.readLine();
						}
						ini.close();
						if(x.contains("Marisol") && x.contains("Stefany") && x.contains("Raul")) {
							int paso = JOptionPane.showConfirmDialog(null, "El registro de llegadas esta completo, desea reiniciarlo?");
							if(paso == JOptionPane.YES_OPTION) {
								String path = "./data/turnosManager.btf";
								File archivo = new File(path);
								PrintWriter fos = new PrintWriter(archivo);
								fos.print("Fecha:99/99/99");
								fos.close();
								JOptionPane.showMessageDialog(null, "Debe registrar todas las llegadas del dia de hoy nuevamente.");
							}
						}
					}
				}
				int user = JOptionPane.showOptionDialog(null, "Elegir el empleado que ha llegado:", "Registrar Llegada", JOptionPane.OK_CANCEL_OPTION, 0, null, ops, ops[0]);
				String usuario = "";
				Date fechaHoy = new Date();
				String diaHoy = fechaHoy.getDate()+"";
				int mesHoyInt = fechaHoy.getMonth()+1;
				String mesHoy = mesHoyInt+"";
				int anioHoyInt = fechaHoy.getYear() + 1900;
				String anioHoy = anioHoyInt+"";
				String fecha=diaHoy+"/"+mesHoy+"/"+anioHoy;
				
				if(user >= 0) {
					usuario = ops[user];
					pathname = "./data/turnosManager.btf";
					archivoActual = new File(pathname);
					int llegadaNum = 0;
					if(!archivoActual.exists())
						archivoActual.mkdir();
					
						BufferedReader in = new BufferedReader(new FileReader(archivoActual));
						String lectura = in.readLine();
						while(lectura != null) {
							if(lectura.contains("Fecha:")) {
								String fechaActual = lectura.split(":")[1];
								String dia = fechaActual.split("/")[0];
								String mes = fechaActual.split("/")[1];
								String anio = fechaActual.split("/")[2];
																
								if(dia.equals(diaHoy) && mes.equals(mesHoy) && anio.equals(anioHoy)) {
								} else {
									recrearArchivo(usuario, fecha);
									return;
								}
							} else if(lectura.contains(usuario)) {
									JOptionPane.showMessageDialog(null, "El usuario " + usuario + " ya est� registrado el d�a de hoy.");
									return;
							} else {
								if(lectura.equals("3&Diana")) {
								} else {
									String puesto = lectura.split("&")[0];
									int num = Integer.parseInt(puesto);
									if(num >= llegadaNum) {
										llegadaNum = num+1;
									}
								}
							}
							lectura = in.readLine();
						}
						escribirLlegada(usuario, llegadaNum);
					}} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});

		panelBotonesSur.add(btnCancelar);
		panelBotonesSur.add(btnLlegada);
		add(panelBotonesSur, BorderLayout.SOUTH);

		JPanel panelNombres = new JPanel();
		add(panelNombres, BorderLayout.NORTH);
		panelNombres.setLayout(new GridLayout(0, 4, 0, 0));

		lblUser1 = new JLabel("User1");
		lblUser1.setEnabled(false);
		lblUser1.setPreferredSize(new Dimension(36, 40));
		panelNombres.add(lblUser1);

		lblUser2 = new JLabel("User2");
		lblUser2.setEnabled(false);
		lblUser2.setPreferredSize(new Dimension(36, 40));
		panelNombres.add(lblUser2);

		lblUser3 = new JLabel("User3");
		lblUser3.setEnabled(false);
		lblUser3.setPreferredSize(new Dimension(36, 40));
		panelNombres.add(lblUser3);

		lblUser4 = new JLabel("User4");
		lblUser4.setEnabled(false);
		lblUser4.setPreferredSize(new Dimension(36, 40));
		panelNombres.add(lblUser4);

		JPanel panelNinas = new JPanel();
		add(panelNinas, BorderLayout.CENTER);
		panelNinas.setLayout(new GridLayout(0, 4, 0, 0));

		listUser1 = new JList();
		listUser1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panelNinas.add(listUser1);

		listUser2 = new JList();
		listUser2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panelNinas.add(listUser2);

		listUser3 = new JList();
		listUser3.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panelNinas.add(listUser3);

		listUser4 = new JList();
		listUser4.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panelNinas.add(listUser4);

		toolsManager = new ToolsManager(principal.getUsuarios(), this);
	}

	public void actualizarListas(ArrayList<Servicio> servicios, int i, Usuario user, int tot) {
		switch (i) {
		case 1:
			lblUser1.setEnabled(true);
			lblUser1.setText(user.darNombre());
			DefaultListModel modelo = new DefaultListModel();

			for(Servicio servicio: servicios) {
				String nom = servicio.darNombre();
				int costo = (int)servicio.darCosto();
				int comision = (int)servicio.darComisionUsuario();

				String muestra = nom + " $" + costo + "  Comision: $" + comision + "  Cliente: " + servicio.cliente;

				modelo.addElement(muestra);
			}
			modelo.addElement(" ");
			modelo.addElement("--------------------------------Total $" + tot + "--------------------------------");
			listUser1.setEnabled(true);
			listUser1.setModel(modelo);
			break;
		case 2:
			lblUser2.setEnabled(true);
			lblUser2.setText(user.darNombre());
			DefaultListModel modelo2 = new DefaultListModel();

			for(Servicio servicio: servicios) {
				String nom = servicio.darNombre();
				int costo = (int)servicio.darCosto();
				int comision = (int)servicio.darComisionUsuario();

				String muestra = nom + " $" + costo + "  Comision: $" + comision + "  Cliente: " + servicio.cliente;

				modelo2.addElement(muestra);

			}
			modelo2.addElement(" ");
			modelo2.addElement("--------------------------------Total $" + tot + "--------------------------------");
			listUser2.setModel(modelo2);
			break;
		case 3:
			lblUser3.setEnabled(true);
			lblUser3.setText(user.darNombre());
			DefaultListModel modelo3 = new DefaultListModel();

			for(Servicio servicio: servicios) {
				String nom = servicio.darNombre();
				int costo = (int)servicio.darCosto();
				int comision = (int)servicio.darComisionUsuario();

				String muestra = nom + " $" + costo + "  Comision: $" + comision + "  Cliente: " + servicio.cliente;

				modelo3.addElement(muestra);

			}
			modelo3.addElement(" ");
			modelo3.addElement("--------------------------------Total $" + tot + "--------------------------------");
			listUser3.setModel(modelo3);
			break;
		case 4:
			lblUser4.setEnabled(true);
			lblUser4.setText(user.darNombre());
			DefaultListModel modelo4 = new DefaultListModel();

			for(Servicio servicio: servicios) {
				String nom = servicio.darNombre();
				int costo = (int)servicio.darCosto();
				int comision = (int)servicio.darComisionUsuario();

				String muestra = nom + " $" + costo + "  Comision: $" + comision + "  Cliente: " + servicio.cliente;

				modelo4.addElement(muestra);

			}
			modelo4.addElement(" ");
			modelo4.addElement("--------------------------------Total $" + tot + "--------------------------------");
			listUser4.setModel(modelo4);
			break;

		default:
			break;
		}
	}

}
