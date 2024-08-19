import java.util.Scanner;

public class Actividad4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.printf("Introduce el tamaño del arreglo: ");
        int n = scan.nextInt();

        int[] arreglo = new int[n];
        System.out.println("Introduce los elementos del arreglo: ");
        leerArreglo(scan, arreglo);

        double promedio = calcularPromedio(arreglo);
        System.out.printf("El promedio es: "+ promedio);

    }

    public static void leerArreglo(Scanner scanner, int[] arreglo) {
        for (int i=0; i<arreglo.length; i++) {
            arreglo[i] = scanner.nextInt();
        }
    }

    public static double calcularPromedio(int[] arreglo) {
        int suma = 0;
        for (int num : arreglo) {
            suma += num;
        }
        return (double) suma/ arreglo.length;
    }
}
