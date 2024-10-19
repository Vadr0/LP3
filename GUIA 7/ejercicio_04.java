import java.io.*;
import java.util.*;
import javax.swing.JFileChooser;

public class ContadorPalabras {

    public static void main(String[] args) {
        try {
            // Seleccionar archivo con JFileChooser
            File archivo = seleccionarArchivo();
            if (archivo != null && archivo.exists()) {
                procesarArchivo(archivo);
            } else {
                System.out.println("Archivo no encontrado o inválido.");
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    // Método para seleccionar archivo usando JFileChooser
    private static File seleccionarArchivo() {
        JFileChooser fileChooser = new JFileChooser();
        int seleccion = fileChooser.showOpenDialog(null);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        }
        return null;
    }

    // Método principal para procesar el archivo
    private static void procesarArchivo(File archivo) throws IOException {
        int totalLineas = 0;
        int totalPalabras = 0;
        int totalCaracteres = 0;
        Map<String, Integer> frecuenciaPalabras = new HashMap<>();

        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                totalLineas++;
                totalCaracteres += linea.replace("\n", "").length(); // Sin contar el fin de línea
                String[] palabras = linea.split("\\s+"); // Separar palabras por espacios
                totalPalabras += palabras.length;

                // Contar frecuencia de palabras
                for (String palabra : palabras) {
                    palabra = palabra.toLowerCase().replaceAll("[^a-zA-Z0-9]", ""); // Limpiar palabra
                    if (!palabra.isEmpty()) {
                        frecuenciaPalabras.put(palabra, frecuenciaPalabras.getOrDefault(palabra, 0) + 1);
                    }
                }
            }
        }

        // Calcular promedio de palabras por línea
        double promedioPalabrasPorLinea = totalLineas > 0 ? (double) totalPalabras / totalLineas : 0;

        // Mostrar resultados
        System.out.println("Total de líneas: " + totalLineas);
        System.out.println("Total de palabras: " + totalPalabras);
        System.out.println("Total de caracteres: " + totalCaracteres);
        System.out.println("Promedio de palabras por línea: " + promedioPalabrasPorLinea);

        // Mostrar palabras más frecuentes
        mostrarPalabrasMasFrecuentes(frecuenciaPalabras);
    }

    // Método para mostrar las palabras más frecuentes
    private static void mostrarPalabrasMasFrecuentes(Map<String, Integer> frecuenciaPalabras) {
        System.out.println("Palabras más frecuentes:");
        frecuenciaPalabras.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())) // Ordenar por frecuencia
                .limit(10) // Mostrar solo las 10 más frecuentes
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}
