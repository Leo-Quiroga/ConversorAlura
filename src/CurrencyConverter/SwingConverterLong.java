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

public class SwingConverterLong extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTextField textCantidadAConvertir;
	private JTextField textLongitud1;
	private JTextField textLongitud2;
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
					SwingConverterLong frame = new SwingConverterLong();
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
	public SwingConverterLong() {
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
		txtTitulo.setText("Conversor Long");
		txtTitulo.setBackground(new Color(225, 225, 225));
		txtTitulo.setBounds(123, 11, 246, 31);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);
			
		JComboBox<Object> longitud1 = new JComboBox<Object>();
		longitud1.setFont(new Font("SansSerif", Font.PLAIN, 12));
		longitud1.setModel(new DefaultComboBoxModel(new String[] {"cm - Centimetros", "m - Metros", "Km - Kilometros", "in - Pulgada", "yd - Yarda", "mi - Milla"}));
		longitud1.setBounds(287, 98, 162, 33);
		contentPane.add(longitud1);
		
		JComboBox<Object> longitud2 = new JComboBox<Object>();
		longitud2.setFont(new Font("SansSerif", Font.PLAIN, 12));
		longitud2.setModel(new DefaultComboBoxModel(new String[] {"cm - Centimetros", "m - Metros", "Km - Kilometros", "in - Pulgada", "yd - Yarda", "mi - Milla"}));
		longitud2.setBounds(33, 173, 162, 33);
		contentPane.add(longitud2);
		
			
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
		
		textLongitud1 = new JTextField();
		textLongitud1.setText("Longitud inicial");
		textLongitud1.setHorizontalAlignment(SwingConstants.CENTER);
		textLongitud1.setFont(new Font("SansSerif", Font.BOLD, 14));
		textLongitud1.setEditable(false);
		textLongitud1.setColumns(10);
		textLongitud1.setBackground(new Color(225, 225, 225));
		textLongitud1.setBounds(287, 67, 162, 20);
		contentPane.add(textLongitud1);
		
		textLongitud2 = new JTextField();
		textLongitud2.setText("Longitud Final");
		textLongitud2.setHorizontalAlignment(SwingConstants.CENTER);
		textLongitud2.setFont(new Font("SansSerif", Font.BOLD, 14));
		textLongitud2.setEditable(false);
		textLongitud2.setColumns(10);
		textLongitud2.setBackground(new Color(225, 225, 225));
		textLongitud2.setBounds(33, 142, 162, 20);
		contentPane.add(textLongitud2);
		
				
		JButton bottonConvertir = new JButton("Convertir");
		bottonConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				Float cantidadAConvertir = Float.parseFloat(textFieldCantidadAConvertir.getText());
		        int temperaturaInicial = longitud1.getSelectedIndex();
		        int temperaturaFinal = longitud2.getSelectedIndex();
		        String stringLongFinal = (String) longitud2.getSelectedItem();
		        
		        double resultado = convertirTemperatura(cantidadAConvertir, temperaturaInicial, temperaturaFinal);
		        
		        txtAResultado.setText("El valor convertido es: " + Math. round(resultado* 10000.0) / 10000.0+" "+ stringLongFinal);}
				
		        double convertirTemperatura(double valor, int unidadInicial, int unidadFinal) {
				    
				    
				    double resultado = valor;
				    
				    if (unidadInicial == 0) { // cm
				        if (unidadFinal == 1) { // m
				            resultado = valor * 0.01f;
				        } else if (unidadFinal == 2) { // Km
				            resultado = valor * 0.00001f;
				        } else if (unidadFinal == 3) { // in
				            resultado = valor * 0.393701f;
				        } else if (unidadFinal == 4) { // yd
				            resultado = valor * 0.010936f;
				        } else if (unidadFinal == 5) { // mi
				            resultado = valor * 0.00000621371f;}
				        
				    } else  if (unidadInicial == 1) { // m
				        if (unidadFinal == 0) { // cm
				            resultado = valor * 100.0f;
				        } else if (unidadFinal == 2) { // Km
				            resultado = valor * 0.001f;
				        } else if (unidadFinal == 3) { // in
				            resultado = valor * 39.3701f;
				        } else if (unidadFinal == 4) { // yd
				            resultado = valor * 1.09361f;
				        } else if (unidadFinal == 5) { // mi
				            resultado = valor * 0.000621371f;}
				    }else  if (unidadInicial == 2) { // Km
				        if (unidadFinal == 0) { // cm
				            resultado = valor * 100000.0f;
				        } else if (unidadFinal == 1) { // m
				            resultado = valor * 1000.0f;
				        } else if (unidadFinal == 3) { // in
				            resultado = valor * 39370.1f;
				        } else if (unidadFinal == 4) { // yd
				            resultado = valor * 1093.61f;
				        } else if (unidadFinal == 5) { // mi
				            resultado = valor * 0.621371f;}
				    }else  if (unidadInicial == 3) { // in
				        if (unidadFinal == 0) { // cm
				            resultado = valor * 2.54f;
				        } else if (unidadFinal == 1) { // m
				            resultado = valor * 0.0254f;
				        } else if (unidadFinal == 2) { // km
				            resultado = valor * 0.0000254f;
				        } else if (unidadFinal == 4) { // yd
				            resultado = valor * 0.0277778f;
				        } else if (unidadFinal == 5) { // mi
				            resultado = valor * 0.0000157828f;}
				    }else  if (unidadInicial == 4) { // yd
				        if (unidadFinal == 0) { // cm
				            resultado = valor * 91.44f;
				        } else if (unidadFinal == 1) { // m
				            resultado = valor * 0.9144f;
				        } else if (unidadFinal == 2) { // km
				            resultado = valor * 0.0009144f;
				        } else if (unidadFinal == 3) { // in
				            resultado = valor * 36.0f;
				        } else if (unidadFinal == 5) { // mi
				            resultado = valor * 0.000568182f;}
				    }else  if (unidadInicial == 5) { // mi
				        if (unidadFinal == 0) { // cm
				            resultado = valor * 160934.4f;
				        } else if (unidadFinal == 1) { // m
				            resultado = valor * 1609.34f;
				        } else if (unidadFinal == 2) { // km
				            resultado = valor * 1.60934f;
				        } else if (unidadFinal == 3) { // in
				            resultado = valor * 63360.0f;
				        } else if (unidadFinal == 4) { // yd
				            resultado = valor * 1760.0f;}
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

