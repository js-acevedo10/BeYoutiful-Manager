package com.beyu.interfaz;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;

import com.beyu.mundo.Usuario;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;

public class PanelBienvenida extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private InterfazPrincipal ventana;
	private ArrayList<Usuario> usuarios;
	private JButton btnUser;
	private JButton btnUser_1;
	private JButton btnUser_2;
	private JButton btnUser_3;
	private JButton btnAdmin;
	private JButton btnTools;

	/**
	 * Create the panel.
	 * @param usuarios 
	 */
	public PanelBienvenida(final InterfazPrincipal ventana) {
		this.ventana = ventana;
		this.usuarios = this.ventana.getUsuarios();
		setBackground(new Color(255, 182, 193));
		setLayout(new GridLayout(2, 0, 0, 0));
		
		btnUser = new JButton("User1");
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PanelFrases panelFrases = new PanelFrases(ventana, ventana.getUser(btnUser.getText()));
				ventana.changePanel(panelFrases);
			}
		});
		btnUser.setFont(new Font("Helvetica Neue", Font.PLAIN, 25));
		add(btnUser);
		
		btnUser_1 = new JButton("User2");
		btnUser_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PanelFrases panelFrases = new PanelFrases(ventana, ventana.getUser(btnUser_1.getText()));
				ventana.changePanel(panelFrases);
			}
		});
		btnUser_1.setFont(new Font("Helvetica Neue", Font.PLAIN, 25));
		add(btnUser_1);
		
		btnUser_2 = new JButton("User3");
		btnUser_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PanelFrases panelFrases = new PanelFrases(ventana, ventana.getUser(btnUser_2.getText()));
				ventana.changePanel(panelFrases);
			}
		});
		btnUser_2.setFont(new Font("Helvetica Neue", Font.PLAIN, 25));
		add(btnUser_2);
		
		btnUser_3 = new JButton("User4");
		btnUser_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PanelFrases panelFrases = new PanelFrases(ventana, ventana.getUser(btnUser_3.getText()));
				ventana.changePanel(panelFrases);
			}
		});
		btnUser_3.setFont(new Font("Helvetica Neue", Font.PLAIN, 25));
		add(btnUser_3);
		
		btnAdmin = new JButton("Admin");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JPanel panel = new JPanel();
				JLabel label = new JLabel("Ingresa la contrasena:");
				JPasswordField pass = new JPasswordField(10);
				pass.requestFocus();
				panel.add(label);
				panel.add(pass);
				String[] options = new String[]{"OK", "Cancel"};
				int option = JOptionPane.showOptionDialog(null, panel, "The title",
				                         JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
				                         null, options, options[0]);
				if(option == 0) // pressing OK button
				{
				    String pass1 = pass.getText();
				    File x = new File("./data/admin.btf");
					ventana.loginAdmin(pass1, x);
				}				
			}
		});
		btnAdmin.setFont(new Font("Helvetica Neue", Font.PLAIN, 25));
		add(btnAdmin);
		
		btnTools = new JButton("Tools");
		btnTools.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PanelTool panelTools = new PanelTool(ventana);
				ventana.changePanel(panelTools);
			}
		});
		btnTools.setFont(new Font("Helvetica Neue", Font.PLAIN, 25));
		add(btnTools);
		
		renameButtons(usuarios);
	}
	
	public void renameButtons(ArrayList<Usuario> users) {
		int x = 1;
		for(Usuario user : users) {
			if(x==1)btnUser.setText(user.darNombre());
			if(x==2)btnUser_1.setText(user.darNombre());
			if(x==3)btnUser_2.setText(user.darNombre());
			if(x==4)btnUser_3.setText(user.darNombre());
			x++;
		}
		if(btnUser.getText().contains("User")) {
			btnUser.setEnabled(false);
		}
		if(btnUser_1.getText().contains("User")) {
			btnUser_1.setEnabled(false);
		}
		if(btnUser_2.getText().contains("User")) {
			btnUser_2.setEnabled(false);
		}
		if(btnUser_3.getText().contains("User")) {
			btnUser_3.setEnabled(false);
		}
	}

}
