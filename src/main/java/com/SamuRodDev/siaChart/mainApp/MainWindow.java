package com.SamuRodDev.siaChart.mainApp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.net.http.HttpClient;

import javax.swing.border.TitledBorder;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.http.HttpResponse;


import com.SamuRodDev.siaChart.analysis.fundamentals.FundamentalsAnalysisApp;
import com.SamuRodDev.siaChart.analysis.technical.TechnicalAnalysisApp;

import javax.swing.JTabbedPane;
import java.awt.Font;
import javax.swing.JButton;

public class MainWindow {

	JFrame frmMainApp;
	private JPanel pnlTop;
	private JTextField txtTicker;
	private JTabbedPane tbdpnlContent;
	private JButton btnTicker;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmMainApp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMainApp = new JFrame();
		frmMainApp.setTitle("SIA Chart");
		frmMainApp.setBounds(100, 100, 450, 300);
		frmMainApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMainApp.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		TechnicalAnalysisApp technical = new TechnicalAnalysisApp();
		
		pnlTop = new JPanel();
		frmMainApp.getContentPane().add(pnlTop, BorderLayout.NORTH);
		
		JPanel pnlTicker = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnlTicker.getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(20);
		pnlTicker.setBorder(new TitledBorder(null, "Ticker de la acci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlTop.add(pnlTicker);
		
		txtTicker = 	new JTextField();
		pnlTicker.add(txtTicker);
		txtTicker.setColumns(10);
		
		btnTicker = new JButton("Seleccionar");
		pnlTicker.add(btnTicker);
		
		btnTicker.addActionListener(e -> {
            String ticker = txtTicker.getText();
            
            try {
                double precio = buscarPrecio(ticker);
                
                // Actualizar el precio en las pestañas correspondientes
                technical.setPrecio(precio);
            } catch (Exception ex) {
                System.err.println("Error al obtener el precio para el ticker " + ticker + ": " + ex.getMessage());
            }
        });
		
		tbdpnlContent = new JTabbedPane(JTabbedPane.TOP);
		tbdpnlContent.setFont(new Font("Arial", Font.PLAIN, 13));
		tbdpnlContent.setBorder(null);
		frmMainApp.getContentPane().add(tbdpnlContent, BorderLayout.CENTER);
		tbdpnlContent.addTab("Análisis Técnico", technical); // Pestaña de análisis técnico con contenido Analysis
		tbdpnlContent.addTab("Fundamentales", new FundamentalsAnalysisApp()); // Pestaña de fundamentales con contenido Fundamental
	
		
	}

	private double buscarPrecio(String ticker) throws Exception {
	    // Aquí haces la solicitud HTTP a la API de Alpha Vantage para obtener el precio del ticker

	    // Ejemplo de cómo hacer la solicitud con Apache HttpClient
	    CloseableHttpClient httpClient = HttpClients.createDefault();
	    String apiKey = "PC2064VAMC8JGNU7";
	    String url = "https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=" + ticker + "&apikey=" + apiKey;

	    HttpGet httpGet = new HttpGet(url);
	    HttpResponse response = httpClient.execute(httpGet);

	    String jsonResponse = EntityUtils.toString(response.getEntity());

	    // Parsear el JSON utilizando json-simple
	    JSONParser parser = new JSONParser();
	    JSONObject jsonObject = (JSONObject) parser.parse(jsonResponse);
	    JSONObject globalQuote = (JSONObject) jsonObject.get("Global Quote");
	    double precio = Double.parseDouble((String) globalQuote.get("05. price"));

	    return precio;
	}

	public JFrame getFrame() {
		// TODO Auto-generated method stub
		return frmMainApp;
	}

}
