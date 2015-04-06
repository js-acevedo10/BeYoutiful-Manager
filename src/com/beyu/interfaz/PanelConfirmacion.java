package com.beyu.interfaz;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;

import java.awt.GridLayout;

import javax.swing.JButton;

import java.awt.Font;

import javax.swing.SwingConstants;

import com.beyu.mundo.CreadorRecibos;
import com.beyu.mundo.RegistroFacturas;
import com.beyu.mundo.databaseManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Dimension;

import javax.swing.JTextField;

import java.awt.Color;

public class PanelConfirmacion extends JPanel {

	public InterfazPrincipal principal;
	private JLabel lblTituloresumen;
	private JButton btnAceptarYContinuar;
	private JButton btnRechazar;
	private CreadorRecibos recibo;
	private JPanel panelTotal;
	private JLabel lblValorTotal;
	private JTextField txtValorTotal;
	private JLabel lblEfectivo;
	private JTextField txtPago;
	private JLabel lblCambio;
	private JTextField txtCambio;
	private databaseManager databaseManager;
	
	/**
	 * Create the panel.
	 */
	public PanelConfirmacion(InterfazPrincipal ventana, CreadorRecibos recibo) {
		this.recibo = recibo;
		setLayout(new BorderLayout(0, 0));
		
		databaseManager = new databaseManager();
		lblTituloresumen = new JLabel("Estimado Cliente,");
		lblTituloresumen.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloresumen.setFont(new Font("Helvetica Neue", Font.PLAIN, 45));
		add(lblTituloresumen, BorderLayout.NORTH);
		
		JPanel panelBotones = new JPanel();
		panelBotones.setPreferredSize(new Dimension(10, 100));
		add(panelBotones, BorderLayout.SOUTH);
		panelBotones.setLayout(new GridLayout(1, 0, 0, 0));
		
		btnRechazar = new JButton("Rechazar");
		btnRechazar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principal.restart();
			}
		});
		btnRechazar.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
		panelBotones.add(btnRechazar);
		
		btnAceptarYContinuar = new JButton("Aceptar y Continuar");
		btnAceptarYContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean mark = false;
				if(!txtPago.getText().equals("") && !txtCambio.getText().equals("Error") && !txtCambio.getText().contains("-"))
				{
					String nombre = JOptionPane.showInputDialog("<html><span style='font-size:20px'>Ingresa el nombre del usuario.");
					if(nombre != null && !nombre.equalsIgnoreCase("")) {
						String apellido = JOptionPane.showInputDialog("<html><span style='font-size:20px'>Ingresa el apellido del usuario.");
						if(apellido != null && !apellido.equals("")) {
							String correo = JOptionPane.showInputDialog("<html><span style='font-size:20px'>Ingresa el correo del usuario");
							if(correo == null || !correo.contains("@") || correo.contains(" ") || !correo.contains(".")) {
								JOptionPane.showMessageDialog(principal, "Error en los datos.");
							} else {
								databaseManager.addUserToDatabase(nombre, apellido, correo);
								mark = true;
							}
						}
					}
					if(mark) {
						generarRecibo(nombre);
						PanelAgradecimiento panelAgradecimiento = new PanelAgradecimiento(principal, txtCambio.getText());
						principal.changePanel(panelAgradecimiento);
					}
				}
			}
		});
		btnAceptarYContinuar.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
		panelBotones.add(btnAceptarYContinuar);
		
		panelTotal = new JPanel();
		add(panelTotal, BorderLayout.CENTER);
		panelTotal.setLayout(new GridLayout(0, 1, 0, 0));
		
		lblValorTotal = new JLabel("El valor total del servicio es de:");
		lblValorTotal.setFont(new Font("Helvetica Neue", Font.PLAIN, 40));
		panelTotal.add(lblValorTotal);
		
		txtValorTotal = new JTextField();
		txtValorTotal.setHorizontalAlignment(SwingConstants.CENTER);
		txtValorTotal.setEditable(false);
		String textoTotal = "$" + recibo.darTotal()+"";
		txtValorTotal.setText(textoTotal.replace(".0", ""));
		txtValorTotal.setFont(new Font("Helvetica Neue", Font.PLAIN, 82));
		txtValorTotal.setForeground(Color.GREEN);
		panelTotal.add(txtValorTotal);
		txtValorTotal.setColumns(10);
		
		lblEfectivo = new JLabel("Ingrese aqui el monto en efectivo con el que se hara el pago:");
		lblEfectivo.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
		panelTotal.add(lblEfectivo);
		
		txtPago = new JTextField();
		txtPago.setFont(new Font("Helvetica Neue", Font.PLAIN, 60));
		txtPago.setHorizontalAlignment(SwingConstants.CENTER);
		txtPago.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				String x = txtPago.getText();
				try {
					int y = Integer.parseInt(x);
					String costo = txtValorTotal.getText().replace("$", "").replace(".0", "");
					int z = Integer.parseInt(costo);
					int resto = y-z;
					txtCambio.setText("$" + resto);
				} catch (Exception c) {
					txtCambio.setText("Error");
				}
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				
			}
		});
		txtPago.requestFocus();
		panelTotal.add(txtPago);
		txtPago.setColumns(10);
		
		lblCambio = new JLabel("El cambio es de:");
		lblCambio.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCambio.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
		panelTotal.add(lblCambio);

		txtCambio = new JTextField();
		txtCambio.setEditable(false);
		txtCambio.setForeground(Color.RED);
		txtCambio.setFont(new Font("Helvetica Neue", Font.PLAIN, 60));
		txtCambio.setHorizontalAlignment(SwingConstants.CENTER);
		txtCambio.setText("$0.0");
		panelTotal.add(txtCambio);
		txtCambio.setColumns(10);
		principal = ventana;
	}
	protected void generarRecibo(String nombre) {
		RegistroFacturas registrar = new RegistroFacturas(recibo, recibo.darUsuario(), nombre);
		registrar.exportarRecibo();
	}
}