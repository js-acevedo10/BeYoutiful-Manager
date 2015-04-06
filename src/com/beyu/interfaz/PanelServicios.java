package com.beyu.interfaz;

import javax.swing.JPanel;

import com.beyu.mundo.CreadorRecibos;
import com.beyu.mundo.Usuario;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;

import java.awt.Font;
import java.awt.Dimension;

import javax.swing.JOptionPane;
import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelServicios extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public InterfazPrincipal principal;
	private Usuario usuarioActual;
	public CreadorRecibos recibo;
	private JButton btnServicio;
	private JButton btnServicio_1;
	private JButton btnServicio_2;
	private JButton btnServicio_3;
	private JButton btnServicio_4;
	private JButton btnServicio_5;
	private JButton btnServicio_6;
	private JButton btnServicio_7;
	private JButton btnServicio_8;
	private JButton btnContador;
	int descuento;
//	private JButton btnDescuento;
	
	/**
	 * Create the panel.
	 */
	public PanelServicios(InterfazPrincipal ventana, final Usuario usuarioActual) {
		principal = ventana;
		this.usuarioActual = usuarioActual;
		setLayout(new BorderLayout(0, 0));
		descuento = 0;
		
		JPanel panelBotonesServicios = new JPanel();
		panelBotonesServicios.setPreferredSize(new Dimension(550, 10));
		panelBotonesServicios.setMinimumSize(new Dimension(200, 10));
		panelBotonesServicios.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		add(panelBotonesServicios, BorderLayout.EAST);
		panelBotonesServicios.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblInstruccion = new JLabel("¡Hola " + usuarioActual.darNombre() + "! selecciona uno a uno los servicios a incluir.");
		lblInstruccion.setPreferredSize(new Dimension(297, 100));
		lblInstruccion.setHorizontalAlignment(SwingConstants.CENTER);
		lblInstruccion.setFont(new Font("Helvetica Neue", Font.PLAIN, 25));
		add(lblInstruccion, BorderLayout.NORTH);
		
		JButton btnManicure = new JButton("Manicure");
		btnManicure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] opciones = {"<html><span style='font-size:10px'>Mujer",
						"<html><span style='font-size:10px'>Cambio de Esmalte",
						"<html><span style='font-size:10px'>Hombre",
						"<html><span style='font-size:10px'>GEL",
						"<html><span style='font-size:10px'>TIPS"};
				int resp = JOptionPane.showOptionDialog(null,
						"<html><span style='font-size:20px'>Especifica el tipo de Manicure",
						"Manicure",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						null,
						opciones,
						opciones[0]);
				switch (resp) {
				case 0:
					recibo.agregarServicio("Manicure Mujer", 13000);
					break;
				case 1:
					recibo.agregarServicio("Cambio Esmalte", 7000);
					break;
				case 2:
					recibo.agregarServicio("Manicure Hombre", 12000);
					break;
				case 3:
					recibo.agregarServicio("Manicure Gel", 35000);
					break;
				case 4:
					recibo.agregarServicio("Manicure Tips", 40000);
					break;
				default:
					break;
				}
			}
		});
		btnManicure.setFont(new Font("Helvetica Neue", Font.PLAIN, 22));
		panelBotonesServicios.add(btnManicure);
		
		JButton btnPedicure = new JButton("Pedicure");
		btnPedicure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				recibo.agregarServicio("Pedicure", 16000);
			}
		});
		btnPedicure.setFont(new Font("Helvetica Neue", Font.PLAIN, 22));
		panelBotonesServicios.add(btnPedicure);
		
		JButton btnDecoracion = new JButton("Decoracion");
		btnDecoracion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				String respuesta = JOptionPane.showInputDialog("<html><span style='font-size:20px'>Ingrese el costo de la Decoracion");
				try {
					double costo = Double.parseDouble(respuesta);
					if(costo <= 1000 && costo >= 0) {
						String calidad = JOptionPane.showInputDialog("<html><span style='font-size:20px'>¿Cuantas unas con este precio?");
						int cantidad = Integer.parseInt(calidad);
						if(cantidad > 0 && cantidad < 20) {
							double costoFinal = cantidad * costo;
							recibo.agregarServicio("Decoracion", costoFinal);
						}
						
					}
					else
						JOptionPane.showMessageDialog(null, "<html><span style='font-size:20px'>Debes ingresar un valor correcto.");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "<html><span style='font-size:20px'>Debes ingresar un valor correcto.");
				}
			}
		});
		btnDecoracion.setFont(new Font("Helvetica Neue", Font.PLAIN, 22));
		panelBotonesServicios.add(btnDecoracion);
		
		JButton btnCorte = new JButton("Corte");
		btnCorte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				String[] opciones = {"<html><span style='font-size:10px'>Mujer",
						"<html><span style='font-size:10px'>Hombre",
						"<html><span style='font-size:10px'>Arreglo o Barba"};
				int resp = JOptionPane.showOptionDialog(null,
						"<html><span style='font-size:20px'>Especifica el tipo de Corte",
						"Corte",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						null,
						opciones,
						opciones[0]);
				switch (resp) {
				case 0:
					recibo.agregarServicio("Corte Mujer", 15000);
					break;
				case 1:
					recibo.agregarServicio("Corte Hombre", 11000);
					break;
				case 2:
					recibo.agregarServicio("Arreglo", 8000);
					break;
				default:
					break;
				}
			}
		});
		btnCorte.setFont(new Font("Helvetica Neue", Font.PLAIN, 22));
		panelBotonesServicios.add(btnCorte);
		
		JButton btnCepillado = new JButton("Cepillado");
		btnCepillado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				String respuesta = JOptionPane.showInputDialog("<html><span style='font-size:20px'>Ingrese el costo del Cepillado");
				try {
					double costo = Double.parseDouble(respuesta);
					if(costo >= 7000)
						recibo.agregarServicio("Cepillado", costo);
					else
						JOptionPane.showMessageDialog(null, "<html><span style='font-size:20px'>Debes ingresar un valor correcto.");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "<html><span style='font-size:20px'>Debes ingresar un valor correcto.");
				}
			}
		});
		btnCepillado.setFont(new Font("Helvetica Neue", Font.PLAIN, 22));
		panelBotonesServicios.add(btnCepillado);
		
		JButton btnCera = new JButton("Cera");
		btnCera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				String[] opciones = {"<html><span style='font-size:10px'>Bigote",
						"<html><span style='font-size:10px'>Cejas",
						"<html><span style='font-size:10px'>Axilas",
						"<html><span style='font-size:10px'>Media Pierna",
						"<html><span style='font-size:10px'>Pierna Completa",
						"<html><span style='font-size:10px'>Medio Bikini",
						"<html><span style='font-size:10px'>Bikini Completo",
						"<html><span style='font-size:10px'>Completa"};
				int resp = JOptionPane.showOptionDialog(null,
						"<html><span style='font-size:20px'>Especifica el tipo de Cera",
						"Cera",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						null,
						opciones,
						opciones[0]);
				switch (resp) {
				case 0:
					recibo.agregarServicio("Cera Bigote", 6000);
					break;
				case 1:
					recibo.agregarServicio("Cera Cejas", 6000);
					break;
				case 2:
					recibo.agregarServicio("Cera Axilas", 8000);
					break;
				case 3:
					recibo.agregarServicio("Cera Media Pierna", 10000);
					break;
				case 4:
					recibo.agregarServicio("Cera Pierna Completa", 14000);
					break;
				case 5:
					recibo.agregarServicio("Cera Medio Bikini", 10000);
					break;
				case 6:
					recibo.agregarServicio("Cera Bikini Completo", 20000);
					break;
				case 7:
					recibo.agregarServicio("Cera Completa", 40000);
					break;
				default:
					break;
				}
			}
		});
		btnCera.setFont(new Font("Helvetica Neue", Font.PLAIN, 22));
		panelBotonesServicios.add(btnCera);
		
		JButton btnTinte = new JButton("Tinte");
		btnTinte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				String respuesta = JOptionPane.showInputDialog("<html><span style='font-size:20px'>Ingrese el costo del Tinte");
				try {
					double costo = Double.parseDouble(respuesta);
					if(costo >= 10000)
						recibo.agregarServicio("Tinte", costo);
					else
						JOptionPane.showMessageDialog(null, "<html><span style='font-size:20px'>Debes ingresar un valor correcto.");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "<html><span style='font-size:20px'>Debes ingresar un valor correcto.");
				}
			}
		});
		btnTinte.setFont(new Font("Helvetica Neue", Font.PLAIN, 22));
		panelBotonesServicios.add(btnTinte);
		
		JButton btnPestanas = new JButton("Maquillaje y Pestanas");
		btnPestanas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				String[] opciones = {"<html><span style='font-size:10px'>Pestanas Punto a Punto",
						"<html><span style='font-size:10px'>Pestanas en Tira",
						"<html><span style='font-size:10px'>Maquillaje"};
				int resp = JOptionPane.showOptionDialog(null,
						"<html><span style='font-size:20px'>Especifica el tipo de Servicio",
						"Cara",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						null,
						opciones,
						opciones[0]);
				switch (resp) {
				case 0:
					recibo.agregarServicio("Pestanas Punto a punto", 15000);
					break;
				case 1:
					recibo.agregarServicio("Pestanas Tira", 8000);
					break;
				case 2:
					recibo.agregarServicio("Maquillaje", 0);
					break;
				default:
					break;
				}
			}
		});
		btnPestanas.setFont(new Font("Helvetica Neue", Font.PLAIN, 22));
		panelBotonesServicios.add(btnPestanas);
		
		JButton btnMaquillaje = new JButton("Tratamientos");
		btnMaquillaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				String[] opciones = {"<html><span style='font-size:10px'>Velaterapia",
						"<html><span style='font-size:10px'>Keratina",
						"<html><span style='font-size:10px'>Shampoo"};
				int resp = JOptionPane.showOptionDialog(null,
						"<html><span style='font-size:20px'>Especifica el tipo de Tratamiento",
						"Tratamiento",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						null,
						opciones,
						opciones[0]);
				switch (resp) {
				case 0:
					recibo.agregarServicio("Velaterapia", 80000);
					break;
				case 1:
					recibo.agregarServicio("Keratina", 0);
					break;
				case 2:
					recibo.agregarServicio("Shampoo", 5000);
					break;
				default:
					break;
				}
			}
		});
		btnMaquillaje.setFont(new Font("Helvetica Neue", Font.PLAIN, 22));
		panelBotonesServicios.add(btnMaquillaje);
		
		JButton btnOtros = new JButton("Otros");
		btnOtros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] opciones = {"<html><span style='font-size:10px'>Combo",
						"<html><span style='font-size:10px'>Otro"};
				int resp = JOptionPane.showOptionDialog(null,
						"<html><span style='font-size:20px'>¿Que deseas registrar?",
						"Otros",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						null,
						opciones,
						opciones[0]);
				if(resp == 0) {
					String[] ops = {"<html><span style='font-size:10px'>Combo Corte y Cepillado",
							"<html><span style='font-size:10px'>Combo Manos y Pies",
							"<html><span style='font-size:10px'>Combo Solo Manos",
							"<html><span style='font-size:10px'>Combo Solo Pies"};
					int r = JOptionPane.showOptionDialog(null,
						"<html><span style='font-size:20px'>Especifica el tipo de combo",
						"Combo",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						null,
						ops,
						ops[0]);
					switch (r) {
					case 0:
						recibo.agregarServicio("Corte y Cepillado", 28000);
						break;
					case 1:
						recibo.agregarServicio("Combo Manos y Pies", 26000);
						break;
					case 2:
						recibo.agregarServicio("Combo Solo Manos", 10400);
						break;
					case 3:
						recibo.agregarServicio("Combo Solo Pies", 15600);
						break;
					default:
						break;
					}
				}
				else if (resp == 1) {
					try{
						String nom = JOptionPane.showInputDialog("<html><span style='font-size:20px'>Ingresa el nombre");
						int valor = Integer.parseInt(JOptionPane.showInputDialog("<html><span style='font-size:20px'>Ingresa el valor"));
						if(valor > 0) {
							recibo.agregarServicio(nom, valor);
						} else {
							JOptionPane.showMessageDialog(null, "<html><span style='font-size:20px'>Debes ingresar un valor correcto.");
						}
					} catch(Exception x){
						JOptionPane.showMessageDialog(null, "<html><span style='font-size:20px'>Debes ingresar un valor correcto.");
					}
				}
			}
		});
		btnOtros.setFont(new Font("Helvetica Neue", Font.PLAIN, 22));
		panelBotonesServicios.add(btnOtros);
		
		JPanel panelCreadorRecibo = new JPanel();
		add(panelCreadorRecibo, BorderLayout.CENTER);
		panelCreadorRecibo.setLayout(new BorderLayout(0, 0));
		
		JPanel panelBotones = new JPanel();
		panelCreadorRecibo.add(panelBotones);
		panelBotones.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnServicio = new JButton("");
		btnServicio.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
		btnServicio.setOpaque(true);
		btnServicio.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		btnServicio.setBackground(Color.WHITE);
		panelBotones.add(btnServicio);
		
		btnServicio_1 = new JButton("");
		btnServicio_1.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
		btnServicio_1.setOpaque(true);
		btnServicio_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		btnServicio_1.setBackground(Color.WHITE);
		panelBotones.add(btnServicio_1);
		
		btnServicio_2 = new JButton("");
		btnServicio_2.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
		btnServicio_2.setOpaque(true);
		btnServicio_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		btnServicio_2.setBackground(Color.WHITE);
		panelBotones.add(btnServicio_2);
		
		btnServicio_3 = new JButton("");
		btnServicio_3.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
		btnServicio_3.setOpaque(true);
		btnServicio_3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		btnServicio_3.setBackground(Color.WHITE);
		panelBotones.add(btnServicio_3);
		
		btnServicio_4 = new JButton("");
		btnServicio_4.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
		btnServicio_4.setOpaque(true);
		btnServicio_4.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		btnServicio_4.setBackground(Color.WHITE);
		panelBotones.add(btnServicio_4);
		
		btnServicio_5 = new JButton("");
		btnServicio_5.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
		btnServicio_5.setOpaque(true);
		btnServicio_5.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		btnServicio_5.setBackground(Color.WHITE);
		panelBotones.add(btnServicio_5);
		
		btnServicio_6 = new JButton("");
		btnServicio_6.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
		btnServicio_6.setOpaque(true);
		btnServicio_6.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		btnServicio_6.setBackground(Color.WHITE);
		panelBotones.add(btnServicio_6);
		
		btnServicio_7 = new JButton("");
		btnServicio_7.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
		btnServicio_7.setOpaque(true);
		btnServicio_7.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		btnServicio_7.setBackground(Color.WHITE);
		panelBotones.add(btnServicio_7);
		
		btnServicio_8 = new JButton("");
		btnServicio_8.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
		btnServicio_8.setOpaque(true);
		btnServicio_8.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		btnServicio_8.setBackground(Color.WHITE);
		panelBotones.add(btnServicio_8);
		
