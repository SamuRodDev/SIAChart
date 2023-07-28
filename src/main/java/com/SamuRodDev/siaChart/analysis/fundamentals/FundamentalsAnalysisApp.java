package com.SamuRodDev.siaChart.analysis.fundamentals;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.json.simple.JSONObject;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.CardLayout;
import java.awt.FlowLayout;

public class FundamentalsAnalysisApp extends JTabbedPane{
	
	private JPanel pnlIncome;
    private JPanel pnlBalance;
    private JPanel pnlSummary;
    private JLabel lblIncome;
    private JLabel lblBalance;
    private JLabel lblSummary;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FundamentalsAnalysisApp window = new FundamentalsAnalysisApp();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FundamentalsAnalysisApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		pnlIncome = new JPanel();
		pnlBalance = new JPanel();
		pnlSummary = new JPanel();
		lblIncome = new JLabel("Introduzca valor para ver su cuenta de resultados");
		lblBalance = new JLabel("Introduzca valor para ver su balance");
		lblSummary = new JLabel("Introduzca valor para ver el resumen de sus datos fundamentales");
		addTab("Cuenta de resultados", pnlIncome);
		addTab("Balance", pnlBalance);
		addTab("Resumen", pnlSummary);
		pnlIncome.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		pnlIncome.add(lblIncome);
		pnlBalance.add(lblBalance);
		pnlSummary.add(lblSummary);
        
	}
	
	public void setFundamentals(JSONObject overview, JSONObject income, JSONObject balance) {
		
		
	}
}
