package CurrencyConverter;

import java.net.HttpURLConnection;

import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.json.JSONObject; 


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

public class SwingConverterCurrency extends JFrame {
	
	
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTextField textCantidadAConvertir;
	private JTextField textDivisa1;
	private JTextField textDivisa2;
	public JComboBox divisa1;
	public JComboBox divisa2;
	public JTextField textFieldCantidadAConvertir;
	private JButton buttonOpciones;
	private JButton buttonCerrrar;
	

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingConverterCurrency frame = new SwingConverterCurrency();
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
	public SwingConverterCurrency() {
		
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
		txtTitulo.setText("Conversor Divisas");
		txtTitulo.setBackground(new Color(225, 225, 225));
		txtTitulo.setBounds(123, 11, 246, 30);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);
			
		divisa1 = new JComboBox<Object>();
		divisa1.setFont(new Font("SansSerif", Font.PLAIN, 12));
		divisa1.setModel(new DefaultComboBoxModel(new String[] {"COP - PESO COL", "EUR - EURO", "USD - DOLLAR", "GBP - LIBRA EST", "CNY - YUAN", "JPY - YEN", "CAD - DOLLAR CAN", "AUD - DOLLAR AUS", "MXN - PESO MEX", "PEN - SOL PER", "BRL - REAL BRA"}));
		divisa1.setBounds(281, 100, 162, 33);
		contentPane.add(divisa1);
		
		divisa2 = new JComboBox<Object>();
		divisa2.setFont(new Font("SansSerif", Font.PLAIN, 12));
		divisa2.setModel(new DefaultComboBoxModel(new String[] {"COP - PESO COL", "EUR - EURO", "USD - DOLLAR", "GBP - LIBRA EST", "CNY - YUAN", "JPY - YEN", "CAD - DOLLAR CAN", "AUD - DOLLAR AUS", "MXN - PESO MEX", "PEN - SOL PER", "BRL - REAL BRA"}));
		divisa2.setBounds(33, 173, 162, 33);
		contentPane.add(divisa2);
		
		
			
		JTextArea txtAResultado = new JTextArea();
		txtAResultado.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtAResultado.setBounds(33, 217, 410, 51);
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
		
		textDivisa1 = new JTextField();
		textDivisa1.setText("Moneda a convertir");
		textDivisa1.setHorizontalAlignment(SwingConstants.CENTER);
		textDivisa1.setFont(new Font("SansSerif", Font.BOLD, 14));
		textDivisa1.setEditable(false);
		textDivisa1.setColumns(10);
		textDivisa1.setBackground(new Color(225, 225, 225));
		textDivisa1.setBounds(281, 69, 162, 20);
		contentPane.add(textDivisa1);
		
		textDivisa2 = new JTextField();
		textDivisa2.setText("Moneda Final");
		textDivisa2.setHorizontalAlignment(SwingConstants.CENTER);
		textDivisa2.setFont(new Font("SansSerif", Font.BOLD, 14));
		textDivisa2.setEditable(false);
		textDivisa2.setColumns(10);
		textDivisa2.setBackground(new Color(225, 225, 225));
		textDivisa2.setBounds(33, 142, 162, 20);
		contentPane.add(textDivisa2);
		
				
		JButton bottonConvertir = new JButton("Convertir");
		
		
		bottonConvertir.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {
				Float cantidadAConvertir = Float.parseFloat(textFieldCantidadAConvertir.getText());
		        int divisaInicialIndex = divisa1.getSelectedIndex();
		        int divisaFinalIndex = divisa2.getSelectedIndex();

		        String[] currencies = {"COP", "EUR", "USD", "GBP", "CNY", "JPY", "CAD", "AUD", "MXN", "PEN", "BRL"}; // Códigos de moneda según la API
		        
		        //String monedaBase = currencies[divisaInicialIndex];

		        String apiUrl = "http://api.exchangeratesapi.io/v1/latest?access_key=d77ea87a5a3306bc47bc0023b9e5dcbc&format=1";

		        
		        try {
		            URL url = new URL(apiUrl);
		            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		            connection.setRequestMethod("GET");

		            int responseCode = connection.getResponseCode();
		            if (responseCode == HttpURLConnection.HTTP_OK) {
		                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		                String inputLine;
		                StringBuilder response = new StringBuilder();

		                while ((inputLine = in.readLine()) != null) {
		                    response.append(inputLine);
		                }
		                in.close();

		                // Analizar la respuesta JSON para obtener la tasa de cambio
		                JSONObject jsonResponse = new JSONObject(response.toString());
		                

		                
		                
		                double divisaInicial = jsonResponse.getJSONObject("rates").getDouble(currencies[divisaInicialIndex]);
		                
		                double exchangeRate = jsonResponse.getJSONObject("rates").getDouble(currencies[divisaFinalIndex]);
		                
		                
		                
		                if (divisaInicialIndex == divisaFinalIndex) {
		                	
		                	txtAResultado.setText("El valor convertido es: " + cantidadAConvertir +" " + currencies[divisaFinalIndex] );
		                }else {
		                	
		                	if(divisaInicialIndex == 1) {
					             
		                		
			                	double convertedAmount = cantidadAConvertir * exchangeRate;
				                
				                // Mostrar en el JTextArea
				                txtAResultado.setText("El valor convertido es: " + convertedAmount +" " + currencies[divisaFinalIndex] );
			                }else {
			                	
			                	double baseConverter = divisaInicial/exchangeRate;
			                   	double convertedAmount = cantidadAConvertir /baseConverter; 
				                
				                // Mostrar en el JTextArea
				                txtAResultado.setText("El valor convertido es: " + convertedAmount +" " + currencies[divisaFinalIndex] );
			                	
			                }
		                	
		                }
		                
		                
		     
		                
		            } else {
		                txtAResultado.setText("Error en la solicitud a la API");
		                System.out.println(responseCode);
		            }
		        } catch (Exception ex) {
		            ex.printStackTrace();
		            txtAResultado.setText("Error en la solicitud a la API catch");
	        }

		        
				
				
			}

				
				
			
		
			
		});
		
		
		bottonConvertir.setFont(new Font("SansSerif", Font.BOLD, 16));
		bottonConvertir.setBounds(281, 166, 162, 42);
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
		        dispose(); // Cierra la ventana SwingConverterCurrency
			}
		});
		buttonOpciones.setFont(new Font("SansSerif", Font.BOLD, 14));
		buttonOpciones.setBounds(33, 282, 162, 31);
		contentPane.add(buttonOpciones);
		
		buttonCerrrar = new JButton("Cerrar");
		buttonCerrrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); // Cierra la app
			}
		});
		buttonCerrrar.setFont(new Font("SansSerif", Font.BOLD, 14));
		buttonCerrrar.setBounds(281, 282, 162, 31);
		contentPane.add(buttonCerrrar);
	}

}
