package com.SamuRodDev.siaChart.mainApp;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainApp {
    public static void main(String[] args) {
        // Crear y configurar la ventana principal
        JFrame frame = new JFrame("SIA Chart");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear y configurar los componentes de la interfaz gráfica
        JLabel label = new JLabel("Ticker de la acción:");
        JTextField textField = new JTextField(15);
        JButton button = new JButton("Buscar");

        // Crear un panel para agrupar los componentes
        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(textField);
        panel.add(button);

        // Agregar el panel al centro del BorderLayout del frame
        frame.add(panel, BorderLayout.CENTER);

        // Asociar un ActionListener al botón
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para manejar el evento de hacer clic en el botón
                // Aquí puedes obtener el texto del textField y hacer lo que necesites
                String ticker = textField.getText();
                System.out.println("Ticker ingresado: " + ticker);
            }
        });

        // Ajustar el tamaño y hacer visible la ventana
        frame.pack();
        frame.setVisible(true);
    }
}