//		JButton buttonSeparador = new JButton("-----------------------------------------------------------------------");
//		buttonSeparador.setOpaque(true);
//		buttonSeparador.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
//		buttonSeparador.setBackground(Color.WHITE);
//		panelBotones.add(buttonSeparador);
		
//		btnDescuento = new JButton("Descuento:                                                     $0");
//		btnDescuento.setOpaque(true);
//		btnDescuento.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
//		btnDescuento.setBackground(Color.WHITE);
//		panelBotones.add(btnDescuento);
		
		JButton buttonSeparador1 = new JButton("-----------------------------------------------------------------------");
		buttonSeparador1.setOpaque(true);
		buttonSeparador1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		buttonSeparador1.setBackground(Color.WHITE);
		panelBotones.add(buttonSeparador1);
		
		btnContador = new JButton("Total                                                     $0.0");
		btnContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
		panelBotones.add(btnContador);
		btnContador.setOpaque(true);
		btnContador.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		btnContador.setBackground(Color.WHITE);
		
		JPanel panelOpciones = new JPanel();
		panelOpciones.setPreferredSize(new Dimension(0, 100));
		panelCreadorRecibo.add(panelOpciones, BorderLayout.SOUTH);
		panelOpciones.setLayout(new GridLayout(1, 3, 0, 0));
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				principal.restart();
			}
		});
		panelOpciones.add(btnCancelar);
		
		JButton btnBorrarTodo = new JButton("Borrar Todo");
		btnBorrarTodo.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
		btnBorrarTodo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int r = JOptionPane.showOptionDialog(null, "<html><span style='font-size:20px'>¿Seguro que deseas borrar todo?", "Atencion", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
				if(r == JOptionPane.YES_OPTION) {
					recibo = null;
					recibo = new CreadorRecibos(PanelServicios.this);
					recibo.asignarUsuario(usuarioActual);
					btnServicio.setText("");
					btnServicio_1.setText("");
					btnServicio_2.setText("");
					btnServicio_3.setText("");
					btnServicio_4.setText("");
					btnServicio_5.setText("");
					btnServicio_6.setText("");
					btnServicio_7.setText("");
					btnServicio_8.setText("");
//					btnDescuento.setText("Descuento:                                                     $");
					btnContador.setText("Total                                                     $" + recibo.darTotal());
					descuento = 0;
				}
			}
		});
		panelOpciones.add(btnBorrarTodo);
		
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
		btnContinuar.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				PanelConfirmacion nextPanel = new PanelConfirmacion(principal, recibo);
				principal.changePanel(nextPanel);
			}
		});
		panelOpciones.add(btnContinuar);
		
		recibo = new CreadorRecibos(this);
		recibo.asignarUsuario(usuarioActual);
	}
	
	protected void actualizarTotal() {
		recibo.sumaVenta = recibo.sumaVenta-descuento;
		btnContador.setText("Total                                                     $" + recibo.darTotal());
	}

	//Recibo
	public void agregarServicioFactura(String label, int button) {
		String total = "Total                                                     $" + recibo.darTotal();
		switch (button) {
		case 0:
			btnServicio.setText(label);
			btnContador.setText(total);
			break;
		case 1:
			btnServicio_1.setText(label);
			btnContador.setText(total);
			break;
		case 2:
			btnServicio_2.setText(label);
			btnContador.setText(total);
			break;
		case 3:
			btnServicio_3.setText(label);
			btnContador.setText(total);
			break;
		case 4:
			btnServicio_4.setText(label);
			btnContador.setText(total);
			break;
		case 5:
			btnServicio_5.setText(label);
			btnContador.setText(total);
			break;
		case 6:
			btnServicio_6.setText(label);
			btnContador.setText(total);
			break;
		case 7:
			btnServicio_7.setText(label);
			btnContador.setText(total);
			break;
		case 8:
			btnServicio_8.setText(label);
			btnContador.setText(total);
			break;
		default:
			break;
		}
	}

//	public void agregarDescuentoPorCombo(String nuevo) {
//		int nuevoDesc =  Integer.parseInt(nuevo);
//		descuento += nuevoDesc;
//		btnDescuento.setText("Descuento:                                                     $" + descuento);
//	}
}



