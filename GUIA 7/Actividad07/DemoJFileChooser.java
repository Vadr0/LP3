package Actividad07;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class DemoJFileChooser extends JFrame {
    private final JTextArea areaSalida;

    public DemoJFileChooser() throws IOException {
        super("Demo de JFileChooser");
        this.areaSalida = new JTextArea();
        add(new JScrollPane(areaSalida));
        analizarRuta();

    }
    public void analizarRuta() throws IOException {
        // crea un objeto Path con la ruta al archivo o directorio sleccionado por el usuario
        Path ruta = obteRutaArchivoDirectorio();

        if (ruta != null && Files.exists(ruta)) {
            StringBuilder builder = new StringBuilder();
            builder.append(String.format("%s:%n", ruta.getFileName()));
            builder.append(String.format("%s un directorio%n", Files.isDirectory(ruta) ? "Es": "No es"));
            builder.append(String.format("%s una ruta absoluta%n", ruta.isAbsolute() ? "Es": "No es"));
            builder.append(String.format("Ultima modificación: %s%n", Files.getLastModifiedTime(ruta)));
            builder.append(String.format("Tamaño: %s%n", Files.size(ruta)));
            builder.append(String.format("Ruta: %s%n", ruta));
            builder.append(String.format("Ruta absoluta: %s%n", ruta.toAbsolutePath()));

            if (Files.isDirectory(ruta)) {
                builder.append(String.format("%nContenido del directorio: %n"));
                // objeto para iterar a través del contenido de un directorio
                DirectoryStream<Path> flujoDirectorio = Files.newDirectoryStream(ruta);
                for (Path p : flujoDirectorio) {
                    builder.append(String.format("%s%n", p));
                }
                areaSalida.setText(builder.toString()); // muestra el contenido del objeto String
            } else {
                JOptionPane.showMessageDialog(this,ruta.getFileName()+"no existe.","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public Path obteRutaArchivoDirectorio() {
        JFileChooser selectorArchivos = new JFileChooser();
        selectorArchivos.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int resultado = selectorArchivos.showOpenDialog(this);
        // si el usuario hizo clic en el botón Cancelar en el cuadro de diálogo, regresa
        if (resultado == JFileChooser.CANCEL_OPTION) {
            System.exit(1);
        }
        // devuelve objeto Path que representa el archivo seleccionado
        return selectorArchivos.getSelectedFile().toPath();
    }
}