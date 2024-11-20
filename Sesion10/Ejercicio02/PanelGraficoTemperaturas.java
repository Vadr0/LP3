package Ejercicio02;

import javax.swing.*;
import java.awt.*;

class PanelGraficoTemperaturas extends JPanel {
    private double[] temperaturas = new double[7];
    private final String[] dias = {"Lun", "Mar", "Mié", "Jue", "Vie", "Sáb", "Dom"};

    public void setTemperaturas(double[] temperaturas) {
        this.temperaturas = temperaturas;
        repaint(); // Actualizar el gráfico
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Configurar gráficos
        int padding = 50;
        int width = getWidth() - 2 * padding;
        int height = getHeight() - 2 * padding;

        // Dibujar ejes
        g2d.drawLine(padding, padding, padding, getHeight() - padding); // Eje Y
        g2d.drawLine(padding, getHeight() - padding, getWidth() - padding, getHeight() - padding); // Eje X

        // Escala
        double tempMaxima = Math.ceil(getMaxTemperature());
        double tempMinima = Math.floor(getMinTemperature());
        double rangoTemperaturas = tempMaxima - tempMinima;

        int espacioPuntos = width / (temperaturas.length - 1);

        // Dibujar líneas y puntos
        int anteriorX = padding;
        int anteriorY = getHeight() - padding;

        for (int i = 0; i < temperaturas.length; i++) {
            int x = padding + i * espacioPuntos;
            int y = (int) (getHeight() - padding - (temperaturas[i] - tempMinima) / rangoTemperaturas * height);

            // Dibujar puntos
            g2d.setColor(Color.RED);
            g2d.fillOval(x - 5, y - 5, 10, 10);

            // Dibujar línea entre puntos
            if (i > 0) {
                g2d.setColor(Color.BLUE);
                g2d.drawLine(anteriorX, anteriorY, x, y);
            }

            // Etiquetas de días
            g2d.setColor(Color.BLACK);
            g2d.drawString(dias[i], x - 10, getHeight() - padding + 20);

            anteriorX = x;
            anteriorY = y;
        }
    }

    private double getMaxTemperature() {
        double max = Double.MIN_VALUE;
        for (double temp : temperaturas) {
            max = Math.max(max, temp);
        }
        return max;
    }

    private double getMinTemperature() {
        double min = Double.MAX_VALUE;
        for (double temp : temperaturas) {
            min = Math.min(min, temp);
        }
        return min;
    }
}