package Actividad04;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class ReporteTransacciones {

    private static final String RUTA_ARCHIVO = "transacciones.txt";

    // Método para escribir un reporte de transacciones
    public static void generarReporte(CuentaBancaria cuenta) throws IOException, HistorialVacioException {
        if (cuenta == null) {
            throw new IllegalArgumentException("La cuenta no puede ser null.");
        }

        if (cuenta.getSaldo() == 0) {
            throw new HistorialVacioException("No hay transacciones para la cuenta " + cuenta.numCuenta);
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(RUTA_ARCHIVO, true))) { // Modo "append"
            writer.println("Reporte de Transacciones:");
            writer.println("Numero de Cuenta: " + cuenta.numCuenta);
            writer.println("Titular: " + cuenta.titular);
            writer.println("Saldo Actual: " + cuenta.getSaldo());
            writer.println("-----------------------------");
        }
    }

    // Método para leer el reporte de transacciones desde un archivo
    public static void leerReporte() throws IOException {
        try (Scanner scanner = new Scanner(Files.newBufferedReader(Paths.get(RUTA_ARCHIVO)))) {
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                System.out.println(linea);
            }
        } catch (IOException e) {
            throw new IOException("Error al leer el archivo de transacciones: " + e.getMessage());
        }
    }
}
