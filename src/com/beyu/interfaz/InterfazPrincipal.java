package com.beyu.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.beyu.mundo.Dia;
import com.beyu.mundo.Manager;
import com.beyu.mundo.Usuario;

public class InterfazPrincipal extends JFrame {

	private JPanel contentPane;
	private PanelBienvenida panelBienvenida;
	private JPanel panelActual;
	private Manager manager;
	public PanelAdmin panelAdmin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazPrincipal frame = new InterfazPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InterfazPrincipal() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setVisible(true);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//------------------Manager
		
		manager = new Manager();
		
		//-------------------------
		
		panelBienvenida = new PanelBienvenida(this);
		panelActual = panelBienvenida;
		contentPane.add(panelActual, BorderLayout.CENTER);
	}
	
	public ArrayList<Usuario> getUsuarios() {
		return manager.getUsuarios();
	}
	
	public ArrayList<Dia> getDias() {
		return manager.getDias();
	}

	public void changePanel(JPanel panel) {
		removePanel();
		panelActual = panel;
		panelActual.setVisible(true);
		contentPane.add(panelActual, BorderLayout.CENTER);
	}
	
	public void removePanel() {
		panelActual.setVisible(false);
		contentPane.remove(panelActual);
		panelActual = null;
	}

	public void restart() {
		changePanel(panelBienvenida);
	}

	public Usuario getUser(String text) {
		for(Usuario user: getUsuarios()) {
			if(user.darNombre().equalsIgnoreCase(text)) {
				return user;
			}
		}
		return null;
	}

	public void loginAdmin(String pass, File x) {
		boolean login = manager.loginAdmin(pass, x);
		if(login) {
			panelAdmin = new PanelAdmin(this);
			changePanel(panelAdmin);
		}
		else {
			JOptionPane.showMessageDialog(this, "Contrasena incorrecta");
		}
	}

	public Manager darMundo() {
		return manager;
	}
}
