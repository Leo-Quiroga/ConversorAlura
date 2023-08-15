package CurrencyConverter;

import java.awt.Image;

import javax.swing.ImageIcon;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.TextField;

public class SwingConverterOpciones extends JFrame {

	
	
	
	public JPanel contentPane;
	public JTextField txtTitulo;
	public JButton buttonDivisas;
	public JButton buttonTemperatura;
	public JButton buttonLongitud;
	public JButton buttonArea;
	private JButton buttonCerrar;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingConverterOpciones frame = new SwingConverterOpciones();
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
	public SwingConverterOpciones() {
		
				
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 250);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(225, 225, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtTitulo = new JTextField();
		txtTitulo.setForeground(new Color(0, 0, 0));
		txtTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		txtTitulo.setEditable(false);
		txtTitulo.setFont(new Font("SansSerif", Font.BOLD, 18));
		txtTitulo.setText("Alura Conversor");
		txtTitulo.setBackground(new Color(225, 225, 225));
		txtTitulo.setBounds(123, 11, 246, 20);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);
		
				
		buttonDivisas = new JButton("Divisas");
		buttonDivisas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingConverterCurrency currencyConverter = new SwingConverterCurrency(); // Crear una instancia de la clase SwingConverterCurrency
		        		
				
				currencyConverter.setVisible(true);
		        dispose(); // Cierra la ventana SwingConverterOpciones
			}
		});
		buttonDivisas.setFont(new Font("Tahoma", Font.BOLD, 14));
		buttonDivisas.setBounds(33, 61, 162, 23);
		contentPane.add(buttonDivisas);
		
		buttonTemperatura = new JButton("Temperatura");
		buttonTemperatura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingConverterTemp tempConverter = new SwingConverterTemp(); // Crear una instancia de la clase SwingConverterTemp
		        tempConverter.setVisible(true);
		        dispose(); // Cierra la ventana SwingConverterOpciones
			}
		});
		buttonTemperatura.setFont(new Font("Tahoma", Font.BOLD, 14));
		buttonTemperatura.setBounds(281, 61, 162, 23);
		contentPane.add(buttonTemperatura);
		
		buttonLongitud = new JButton("Longitud");
		buttonLongitud.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingConverterLong longConverter = new SwingConverterLong(); // Crear una instancia de la clase SwingConverterLong
		        longConverter.setVisible(true);
		        dispose(); // Cierra la ventana SwingConverterOpciones
			}
		});
		buttonLongitud.setFont(new Font("Tahoma", Font.BOLD, 14));
		buttonLongitud.setBounds(33, 95, 162, 23);
		contentPane.add(buttonLongitud);
		
		buttonArea = new JButton("Area");
		buttonArea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingConverterArea areaConverter = new SwingConverterArea(); // Crear una instancia de la clase SwingConverterLong
		        areaConverter.setVisible(true);
		        dispose(); // Cierra la ventana SwingConverterOpciones
			}
		});
		buttonArea.setFont(new Font("Tahoma", Font.BOLD, 14));
		buttonArea.setBounds(281, 95, 162, 23);
		contentPane.add(buttonArea);
		
		buttonCerrar = new JButton("Cerrar");
		buttonCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); // Cierra la app
			}
		});
		buttonCerrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		buttonCerrar.setBounds(159, 151, 162, 23);
		contentPane.add(buttonCerrar);
		
	}
	
	
}
