package com.SamuRodDev.siaChart.analysis.fundamentals;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.border.EmptyBorder;

public class FundamentalsAnalysisApp extends JTabbedPane{
	
	private JPanel pnlIncome;
    private JPanel pnlBalance;
    private JPanel pnlSummary;
    private JLabel lblIncome;
    private JLabel lblBalance;
    private JLabel lblSummary;
    private JPanel pnlLblIncome;
    private JPanel pnlTblIncome;
    private JPanel pnlBtnIncome;
    private JTable tblIncome;
    private ButtonGroup bgIncomeTimer;
    private JRadioButton rdbtnAnnualIncome;
    private JRadioButton rdbtnQuaterlyIncome;
    private JPanel pnlTimerIncome;
    private JPanel pnlQuatIncome;
    private JCheckBox chbxQuatIncome;
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
		lblIncome.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblBalance = new JLabel("Introduzca valor para ver su balance");
		lblSummary = new JLabel("Introduzca valor para ver el resumen de sus datos fundamentales");
		addTab("Cuenta de resultados", pnlIncome);
		addTab("Balance", pnlBalance);
		addTab("Resumen", pnlSummary);
		pnlIncome.setLayout(new BoxLayout(pnlIncome, BoxLayout.Y_AXIS));
		
		pnlLblIncome = new JPanel();
		pnlIncome.add(pnlLblIncome);
		pnlLblIncome.add(lblIncome);
		
		pnlTblIncome = new JPanel();
		pnlIncome.add(pnlTblIncome);
		
		tblIncome = new JTable();
		pnlTblIncome.add(tblIncome);
		
		pnlBtnIncome = new JPanel();
		pnlBtnIncome.setBorder(new EmptyBorder(10, 0, 10, 0));
		pnlIncome.add(pnlBtnIncome);
		bgIncomeTimer = new ButtonGroup();
		pnlBtnIncome.setLayout(new BoxLayout(pnlBtnIncome, BoxLayout.X_AXIS));
		
		pnlTimerIncome = new JPanel();
		pnlTimerIncome.setBorder(new EmptyBorder(10, 10, 10, 10));
		pnlBtnIncome.add(pnlTimerIncome);
		pnlTimerIncome.setLayout(new BoxLayout(pnlTimerIncome, BoxLayout.Y_AXIS));
		
		rdbtnAnnualIncome = new JRadioButton("Anual");
		pnlTimerIncome.add(rdbtnAnnualIncome);
		rdbtnAnnualIncome.setSelected(true);
		
		bgIncomeTimer.add(rdbtnAnnualIncome);
		rdbtnQuaterlyIncome = new JRadioButton("Trimestral");
		pnlTimerIncome.add(rdbtnQuaterlyIncome);
		bgIncomeTimer.add(rdbtnQuaterlyIncome);
		
		pnlQuatIncome = new JPanel();
		pnlQuatIncome.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		pnlBtnIncome.add(pnlQuatIncome);
		pnlQuatIncome.setLayout(new BoxLayout(pnlQuatIncome, BoxLayout.X_AXIS));
		
		chbxQuatIncome = new JCheckBox("Mostrar mismo trimestre de años anteriores");
		chbxQuatIncome.setEnabled(false);
		pnlQuatIncome.add(chbxQuatIncome);
		
		pnlBalance.add(lblBalance);
		pnlSummary.add(lblSummary);
        
	}
	
	public void setFundamentals(JSONObject overview, JSONObject income, JSONObject balance) {
		String company = (String) overview.get("Name");
		String ticker = (String) overview.get("Symbol");
		String market = (String) overview.get("Exchange");
		setIncome(company, ticker, market, income);
	}
	
	public void setIncome(String company, String ticker, String market, JSONObject income) {
		JSONArray annualDataArray = (JSONArray) income.get("annualReports");
		
		JSONObject quarterlyIncData = (JSONObject) income.get("quaterlyReports");
		
		JSONObject annualToTable;
		JSONObject quarterlyToTableNorm;
		JSONObject quarterlyToTableCond;
		String currency;
		
		currency = getCurrency(annualDataArray);
		lblIncome.setText("EMPRESA: " + company + "  -  TICKER: " + ticker + "  -  MERCADO: " + market + "  -  DIVISA: " + currency);
		
		//annualToTable = setDataToTable(annualIncData, 0);
		//quarterlyToTableNorm = setDataToTable(quarterlyIncData, 1);
		//quarterlyToTableCond = setDataToTable(quarterlyIncData, 2);
		 
	}
	
	private JSONObject setDataToTable(JSONObject quarterlyIncData, int type) {
		JSONObject orderedData = new JSONObject();
		return null;
	}
	
	public String getCurrency(JSONArray annualDataArray) {
		JSONObject annualIncData = (JSONObject) annualDataArray.get(0);
		String currency = (String) annualIncData.get("reportedCurrency");
		
		return currency;
	}
	
	public void setAnnualTable(JSONObject annualData, JTable tableData) {
		
	}
}
