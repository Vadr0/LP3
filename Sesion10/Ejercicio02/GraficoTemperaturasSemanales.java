package Ejercicio02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraficoTemperaturasSemanales extends JFrame {
    private JTextField[] camposTemperaturas = new JTextField[7]; // Campos para temperaturas
    private PanelGraficoTemperaturas panelGrafico = new PanelGraficoTemperaturas();

    public GraficoTemperaturasSemanales() {
        setTitle("Gráfico de Temperaturas Semanales");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());

        // Panel para ingresar las temperaturas
        JPanel panelEntrada = new JPanel(new GridLayout(2, 7, 5, 5));
        JLabel[] etiquetasDias = {
                new JLabel("Lunes"), new JLabel("Martes"), new JLabel("Miércoles"),
                new JLabel("Jueves"), new JLabel("Viernes"), new JLabel("Sábado"), new JLabel("Domingo")
        };
        for (int i = 0; i < 7; i++) {
            panelEntrada.add(etiquetasDias[i]);
        }
        for (int i = 0; i < 7; i++) {
            camposTemperaturas[i] = new JTextField();
            panelEntrada.add(camposTemperaturas[i]);
        }

        // Botón para mostrar el gráfico
        JButton botonMostrarGrafico = new JButton("Mostrar Gráfico");
        botonMostrarGrafico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double[] temperaturas = new double[7];
                try {
                    for (int i = 0; i < 7; i++) {
                        temperaturas[i] = Double.parseDouble(camposTemperaturas[i].getText());
                    }
                    panelGrafico.setTemperaturas(temperaturas);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(
                            GraficoTemperaturasSemanales.this,
                            "Por favor, ingresa valores válidos para todas las temperaturas.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });

        // Agregar componentes al frame
        add(panelEntrada, BorderLayout.NORTH);
        add(panelGrafico, BorderLayout.CENTER);
        add(botonMostrarGrafico, BorderLayout.SOUTH);

        setLocationRelativeTo(null); // Centrar la ventana
        setVisible(true);
    }
}