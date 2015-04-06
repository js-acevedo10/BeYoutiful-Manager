package com.beyu.interfaz;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Dimension;
import java.awt.Color;

import javax.swing.border.MatteBorder;

import com.beyu.mundo.Administrador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.swing.JSpinner;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class PanelAdmin extends JPanel {
	public JTextField txtUser1Servicios;
	public JTextField txtUser1Producido;
	public JTextField txtUser1Comision;
	public JTextField txtUser1Ganancia;
	public JTextField txtUser2Servicios;
	public JTextField txtUser2Producido;
	public JTextField txtUser2Comision;
	public JTextField txtUser2Ganancia;
	public JTextField txtUser3Servicios;
	public JTextField txtUser3Producido;
	public JTextField txtUser3Comision;
	public JTextField txtUser3Ganancia;
	public JTextField txtUser4Servicios;
	public JTextField txtUser4Producido;
	public JTextField txtUser4Comision;
	public JTextField txtUser4Ganancia;
	
	public JButton btnUser1Name;
	public JButton btnUser2Name;
	public JButton btnUser3Name;
	public JButton btnUser4Name;
	public JButton btnTotal;
	
	public JTextField txtTotalServicios;
	public JTextField txtTotalProducido;
	public JTextField txtTotalComision;
	public JTextField txtTotalGanancias;
	public JPanel panelCentroAbajo;
	public JPanel panelBotonesDias;
	public JButton btnDiaAnterior;
	public JButton btnDiaSiguiente;
	public JLabel lblFechaActual;
	public JLabel lblFechaDinamica;
	public JButton btnCerrarSesion;
	public JButton btnExportarAExcel;
	InterfazPrincipal principal;
	Administrador administrador;
	private JPanel panelCharts;
	private JPanel panelPeriodoTiempo;
	private JLabel lblFechaInicial;
	private JLabel lblFechaFinal;
	private JButton btnAnalizar;
	private JDatePickerImpl datePickerInicio;
	private JDatePickerImpl datePickerFinal;
	private JPanel panel;
	private JLabel lblNombre_1;
	private JLabel lblServicios_1;
	private JTextField txtUserunosemanalproducido;
	private JTextField txtUserunosemanalcomision;
	private JTextField txtUserunosemanalganancia;
	private JTextField txtUserdossemanalservicios;
	private JTextField txtUserdossemanalproducido;
	private JTextField txtUserdossemanalcomision;
	private JTextField txtUserdossemanalganancia;
	private JTextField txtUsertressemanalservicios;
	private JTextField txtUsertressemanalproducido;
	private JTextField txtUsertressemanalcomision;
	private JTextField txtUsertressemanalganancia;
	private JTextField txtUsercuatrosemanalservicios;
	private JTextField txtUsercuatrosemanalproducido;
	private JTextField txtUsercuatrosemanalcomision;
	private JTextField txtUsercuatrosemanalganancia;
	private JTextField txtTotalsemanalservicios;
	private JTextField txtTotalsemanaproducido;
	private JTextField txtTotalsemanacomision;
	private JTextField txtTotalsemanaganancia;
	private JButton btnUserunosemanal;
	private JButton btnUserdossemanal;
	private JButton btnUsertressemanal;
	private JButton btnUsercuatrosemanal;
	private JButton btnTotalsemana;
	private JTextField txtUserunosemanalservicios;

	/**
	 * Create the panel.
	 */
	public PanelAdmin(InterfazPrincipal ventana) {
		setLayout(new BorderLayout(0, 0));
		
		principal = ventana;
	
		JLabel lblBienvenidoAdmin = new JLabel("Bienvenido Admin");
		lblBienvenidoAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenidoAdmin.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
		add(lblBienvenidoAdmin, BorderLayout.NORTH);
		
		JPanel panelCentro = new JPanel();
		add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(2, 2, 0, 0));
		
		JPanel panelCentroArriba = new JPanel();
		panelCentro.add(panelCentroArriba);
		panelCentroArriba.setLayout(new BorderLayout(0, 0));
		
		panelCharts = new JPanel();
		panelCentroArriba.add(panelCharts, BorderLayout.CENTER);
		panelCharts.setLayout(new BorderLayout(0, 0));
		
		panelPeriodoTiempo = new JPanel();
		panelPeriodoTiempo.setBackground(new Color(153, 255, 255));
		panelPeriodoTiempo.setPreferredSize(new Dimension(10, 40));
		panelCharts.add(panelPeriodoTiempo, BorderLayout.NORTH);
		panelPeriodoTiempo.setLayout(new GridLayout(1, 1, 0, 0));
		
		lblFechaInicial = new JLabel("Fecha Inicial");
		lblFechaInicial.setHorizontalAlignment(SwingConstants.CENTER);
		panelPeriodoTiempo.add(lblFechaInicial);
		
		UtilDateModel model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanelInicio = new JDatePanelImpl(model, p);
		datePickerInicio = new JDatePickerImpl(datePanelInicio, new DateLabelFormatter());
		datePickerInicio.setBackground(new Color(153, 255, 255));
		panelPeriodoTiempo.add(datePickerInicio);
		
		lblFechaFinal = new JLabel("Fecha Final");
		lblFechaFinal.setHorizontalAlignment(SwingConstants.CENTER);
		panelPeriodoTiempo.add(lblFechaFinal);
		
		UtilDateModel modelo = new UtilDateModel();
		JDatePanelImpl datePanelFinal = new JDatePanelImpl(modelo, p);
		datePickerFinal = new JDatePickerImpl(datePanelFinal, new DateLabelFormatter());
		datePickerFinal.setBackground(new Color(153, 255, 255));
		panelPeriodoTiempo.add(datePickerFinal);
		
		btnAnalizar = new JButton("Analizar");
		btnAnalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Date dateInicio = (Date) datePickerInicio.getModel().getValue();
				Date dateFinal = (Date) datePickerFinal.getModel().getValue();
				
				if(dateInicio != null && dateFinal != null && (dateInicio.before(dateFinal))) {
					administrador.leerSemana(dateInicio, dateFinal);
					repaint();
					validate();
				}
			}
		});
		panelPeriodoTiempo.add(btnAnalizar);
		
		panel = new JPanel();
		panel.setBackground(new Color(204, 255, 255));
		panelCharts.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(6, 5, 0, 0));
		
		lblNombre_1 = new JLabel("Nombre");
		lblNombre_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNombre_1);
		
		lblServicios_1 = new JLabel("Servicios");
		lblServicios_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblServicios_1);
		
		JLabel lblProducido_1 = new JLabel("Producido");
		lblProducido_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblProducido_1);
		
		JLabel lblComision_1 = new JLabel("Comision");
		lblComision_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblComision_1);
		
		JLabel lblGanancia_1 = new JLabel("Ganancia");
		lblGanancia_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblGanancia_1);
		
		btnUserunosemanal = new JButton("UserUnoSemanal");
		btnUserunosemanal.setEnabled(false);
		panel.add(btnUserunosemanal);
		
		txtUserunosemanalservicios = new JTextField();
		txtUserunosemanalservicios.setEnabled(false);
		txtUserunosemanalservicios.setEditable(false);
		txtUserunosemanalservicios.setText("0");
		panel.add(txtUserunosemanalservicios);
		txtUserunosemanalservicios.setColumns(10);
		
		txtUserunosemanalproducido = new JTextField();
		txtUserunosemanalproducido.setEnabled(false);
		txtUserunosemanalproducido.setEditable(false);
		txtUserunosemanalproducido.setText("0");
		panel.add(txtUserunosemanalproducido);
		txtUserunosemanalproducido.setColumns(10);
		
		txtUserunosemanalcomision = new JTextField();
		txtUserunosemanalcomision.setEnabled(false);
		txtUserunosemanalcomision.setEditable(false);
		txtUserunosemanalcomision.setText("0");
		panel.add(txtUserunosemanalcomision);
		txtUserunosemanalcomision.setColumns(10);
		
		txtUserunosemanalganancia = new JTextField();
		txtUserunosemanalganancia.setEnabled(false);
		txtUserunosemanalganancia.setEditable(false);
		txtUserunosemanalganancia.setText("0");
		panel.add(txtUserunosemanalganancia);
		txtUserunosemanalganancia.setColumns(10);
		
		btnUserdossemanal = new JButton("UserDosSemanal");
		btnUserdossemanal.setEnabled(false);
		panel.add(btnUserdossemanal);
		
		txtUserdossemanalservicios = new JTextField();
		txtUserdossemanalservicios.setEnabled(false);
		txtUserdossemanalservicios.setEditable(false);
		txtUserdossemanalservicios.setText("0");
		panel.add(txtUserdossemanalservicios);
		txtUserdossemanalservicios.setColumns(10);
		
		txtUserdossemanalproducido = new JTextField();
		txtUserdossemanalproducido.setEnabled(false);
		txtUserdossemanalproducido.setEditable(false);
		txtUserdossemanalproducido.setText("0");
		panel.add(txtUserdossemanalproducido);
		txtUserdossemanalproducido.setColumns(10);
		
		txtUserdossemanalcomision = new JTextField();
		txtUserdossemanalcomision.setEnabled(false);
		txtUserdossemanalcomision.setEditable(false);
		txtUserdossemanalcomision.setText("0");
		panel.add(txtUserdossemanalcomision);
		txtUserdossemanalcomision.setColumns(10);
		
		txtUserdossemanalganancia = new JTextField();
		txtUserdossemanalganancia.setEnabled(false);
		txtUserdossemanalganancia.setEditable(false);
		txtUserdossemanalganancia.setText("0");
		panel.add(txtUserdossemanalganancia);
		txtUserdossemanalganancia.setColumns(10);
		
		btnUsertressemanal = new JButton("UserTresSemanal");
		btnUsertressemanal.setEnabled(false);
		panel.add(btnUsertressemanal);
		
		txtUsertressemanalservicios = new JTextField();
		txtUsertressemanalservicios.setEnabled(false);
		txtUsertressemanalservicios.setEditable(false);
		txtUsertressemanalservicios.setText("0");
		panel.add(txtUsertressemanalservicios);
		txtUsertressemanalservicios.setColumns(10);
		
		txtUsertressemanalproducido = new JTextField();
		txtUsertressemanalproducido.setEnabled(false);
		txtUsertressemanalproducido.setEditable(false);
		txtUsertressemanalproducido.setText("0");
		panel.add(txtUsertressemanalproducido);
		txtUsertressemanalproducido.setColumns(10);
		
		txtUsertressemanalcomision = new JTextField();
		txtUsertressemanalcomision.setEnabled(false);
		txtUsertressemanalcomision.setEditable(false);
		txtUsertressemanalcomision.setText("0");
		panel.add(txtUsertressemanalcomision);
		txtUsertressemanalcomision.setColumns(10);
		
		txtUsertressemanalganancia = new JTextField();
		txtUsertressemanalganancia.setEnabled(false);
		txtUsertressemanalganancia.setEditable(false);
		txtUsertressemanalganancia.setText("0");
		panel.add(txtUsertressemanalganancia);
		txtUsertressemanalganancia.setColumns(10);
		
		btnUsercuatrosemanal = new JButton("UserCuatroSemanal");
		btnUsercuatrosemanal.setEnabled(false);
		panel.add(btnUsercuatrosemanal);
		
		txtUsercuatrosemanalservicios = new JTextField();
		txtUsercuatrosemanalservicios.setEnabled(false);
		txtUsercuatrosemanalservicios.setEditable(false);
		txtUsercuatrosemanalservicios.setText("0");
		panel.add(txtUsercuatrosemanalservicios);
		txtUsercuatrosemanalservicios.setColumns(10);
		
		txtUsercuatrosemanalproducido = new JTextField();
		txtUsercuatrosemanalproducido.setEnabled(false);
		txtUsercuatrosemanalproducido.setEditable(false);
		txtUsercuatrosemanalproducido.setText("0");
		panel.add(txtUsercuatrosemanalproducido);
		txtUsercuatrosemanalproducido.setColumns(10);
		
		txtUsercuatrosemanalcomision = new JTextField();
		txtUsercuatrosemanalcomision.setEnabled(false);
		txtUsercuatrosemanalcomision.setEditable(false);
		txtUsercuatrosemanalcomision.setText("0");
		panel.add(txtUsercuatrosemanalcomision);
		txtUsercuatrosemanalcomision.setColumns(10);
		
		txtUsercuatrosemanalganancia = new JTextField();
		txtUsercuatrosemanalganancia.setEnabled(false);
		txtUsercuatrosemanalganancia.setEditable(false);
		txtUsercuatrosemanalganancia.setText("0");
		panel.add(txtUsercuatrosemanalganancia);
		txtUsercuatrosemanalganancia.setColumns(10);
		
		btnTotalsemana = new JButton("TotalSemana");
		btnTotalsemana.setEnabled(false);
		panel.add(btnTotalsemana);
		
		txtTotalsemanalservicios = new JTextField();
		txtTotalsemanalservicios.setEnabled(false);
		txtTotalsemanalservicios.setEditable(false);
		txtTotalsemanalservicios.setText("0");
		panel.add(txtTotalsemanalservicios);
		txtTotalsemanalservicios.setColumns(10);
		
		txtTotalsemanaproducido = new JTextField();
		txtTotalsemanaproducido.setEnabled(false);
		txtTotalsemanaproducido.setEditable(false);
		txtTotalsemanaproducido.setText("0");
		panel.add(txtTotalsemanaproducido);
		txtTotalsemanaproducido.setColumns(10);
		
		txtTotalsemanacomision = new JTextField();
		txtTotalsemanacomision.setEnabled(false);
		txtTotalsemanacomision.setEditable(false);
		txtTotalsemanacomision.setText("0");
		panel.add(txtTotalsemanacomision);
		txtTotalsemanacomision.setColumns(10);
		
		txtTotalsemanaganancia = new JTextField();
		txtTotalsemanaganancia.setEnabled(false);
		txtTotalsemanaganancia.setEditable(false);
		txtTotalsemanaganancia.setText("0");
		panel.add(txtTotalsemanaganancia);
		txtTotalsemanaganancia.setColumns(10);
		
		panelCentroAbajo = new JPanel();
		panelCentroAbajo.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 102, 255)));
		panelCentroAbajo.setBackground(new Color(255, 102, 255));
		panelCentro.add(panelCentroAbajo);
		panelCentroAbajo.setLayout(new BorderLayout(0, 0));
		
		JPanel panelDia = new JPanel();
		panelCentroAbajo.add(panelDia, BorderLayout.CENTER);
		panelDia.setLayout(new BorderLayout(0, 0));
		
		panelBotonesDias = new JPanel();
		panelDia.add(panelBotonesDias, BorderLayout.NORTH);
		panelBotonesDias.setBackground(new Color(255, 153, 255));
		panelBotonesDias.setPreferredSize(new Dimension(10, 40));
		panelBotonesDias.setLayout(new GridLayout(1, 0, 0, 0));
		
		btnDiaAnterior = new JButton("Dia Anterior");
		btnDiaAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				administrador.leerAnteriorDia();
				repaint();
				validate();
			}
		});
		panelBotonesDias.add(btnDiaAnterior);
		
		lblFechaActual = new JLabel("Fecha Actual:  ");
		lblFechaActual.setHorizontalAlignment(SwingConstants.RIGHT);
		panelBotonesDias.add(lblFechaActual);
		
		lblFechaDinamica = new JLabel("Fecha");
		panelBotonesDias.add(lblFechaDinamica);
		
		btnDiaSiguiente = new JButton("Dia Siguiente");
		btnDiaSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				administrador.leerSiguienteDia();
				validate();
				repaint();
			}
		});
		panelBotonesDias.add(btnDiaSiguiente);
		
		JPanel panelIzquierdaAbajo = new JPanel();
		panelDia.add(panelIzquierdaAbajo, BorderLayout.CENTER);
		panelIzquierdaAbajo.setBackground(new Color(255, 204, 255));
		panelIzquierdaAbajo.setLayout(new GridLayout(6, 5, 0, 0));
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		panelIzquierdaAbajo.add(lblNombre);
		
		JLabel lblServicios = new JLabel("Servicios");
		lblServicios.setHorizontalAlignment(SwingConstants.CENTER);
		panelIzquierdaAbajo.add(lblServicios);
		
		JLabel lblProducido = new JLabel("Producido");
		lblProducido.setHorizontalAlignment(SwingConstants.CENTER);
		panelIzquierdaAbajo.add(lblProducido);
		
		JLabel lblComision = new JLabel("Comision");
		lblComision.setHorizontalAlignment(SwingConstants.CENTER);
		panelIzquierdaAbajo.add(lblComision);
		
		JLabel lblGanancia = new JLabel("Ganancia");
		lblGanancia.setHorizontalAlignment(SwingConstants.CENTER);
		panelIzquierdaAbajo.add(lblGanancia);
		
		btnUser1Name = new JButton("User1");
		panelIzquierdaAbajo.add(btnUser1Name);
		
		txtUser1Servicios = new JTextField();
		txtUser1Servicios.setText("0");
		txtUser1Servicios.setEditable(false);
		panelIzquierdaAbajo.add(txtUser1Servicios);
		txtUser1Servicios.setColumns(10);
		
		txtUser1Producido = new JTextField();
		txtUser1Producido.setText("0");
		txtUser1Producido.setEditable(false);
		panelIzquierdaAbajo.add(txtUser1Producido);
		txtUser1Producido.setColumns(10);
		
		txtUser1Comision = new JTextField();
		txtUser1Comision.setText("0");
		txtUser1Comision.setEditable(false);
		panelIzquierdaAbajo.add(txtUser1Comision);
		txtUser1Comision.setColumns(10);
		
		txtUser1Ganancia = new JTextField();
		txtUser1Ganancia.setText("0");
		txtUser1Ganancia.setEditable(false);
		panelIzquierdaAbajo.add(txtUser1Ganancia);
		txtUser1Ganancia.setColumns(10);
		
		btnUser2Name = new JButton("User2");
		panelIzquierdaAbajo.add(btnUser2Name);
		
		txtUser2Servicios = new JTextField();
		txtUser2Servicios.setText("0");
		txtUser2Servicios.setEditable(false);
		panelIzquierdaAbajo.add(txtUser2Servicios);
		txtUser2Servicios.setColumns(10);
		
		txtUser2Producido = new JTextField();
		txtUser2Producido.setText("0");
		txtUser2Producido.setEditable(false);
		panelIzquierdaAbajo.add(txtUser2Producido);
		txtUser2Producido.setColumns(10);
		
		txtUser2Comision = new JTextField();
		txtUser2Comision.setText("0");
		txtUser2Comision.setEditable(false);
		panelIzquierdaAbajo.add(txtUser2Comision);
		txtUser2Comision.setColumns(10);
		
		txtUser2Ganancia = new JTextField();
		txtUser2Ganancia.setText("0");
		txtUser2Ganancia.setEditable(false);
		panelIzquierdaAbajo.add(txtUser2Ganancia);
		txtUser2Ganancia.setColumns(10);
		
		btnUser3Name = new JButton("User3");
		panelIzquierdaAbajo.add(btnUser3Name);
		
		txtUser3Servicios = new JTextField();
		txtUser3Servicios.setText("0");
		txtUser3Servicios.setEditable(false);
		panelIzquierdaAbajo.add(txtUser3Servicios);
		txtUser3Servicios.setColumns(10);
		
		txtUser3Producido = new JTextField();
		txtUser3Producido.setText("0");
		txtUser3Producido.setEditable(false);
		panelIzquierdaAbajo.add(txtUser3Producido);
		txtUser3Producido.setColumns(10);
		
		txtUser3Comision = new JTextField();
		txtUser3Comision.setText("0");
		txtUser3Comision.setEditable(false);
		panelIzquierdaAbajo.add(txtUser3Comision);
		txtUser3Comision.setColumns(10);
		
		txtUser3Ganancia = new JTextField();
		txtUser3Ganancia.setText("0");
		txtUser3Ganancia.setEditable(false);
		panelIzquierdaAbajo.add(txtUser3Ganancia);
		txtUser3Ganancia.setColumns(10);
		
		btnUser4Name = new JButton("User4");
		panelIzquierdaAbajo.add(btnUser4Name);
		
		txtUser4Servicios = new JTextField();
		txtUser4Servicios.setText("0");
		txtUser4Servicios.setEditable(false);
		panelIzquierdaAbajo.add(txtUser4Servicios);
		txtUser4Servicios.setColumns(10);
		
		txtUser4Producido = new JTextField();
		txtUser4Producido.setText("0");
		txtUser4Producido.setEditable(false);
		panelIzquierdaAbajo.add(txtUser4Producido);
		txtUser4Producido.setColumns(10);
		
		txtUser4Comision = new JTextField();
		txtUser4Comision.setText("0");
		txtUser4Comision.setEditable(false);
		panelIzquierdaAbajo.add(txtUser4Comision);
		txtUser4Comision.setColumns(10);
		
		txtUser4Ganancia = new JTextField();
		txtUser4Ganancia.setText("0");
		txtUser4Ganancia.setEditable(false);
		panelIzquierdaAbajo.add(txtUser4Ganancia);
		txtUser4Ganancia.setColumns(10);
		
		btnTotal = new JButton("Total");
		panelIzquierdaAbajo.add(btnTotal);
		
		txtTotalServicios = new JTextField();
		txtTotalServicios.setEditable(false);
		panelIzquierdaAbajo.add(txtTotalServicios);
		txtTotalServicios.setColumns(10);
		
		txtTotalProducido = new JTextField();
		txtTotalProducido.setEditable(false);
		txtTotalProducido.setColumns(10);
		panelIzquierdaAbajo.add(txtTotalProducido);
		
		txtTotalComision = new JTextField();
		txtTotalComision.setEditable(false);
		txtTotalComision.setColumns(10);
		panelIzquierdaAbajo.add(txtTotalComision);
		
		txtTotalGanancias = new JTextField();
		txtTotalGanancias.setEditable(false);
		txtTotalGanancias.setColumns(10);
		panelIzquierdaAbajo.add(txtTotalGanancias);
		
		JPanel panelSur = new JPanel();
		add(panelSur, BorderLayout.SOUTH);
		
		btnCerrarSesion = new JButton("Cerrar Sesion");
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				principal.restart();
			}
		});
		panelSur.add(btnCerrarSesion);
		
		btnExportarAExcel = new JButton("Exportar A Excel");
		panelSur.add(btnExportarAExcel);
		
		administrador = new Administrador(principal, this);

	}
	
	@SuppressWarnings("rawtypes")
	public void actualizarInformacion(ArrayList info, int user, String fecha) {
		String nombre = (String) info.get(0);//Nombre del empleado USED
		Integer cantidadServicios = (Integer) info.get(1);//Cantidad de servicios del empleado USED
		Integer comision = (Integer) info.get(2);//Comision USED
		Integer ganancias = (Integer) info.get(3);//Ganancias USED
		Integer producido = (Integer) info.get(4);//Total producido de la suma aplicando el descuento
		lblFechaDinamica.setText(fecha);
		
		switch (user) {
		case 0:
			btnUser1Name.setText(nombre);
			txtUser1Servicios.setText(cantidadServicios + "");
			txtUser1Producido.setText("$" + producido);
			txtUser1Comision.setText("$" + comision);
			txtUser1Ganancia.setText("$" + ganancias);
			sumarTotal();
			break;
		case 1:
			btnUser2Name.setText(nombre);
			txtUser2Servicios.setText(cantidadServicios + "");
			txtUser2Producido.setText("$" + producido);
			txtUser2Comision.setText("$" + comision);
			txtUser2Ganancia.setText("$" + ganancias);
			sumarTotal();
			break;
		case 2:
			btnUser3Name.setText(nombre);
			txtUser3Servicios.setText(cantidadServicios + "");
			txtUser3Producido.setText("$" + producido);
			txtUser3Comision.setText("$" + comision);
			txtUser3Ganancia.setText("$" + ganancias);
			sumarTotal();
			break;
		case 4:
			btnUser4Name.setText(nombre);
			txtUser4Servicios.setText(cantidadServicios + "");
			txtUser4Producido.setText("$" + producido);
			txtUser4Comision.setText("$" + comision);
			txtUser4Ganancia.setText("$" + ganancias);
			sumarTotal();
			break;
			//Casos semanales
		case 10:
			btnUserunosemanal.setText(nombre);
			txtUserunosemanalservicios.setText(cantidadServicios + "");
			txtUserunosemanalcomision.setText("$" + comision);
			txtUserunosemanalproducido.setText("$" + producido);
			txtUserunosemanalganancia.setText("$" + ganancias);
			totalSemanal();
			break;
		case 11:
			btnUserdossemanal.setText(nombre);
			txtUserdossemanalservicios.setText(cantidadServicios + "");
			txtUserdossemanalcomision.setText("$" + comision);
			txtUserdossemanalproducido.setText("$" + producido);
			txtUserdossemanalganancia.setText("$" + ganancias);
			totalSemanal();
			break;
		case 12:
			btnUsertressemanal.setText(nombre);
			txtUsertressemanalservicios.setText(cantidadServicios + "");
			txtUsertressemanalcomision.setText("$" + comision);
			txtUsertressemanalproducido.setText("$" + producido);
			txtUsertressemanalganancia.setText("$" + ganancias);
			totalSemanal();
			break;
		case 13:
			btnUsercuatrosemanal.setText(nombre);
			txtUsercuatrosemanalservicios.setText(cantidadServicios + "");
			txtUsercuatrosemanalcomision.setText("$" + comision);
			txtUsercuatrosemanalproducido.setText("$" + producido);
			txtUsercuatrosemanalganancia.setText("$" + ganancias);
			totalSemanal();
			break;
		default:
			break;
		}
	}

	private void sumarTotal() {
		
		if(btnUser1Name.getText().contains("User")) {
			btnUser1Name.setEnabled(false);
			txtUser1Comision.setEnabled(false);
			txtUser1Ganancia.setEnabled(false);
			txtUser1Producido.setEnabled(false);
		} else {
			btnUser1Name.setEnabled(true);
			txtUser1Comision.setEnabled(true);
			txtUser1Ganancia.setEnabled(true);
			txtUser1Producido.setEnabled(true);
		}
		if(btnUser2Name.getText().contains("User")) {
			btnUser2Name.setEnabled(false);
			txtUser2Comision.setEnabled(false);
			txtUser2Ganancia.setEnabled(false);
			txtUser2Producido.setEnabled(false);
		} else {
			btnUser2Name.setEnabled(true);
			txtUser2Comision.setEnabled(true);
			txtUser2Ganancia.setEnabled(true);
			txtUser2Producido.setEnabled(true);
		}
		if(btnUser3Name.getText().contains("User")) {
			btnUser3Name.setEnabled(false);
			txtUser3Comision.setEnabled(false);
			txtUser3Ganancia.setEnabled(false);
			txtUser3Producido.setEnabled(false);
		} else {
			btnUser3Name.setEnabled(true);
			txtUser3Comision.setEnabled(true);
			txtUser3Ganancia.setEnabled(true);
			txtUser3Producido.setEnabled(true);
		}
		if(btnUser4Name.getText().contains("User")) {
			btnUser4Name.setEnabled(false);
			txtUser4Comision.setEnabled(false);
			txtUser4Ganancia.setEnabled(false);
			txtUser4Producido.setEnabled(false);
		} else {
			btnUser4Name.setEnabled(true);
			txtUser4Comision.setEnabled(true);
			txtUser4Ganancia.setEnabled(true);
			txtUser4Producido.setEnabled(true);
		}
		
		txtTotalServicios.setText(Integer.parseInt(txtUser1Servicios.getText())
				+ Integer.parseInt(txtUser2Servicios.getText())
				+ Integer.parseInt(txtUser3Servicios.getText())
				+ Integer.parseInt(txtUser4Servicios.getText())
				+ ""); 
		int comision = Integer.parseInt(txtUser1Comision.getText().replace("$", ""))
				+ Integer.parseInt(txtUser2Comision.getText().replace("$", ""))
				+ Integer.parseInt(txtUser3Comision.getText().replace("$", ""))
				+ Integer.parseInt(txtUser4Comision.getText().replace("$", ""));
		txtTotalComision.setText("$" + comision);
		int producido = Integer.parseInt(txtUser1Producido.getText().replace("$", ""))
				+ Integer.parseInt(txtUser2Producido.getText().replace("$", ""))
				+ Integer.parseInt(txtUser3Producido.getText().replace("$", ""))
				+ Integer.parseInt(txtUser4Producido.getText().replace("$", ""));
		txtTotalProducido.setText("$" + producido);
		int ganancias = Integer.parseInt(txtUser1Ganancia.getText().replace("$", ""))
				+ Integer.parseInt(txtUser2Ganancia.getText().replace("$", ""))
				+ Integer.parseInt(txtUser3Ganancia.getText().replace("$", ""))
				+ Integer.parseInt(txtUser4Ganancia.getText().replace("$", ""));
		txtTotalGanancias.setText("$" + ganancias);
	}
	
	public void totalSemanal() {
		if(btnUserunosemanal.getText().contains("User")) {
			btnUserunosemanal.setEnabled(false);
			txtUserunosemanalcomision.setEnabled(false);
			txtUserunosemanalganancia.setEnabled(false);
			txtUserunosemanalproducido.setEnabled(false);
		} else {
			btnUserunosemanal.setEnabled(true);
			txtUserunosemanalcomision.setEnabled(true);
			txtUserunosemanalganancia.setEnabled(true);
			txtUserunosemanalproducido.setEnabled(true);
		}
		if(btnUserdossemanal.getText().contains("User")) {
			btnUserdossemanal.setEnabled(false);
			txtUserdossemanalcomision.setEnabled(false);
			txtUserdossemanalganancia.setEnabled(false);
			txtUserdossemanalproducido.setEnabled(false);
		} else {
			btnUserdossemanal.setEnabled(true);
			txtUserdossemanalcomision.setEnabled(true);
			txtUserdossemanalganancia.setEnabled(true);
			txtUserdossemanalproducido.setEnabled(true);
		}
		if(btnUsertressemanal.getText().contains("User")) {
			btnUsertressemanal.setEnabled(false);
			txtUsertressemanalcomision.setEnabled(false);
			txtUsertressemanalganancia.setEnabled(false);
			txtUsertressemanalproducido.setEnabled(false);
		} else {
			btnUsertressemanal.setEnabled(true);
			txtUsertressemanalcomision.setEnabled(true);
			txtUsertressemanalganancia.setEnabled(true);
			txtUsertressemanalproducido.setEnabled(true);
		}
		if(btnUsercuatrosemanal.getText().contains("User")) {
			btnUsercuatrosemanal.setEnabled(false);
			txtUsercuatrosemanalcomision.setEnabled(false);
			txtUsercuatrosemanalganancia.setEnabled(false);
			txtUsercuatrosemanalproducido.setEnabled(false);
		} else {
			btnUsercuatrosemanal.setEnabled(true);
			txtUsercuatrosemanalcomision.setEnabled(true);
			txtUsercuatrosemanalganancia.setEnabled(true);
			txtUsercuatrosemanalproducido.setEnabled(true);
		}
		
		btnTotalsemana.setEnabled(true);
		txtTotalsemanacomision.setEnabled(true);
		txtTotalsemanaganancia.setEnabled(true);
		txtTotalsemanalservicios.setEnabled(true);
		txtTotalsemanaproducido.setEnabled(true);
				
		txtTotalsemanalservicios.setText(Integer.parseInt(txtUserunosemanalservicios.getText())
				+ Integer.parseInt(txtUserdossemanalservicios.getText())
				+ Integer.parseInt(txtUsertressemanalservicios.getText())
				+ Integer.parseInt(txtUsercuatrosemanalservicios.getText())
				+ ""); 
		int comision = Integer.parseInt(txtUserunosemanalcomision.getText().replace("$", ""))
				+ Integer.parseInt(txtUserdossemanalcomision.getText().replace("$", ""))
				+ Integer.parseInt(txtUsertressemanalcomision.getText().replace("$", ""))
				+ Integer.parseInt(txtUsercuatrosemanalcomision.getText().replace("$", ""));
		txtTotalsemanacomision.setText("$" + comision);
		int producido = Integer.parseInt(txtUserunosemanalproducido.getText().replace("$", ""))
				+ Integer.parseInt(txtUserdossemanalproducido.getText().replace("$", ""))
				+ Integer.parseInt(txtUsertressemanalproducido.getText().replace("$", ""))
				+ Integer.parseInt(txtUsercuatrosemanalproducido.getText().replace("$", ""));
		txtTotalsemanaproducido.setText("$" + producido);
		int ganancias = Integer.parseInt(txtUserunosemanalganancia.getText().replace("$", ""))
				+ Integer.parseInt(txtUserdossemanalganancia.getText().replace("$", ""))
				+ Integer.parseInt(txtUsertressemanalganancia.getText().replace("$", ""))
				+ Integer.parseInt(txtUsercuatrosemanalganancia.getText().replace("$", ""));
		txtTotalsemanaganancia.setText("$" + ganancias);
		
	}
	
	public class DateLabelFormatter extends AbstractFormatter {

	    private String datePattern = "dd-MM-yyyy";
	    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

	    @Override
	    public Object stringToValue(String text) throws ParseException {
	        return dateFormatter.parseObject(text);
	    }

	    @Override
	    public String valueToString(Object value) throws ParseException {
	        if (value != null) {
	            Calendar cal = (Calendar) value;
	            return dateFormatter.format(cal.getTime());
	        }

	        return "";
	    }

	}
}
