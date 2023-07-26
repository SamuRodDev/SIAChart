package com.SamuRodDev.siaChart.mainApp;

import javax.swing.SwingUtilities;

public class MainApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainWindow window = new MainWindow();
                window.frmMainApp.setVisible(true);
            }
        });
    }
}

