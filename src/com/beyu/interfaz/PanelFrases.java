package com.beyu.interfaz;

import javax.swing.JPanel;
import javax.swing.JButton;

import com.beyu.mundo.Usuario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class PanelFrases extends JPanel {
	private static final long serialVersionUID = 1L;
	private JButton btnBtntexto;
	@SuppressWarnings("unused")
	private InterfazPrincipal ventana;
	public Usuario user;

	/**
	 * Create the panel.
	 * @param usuario 
	 * @param ventana 
	 */
	public PanelFrases(final InterfazPrincipal ventana, Usuario usuario) {
		this.ventana = ventana;
		this.user = usuario;
		setLayout(new BorderLayout(0, 0));
		
		btnBtntexto = new JButton("btnTexto");
		btnBtntexto.setFont(new Font("Helvetica Neue", Font.PLAIN, 80));
		btnBtntexto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelServicios panelServicios = new PanelServicios(ventana, user);
				ventana.changePanel(panelServicios);
			}
		});
		add(btnBtntexto);
		
		llenarFrase();
		validate();
	}

	private void llenarFrase() {
		try {
			BufferedReader in = new BufferedReader(new FileReader("./data/frases.btf"));
			File f = new File("./data/frases.btf");
			int c = 0;
			int x = (int) (Math.random() * 50);
			System.out.println(x);
			String lectura = in.readLine();
			while(lectura != null && c < x-1) {
				lectura = in.readLine();
				c++;
				System.out.println(c);
			}
			lectura = in.readLine();
			btnBtntexto.setText("<html><p align=\"center\">" + lectura + "</p></html>");
			int r = (int) (Math.random() * 200);
			int g = (int) (Math.random() * 200);
			int b = (int) (Math.random() * 200);
			Color color = new Color(r, g, b);
			btnBtntexto.setForeground(color);
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
