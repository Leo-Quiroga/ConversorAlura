package CurrencyConverter;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class SwingConverterTemp extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTextField textCantidadAConvertir;
	private JTextField textTemperatura1;
	private JTextField textTemperatura2;
	
	public JTextField textFieldCantidadAConvertir;
	private JButton buttonOpciones;
	private JButton buttonCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingConverterTemp frame = new SwingConverterTemp();
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
	public SwingConverterTemp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
contentPane.setLayout(null);
		
		txtTitulo = new JTextField();
		txtTitulo.setForeground(new Color(0, 0, 0));
		txtTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		txtTitulo.setEditable(false);
		txtTitulo.setFont(new Font("SansSerif", Font.BOLD, 18));
		txtTitulo.setText("Conversor Temp");
		txtTitulo.setBackground(new Color(225, 225, 225));
		txtTitulo.setBounds(123, 11, 246, 30);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);
			
		JComboBox<Object> temperatura1 = new JComboBox<Object>();
		temperatura1.setFont(new Font("SansSerif", Font.PLAIN, 12));
		temperatura1.setModel(new DefaultComboBoxModel<Object>(new String[] {"°C - Centigrados", "°F - Fahrenheit", "°K - Kelvin", "°R - Reaumur", "R - Rankine"}));
		temperatura1.setBounds(287, 98, 162, 33);
		contentPane.add(temperatura1);
		
		JComboBox<Object> temperatura2 = new JComboBox<Object>();
		temperatura2.setFont(new Font("SansSerif", Font.PLAIN, 12));
		temperatura2.setModel(new DefaultComboBoxModel<Object>(new String[] {"°C - Centigrados", "°F - Fahrenheit", "°K - Kelvin", "°R - Reaumur", "R - Rankine"}));
		temperatura2.setBounds(33, 173, 162, 33);
		contentPane.add(temperatura2);
		
			
		JTextArea txtAResultado = new JTextArea();
		txtAResultado.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtAResultado.setBounds(33, 217, 416, 51);
		contentPane.add(txtAResultado);
		
		
		textCantidadAConvertir = new JTextField();
		textCantidadAConvertir.setText("Cantidad a convertir");
		textCantidadAConvertir.setHorizontalAlignment(SwingConstants.CENTER);
		textCantidadAConvertir.setFont(new Font("SansSerif", Font.BOLD, 14));
		textCantidadAConvertir.setEditable(false);
		textCantidadAConvertir.setColumns(10);
		textCantidadAConvertir.setBackground(new Color(225, 225, 225));
		textCantidadAConvertir.setBounds(33, 67, 162, 20);
		contentPane.add(textCantidadAConvertir);
		
		textTemperatura1 = new JTextField();
		textTemperatura1.setText("Temperatura inicial");
		textTemperatura1.setHorizontalAlignment(SwingConstants.CENTER);
		textTemperatura1.setFont(new Font("SansSerif", Font.BOLD, 14));
		textTemperatura1.setEditable(false);
		textTemperatura1.setColumns(10);
		textTemperatura1.setBackground(new Color(225, 225, 225));
		textTemperatura1.setBounds(287, 67, 162, 20);
		contentPane.add(textTemperatura1);
		
		textTemperatura2 = new JTextField();
		textTemperatura2.setText("Temperatura Final");
		textTemperatura2.setHorizontalAlignment(SwingConstants.CENTER);
		textTemperatura2.setFont(new Font("SansSerif", Font.BOLD, 14));
		textTemperatura2.setEditable(false);
		textTemperatura2.setColumns(10);
		textTemperatura2.setBackground(new Color(225, 225, 225));
		textTemperatura2.setBounds(33, 142, 162, 20);
		contentPane.add(textTemperatura2);
		
				
		JButton bottonConvertir = new JButton("Convertir");
		bottonConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				Float cantidadAConvertir = Float.parseFloat(textFieldCantidadAConvertir.getText());
		        int temperaturaInicial = temperatura1.getSelectedIndex();
		        int temperaturaFinal = temperatura2.getSelectedIndex();
		        String stringTempFinal = (String) temperatura2.getSelectedItem();
		        
		        float resultado = convertirTemperatura(cantidadAConvertir, temperaturaInicial, temperaturaFinal);
		        
		        txtAResultado.setText("El valor convertido es: " + resultado +" "+ stringTempFinal);}
				
		        float convertirTemperatura(float valor, int unidadInicial, int unidadFinal) {
				    // Definir constantes de conversión
				    //final float C_TO_F = 1.8f + 32.0f;
				    //final float C_TO_K = 273.15f;
				    //final float C_TO_R = 4.0f / 5.0f;
				    
				    float resultado = valor;
				    
				    if (unidadInicial == 0) { // °C
				        if (unidadFinal == 1) { // °F
				            resultado = valor * 1.8f + 32.0f;
				        } else if (unidadFinal == 2) { // °K
				            resultado = valor + 273.15f;
				        } else if (unidadFinal == 3) { // °R
				            resultado = valor * 4.0f / 5.0f;
				        } else if (unidadFinal == 4) { // °R
				            resultado = valor * 1.8f + 491.67f;}
				        
				    } else if (unidadInicial == 1) { // °F
				    	if (unidadFinal == 0) { // °C
				            resultado = (valor - 32.0f)* 5/9;
				        } else if (unidadFinal == 2) { // °K
				            resultado = (valor + 459.67f)*5/9;
				        } else if (unidadFinal == 3) { // °R
				            resultado = (valor - 32.0f)*4/9;
				        } else if (unidadFinal == 4) { // °R
				            resultado = valor + 459.67f;}
				    } else if (unidadInicial == 2) { // °K
				    	if (unidadFinal == 0) { // °C
				            resultado = valor - 273.15f;
				        } else if (unidadFinal == 1) { // °F
				            resultado = (valor * 9/5)-459.67f;
				        } else if (unidadFinal == 3) { // °R
				            resultado = (valor - 273.15f)*4/5;
				        } else if (unidadFinal == 4) { // °R
				            resultado = valor * 9/5;}
				    } else if (unidadInicial == 3) { // °R
				    	if (unidadFinal == 0) { // °C
				            resultado = valor * 5/4;
				        } else if (unidadFinal == 1) { // °F
				            resultado = (valor * 9/4)+32.0f;
				        } else if (unidadFinal == 2) { // °K
				            resultado = (valor*(5/4)) + 273.15f;
				        } else if (unidadFinal == 4) { // °R
				            resultado = valor * 9/4+491.67f;}
				    } else if (unidadInicial == 4) { // °R
				    	if (unidadFinal == 0) { // °C
				            resultado = (valor-491.67f)/1.8f;
				        } else if (unidadFinal == 1) { // °F
				            resultado = valor - 459.67f;
				        } else if (unidadFinal == 2) { // °K
				            resultado = valor / 1.8f;
				        } else if (unidadFinal == 3) { // °R
				            resultado = (valor -491.67f)/2.25f ;}
				    }
				    
				    
				    return resultado;
				}
				
		
		});
		
		
		
		
		
		bottonConvertir.setFont(new Font("SansSerif", Font.BOLD, 16));
		bottonConvertir.setBounds(287, 166, 162, 42);
		contentPane.add(bottonConvertir);
		
		textFieldCantidadAConvertir = new JTextField();
		textFieldCantidadAConvertir.setFont(new Font("SansSerif", Font.PLAIN, 14));
		textFieldCantidadAConvertir.setBounds(33, 100, 162, 31);
		contentPane.add(textFieldCantidadAConvertir);
		textFieldCantidadAConvertir.setColumns(10);
		
		buttonOpciones = new JButton("Opciones");
		buttonOpciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingConverterOpciones opcionesConverter = new SwingConverterOpciones(); // Crear una instancia de la clase SwingConverterOpciones
		        opcionesConverter.setVisible(true);
		        dispose(); // Cierra la ventana SwingConverterTemp
			}
		});
		buttonOpciones.setFont(new Font("SansSerif", Font.BOLD, 14));
		buttonOpciones.setBounds(33, 284, 162, 27);
		contentPane.add(buttonOpciones);
		
		buttonCerrar = new JButton("Cerrar");
		buttonCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); // Cierra la app
			}
		});
		buttonCerrar.setFont(new Font("SansSerif", Font.BOLD, 14));
		buttonCerrar.setBounds(287, 284, 162, 27);
		contentPane.add(buttonCerrar);
	}

}
