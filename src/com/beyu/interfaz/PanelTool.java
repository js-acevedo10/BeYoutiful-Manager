package com.beyu.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int user = JOptionPane.showOptionDialog(null, "Elegir el empleado que ha llegado:", "Registrar Llegada", JOptionPane.OK_CANCEL_OPTION, 0, null, ops, ops[0]);
				String usuario = "";
				if(user >= 0) {
					usuario = ops[user];
					
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
