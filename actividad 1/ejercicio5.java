mport java.util.Scanner;

public class Estacionamiento {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario el número de horas
        System.out.print("Ingrese el número de horas que estuvo estacionado: ");
        int numeroDeHoras = scanner.nextInt();

        // Calcular el cargo
        double cargo = calcularCargo(numeroDeHoras);

        // Mostrar el cargo
        System.out.println("El cargo por " + numeroDeHoras + " horas es: S/" + cargo);

        scanner.close();
    }

    public static double calcularCargo(int horas) {
        double costo = 0.0;

        if (horas <= 1) {
            costo = 3.00; // Cargo por la primera hora
        } else {
            costo = 3.00 + (horas - 1) * 0.50; // Cargo por la primera hora + horas adicionales
        }

        // Cargo máximo por día
        if (costo > 12.00) {
            costo = 12.00;
        }

        return costo;
    }
}
