package Ejercicio01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestionProductoApp extends JFrame {
    private Producto producto; // Instancia del modelo Producto
    // Campos de entrada de texto
    private JTextField nombreField;
    private JTextField precioField;
    private JTextField cantidadStockField;
    private JTextField categoriaField;
    private JLabel infoLabel; // Etiqueta para mostrar información actualizada del producto

    // Constructor que configura la ventana y los componentes de la interfaz
    public GestionProductoApp() {
        setTitle("Gestión de Producto"); // Título de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Acción al cerrar la ventana
        setSize(400, 300); // Tamaño de la ventana
        setLayout(new BorderLayout()); // Diseño de la ventana

        // Crear un producto inicial con valores por defecto
        producto = new Producto("Producto Inicial", 0.0, 0, "Sin Categoría");

        // Panel para la entrada de datos del producto
        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 10)); // Diseño en forma de cuadrícula

        // Campos de entrada para cada atributo del producto
        inputPanel.add(new JLabel("Nombre del Producto:"));
        nombreField = new JTextField();
        inputPanel.add(nombreField);

        inputPanel.add(new JLabel("Precio:"));
        precioField = new JTextField();
        inputPanel.add(precioField);

        inputPanel.add(new JLabel("Cantidad en Stock:"));
        cantidadStockField = new JTextField();
        inputPanel.add(cantidadStockField);

        inputPanel.add(new JLabel("Categoría:"));
        categoriaField = new JTextField();
        inputPanel.add(categoriaField);

        // Botón para actualizar los datos del producto
        JButton actualizarButton = new JButton("Actualizar Producto");
        inputPanel.add(actualizarButton);

        // Etiqueta para mostrar la información del producto actual
        infoLabel = new JLabel(producto.getInfoProducto());
        infoLabel.setHorizontalAlignment(SwingConstants.CENTER); // Alinear el texto al centro
        infoLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Espaciado alrededor del texto

        // Acción al hacer clic en el botón "Actualizar Producto"
        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Obtener datos ingresados por el usuario
                    String nombre = nombreField.getText();
                    double precio = Double.parseDouble(precioField.getText());
                    int cantidadStock = Integer.parseInt(cantidadStockField.getText());
                    String categoria = categoriaField.getText();

                    // Actualizar los atributos del producto
                    producto.setNombre(nombre);
                    producto.setPrecio(precio);
                    producto.setCantidadStock(cantidadStock);
                    producto.setCategoria(categoria);

                    // Mostrar la información actualizada en la etiqueta
                    infoLabel.setText(producto.getInfoProducto());
                } catch (NumberFormatException ex) {
                    // Mostrar mensaje de error si los datos no son válidos
                    JOptionPane.showMessageDialog(
                            GestionProductoApp.this,
                            "Por favor, ingresa valores válidos para el precio y la cantidad en stock.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });

        // Agregar los componentes a la ventana
        add(inputPanel, BorderLayout.CENTER); // Panel de entrada en el centro
        add(infoLabel, BorderLayout.SOUTH); // Etiqueta de información en la parte inferior
        setVisible(true);
    }
}
