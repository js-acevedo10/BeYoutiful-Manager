package com.beyu.interfaz;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelAgradecimiento extends JPanel {
	InterfazPrincipal principal;

	/**
	 * Create the panel.
	 * @param vueltas 
	 */
	public PanelAgradecimiento(InterfazPrincipal ventana, String vueltas) {
		setLayout(new BorderLayout(0, 0));
		principal = ventana;
		
		JLabel lblmuchasGracias = new JLabel("Muchas gracias por tu compra!");
		lblmuchasGracias.setFont(new Font("Helvetica Neue", Font.PLAIN, 80));
		lblmuchasGracias.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblmuchasGracias, BorderLayout.NORTH);
		
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principal.restart();
			}
		});
		btnContinuar.setFont(new Font("Helvetica Neue", Font.PLAIN, 60));
		add(btnContinuar, BorderLayout.SOUTH);
		
		JLabel lblVueltas = new JLabel("Recuerda que debes recibir " + vueltas + " de cambio.");
		lblVueltas.setHorizontalAlignment(SwingConstants.CENTER);
		lblVueltas.setFont(new Font("Helvetica Neue", Font.PLAIN, 44));
		add(lblVueltas, BorderLayout.CENTER);

	}

}
