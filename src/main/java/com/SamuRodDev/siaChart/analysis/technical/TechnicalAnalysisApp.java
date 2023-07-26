package com.SamuRodDev.siaChart.analysis.technical;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TechnicalAnalysisApp extends JPanel {

    private JLabel contentLabel;

    public TechnicalAnalysisApp() {
        contentLabel = new JLabel("Contenido del análisis técnico");
        add(contentLabel);
    }

    public void setPrecio(double precio) {
        // Crear un nuevo JLabel para mostrar el precio
        JLabel priceLabel = new JLabel("Precio: " + precio);

        // Reemplazar el contentLabel con el nuevo priceLabel
        remove(contentLabel);
        contentLabel = priceLabel;
        add(contentLabel);

        revalidate(); // Volver a validar el contenido del panel
        repaint();    // Repintar el panel con los cambios
    }
}