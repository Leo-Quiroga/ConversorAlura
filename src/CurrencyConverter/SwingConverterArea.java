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

public class SwingConverterArea extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTextField textCantidadAConvertir;
	private JTextField textArea1;
	private JTextField textArea2;
	private JComboBox divisa1;
	private JComboBox divisa2;
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
	public SwingConverterArea() {
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
		txtTitulo.setText("Conversor Area");
		txtTitulo.setBackground(new Color(225, 225, 225));
		txtTitulo.setBounds(123, 11, 246, 31);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);
			
		JComboBox<Object> area1 = new JComboBox<Object>();
		area1.setFont(new Font("SansSerif", Font.PLAIN, 12));
		area1.setModel(new DefaultComboBoxModel(new String[] {"Km2 - Kms Cuadrados", "m2 - Metros Cuadrados", "yd2 - Yardas Cuadradas", "mi2 - Millas Cuadradas", "ha2 - Hectareas Cuadradas", "ac2 - Acres Cuadrados"}));
		area1.setBounds(287, 98, 162, 33);
		contentPane.add(area1);
		
		JComboBox<Object> area2 = new JComboBox<Object>();
		area2.setFont(new Font("SansSerif", Font.PLAIN, 12));
		area2.setModel(new DefaultComboBoxModel(new String[] {"Km2 - Kms Cuadrados", "m2 - Metros Cuadrados", "yd2 - Yardas Cuadradas", "mi2 - Millas Cuadradas", "ha2 - Hectareas Cuadradas", "ac2 - Acres Cuadrados"}));
		area2.setBounds(33, 173, 162, 33);
		contentPane.add(area2);
		
			
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
		
		textArea1 = new JTextField();
		textArea1.setText("Area inicial");
		textArea1.setHorizontalAlignment(SwingConstants.CENTER);
		textArea1.setFont(new Font("SansSerif", Font.BOLD, 14));
		textArea1.setEditable(false);
		textArea1.setColumns(10);
		textArea1.setBackground(new Color(225, 225, 225));
		textArea1.setBounds(287, 67, 162, 20);
		contentPane.add(textArea1);
		
		textArea2 = new JTextField();
		textArea2.setText("Area Final");
		textArea2.setHorizontalAlignment(SwingConstants.CENTER);
		textArea2.setFont(new Font("SansSerif", Font.BOLD, 14));
		textArea2.setEditable(false);
		textArea2.setColumns(10);
		textArea2.setBackground(new Color(225, 225, 225));
		textArea2.setBounds(33, 142, 162, 20);
		contentPane.add(textArea2);
		
				
		JButton bottonConvertir = new JButton("Convertir");
		bottonConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				Float cantidadAConvertir = Float.parseFloat(textFieldCantidadAConvertir.getText());
		        int areaInicial = area1.getSelectedIndex();
		        int areaFinal = area2.getSelectedIndex();
		        String stringAreaFinal = (String) area2.getSelectedItem();
		        
		        float resultado = convertirArea(cantidadAConvertir, areaInicial, areaFinal);
		        
		        txtAResultado.setText("El valor convertido es: " + Math. round(resultado* 10000.0) / 10000.0 + " " + stringAreaFinal);}
				
		        float convertirArea(float valor, int unidadInicial, int unidadFinal) {
				    // Definir constantes de conversión
				    //final float C_TO_F = 1.8f + 32.0f;
				    //final float C_TO_K = 273.15f;
				    //final float C_TO_R = 4.0f / 5.0f;
				    
				    float resultado = valor;
				    
				    if (unidadInicial == 0) { // Km2
				        if (unidadFinal == 1) { // m2
				            resultado = valor * 1000000.0f;
				        } else if (unidadFinal == 2) { // yd2
				            resultado = valor + 1196000.0f;
				        } else if (unidadFinal == 3) { // mi2
				            resultado = valor * 0.386102f;
				        } else if (unidadFinal == 4) { // ha2
				            resultado = valor * 100.0f;
				        }else if (unidadFinal == 5) { // ac2
				            resultado = valor * 247.105f;}
				     
				        
				    } else if (unidadInicial == 1) { // m2
				        if (unidadFinal == 0) { // Km2
				            resultado = valor * 0.000001f;
				        } else if (unidadFinal == 2) { // yd2
				            resultado = valor * 1.19599f;
				        } else if (unidadFinal == 3) { // mi2
				            resultado = valor * 0.0000003861f;
				        } else if (unidadFinal == 4) { // ha2
				            resultado = valor * 0.0001f;
				        }else if (unidadFinal == 5) { // ac2
				            resultado = valor * 0.000247105f;}
				    } else if (unidadInicial == 2) { // yd2
				        if (unidadFinal == 0) { // Km2
				            resultado = valor * 0.00000083613f;
				        } else if (unidadFinal == 1) { // m2
				            resultado = valor * 0.836127f;
				        } else if (unidadFinal == 3) { // mi2
				            resultado = valor * 0.00000032283f;
				        } else if (unidadFinal == 4) { // ha2
				            resultado = valor * 0.0000836127f;
				        }else if (unidadFinal == 4) { // ac2
				            resultado = valor * 0.0002066127f;}
				    } else if (unidadInicial == 3) { // mi2
				        if (unidadFinal == 0) { // Km2
				            resultado = valor * 2.58999f;
				        } else if (unidadFinal == 1) { // m2
				            resultado = valor * 2590000.0f;
				        } else if (unidadFinal == 2) { // yd2
				            resultado = valor * 3097600.0f;
				        } else if (unidadFinal == 4) { // ha2
				            resultado = valor * 258.999f;
				        }else if (unidadFinal == 5) { // ac2
				            resultado = valor * 640.0f;}
				    } else if (unidadInicial == 4) { // ha2
				        if (unidadFinal == 0) { // km2
				            resultado = valor * 0.01f;
				        } else if (unidadFinal == 1) { // m2
				            resultado = valor * 10000.0f;
				        } else if (unidadFinal == 2) { // yd2
				            resultado = valor * 11959.9f;
				        } else if (unidadFinal == 3) { // mi2
				            resultado = valor * 0.00386102f;
				        }else if (unidadFinal == 5) { // ac2
				            resultado = valor * 2.47105f;}
				    } else if (unidadInicial == 5) { // ac2
				        if (unidadFinal == 0) { // Km2
				            resultado = valor * 0.00404686f;
				        } else if (unidadFinal == 1) { // m2
				            resultado = valor * 4046.86f;
				        } else if (unidadFinal == 2) { // yd2
				            resultado = valor * 4840.0f;
				        } else if (unidadFinal == 3) { // mi2
				            resultado = valor * 0.0015625f;
				        }else if (unidadFinal == 4) { // ha2
				            resultado = valor * 0.404686f;}
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
