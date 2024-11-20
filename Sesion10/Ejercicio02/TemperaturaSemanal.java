package Ejercicio02;



import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperaturaSemanal  extends JFrame {
    private JTextField[] temperatureFields = new JTextField[7]; // Campos para temperaturas
    private TemperatureGraphPanel graphPanel = new TemperatureGraphPanel();

    public TemperaturaSemanal() {
        setTitle("Gráfico de Temperaturas Semanales");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());

        // Panel para ingresar las temperaturas
        JPanel inputPanel = new JPanel(new GridLayout(2, 7, 5, 5));
        JLabel[] dayLabels = {
                new JLabel("Lunes"), new JLabel("Martes"), new JLabel("Miércoles"),
                new JLabel("Jueves"), new JLabel("Viernes"), new JLabel("Sábado"), new JLabel("Domingo")
        };
        for (int i = 0; i < 7; i++) {
            inputPanel.add(dayLabels[i]);
        }
        for (int i = 0; i < 7; i++) {
            temperatureFields[i] = new JTextField();
            inputPanel.add(temperatureFields[i]);
        }

        // Botón para mostrar el gráfico
        JButton showGraphButton = new JButton("Mostrar Gráfico");
        showGraphButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double[] temperatures = new double[7];
                try {
                    for (int i = 0; i < 7; i++) {
                        temperatures[i] = Double.parseDouble(temperatureFields[i].getText());
                    }
                    graphPanel.setTemperatures(temperatures);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(
                            TemperaturaSemanal.this,
                            "Por favor, ingresa valores válidos para todas las temperaturas.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });

        // Agregar componentes al frame
        add(inputPanel, BorderLayout.NORTH);
        add(graphPanel, BorderLayout.CENTER);
        add(showGraphButton, BorderLayout.SOUTH);

        setLocationRelativeTo(null); // Centrar la ventana
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TemperaturaSemanal::new);
    }
}

// Panel para dibujar el gráfico de líneas
class TemperatureGraphPanel extends JPanel {
    private double[] temperatures = new double[7];
    private final String[] days = {"Lun", "Mar", "Mié", "Jue", "Vie", "Sáb", "Dom"};

    public void setTemperatures(double[] temperatures) {
        this.temperatures = temperatures;
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
        double maxTemp = Math.ceil(getMaxTemperature());
        double minTemp = Math.floor(getMinTemperature());
        double tempRange = maxTemp - minTemp;

        int pointSpacing = width / (temperatures.length - 1);

        // Dibujar líneas y puntos
        int previousX = padding;
        int previousY = getHeight() - padding;

        for (int i = 0; i < temperatures.length; i++) {
            int x = padding + i * pointSpacing;
            int y = (int) (getHeight() - padding - (temperatures[i] - minTemp) / tempRange * height);

            // Dibujar puntos
            g2d.setColor(Color.RED);
            g2d.fillOval(x - 5, y - 5, 10, 10);

            // Dibujar línea entre puntos
            if (i > 0) {
                g2d.setColor(Color.BLUE);
                g2d.drawLine(previousX, previousY, x, y);
            }

            // Etiquetas de días
            g2d.setColor(Color.BLACK);
            g2d.drawString(days[i], x - 10, getHeight() - padding + 20);

            previousX = x;
            previousY = y;
        }
    }

    private double getMaxTemperature() {
        double max = Double.MIN_VALUE;
        for (double temp : temperatures) {
            max = Math.max(max, temp);
        }
        return max;
    }

    private double getMinTemperature() {
        double min = Double.MAX_VALUE;
        for (double temp : temperatures) {
            min = Math.min(min, temp);
        }
        return min;
    }
}
