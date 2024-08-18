import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        int[] arreglo = new int[10];
        leerArreglo(arreglo);

        for (int elemento : arreglo) {
            System.out.printf(elemento+" ");
        }
    }

    public static void leerArreglo(int[] arreglo) {
        Scanner entrada = new Scanner(System.in);
        for (int i = 0; i < arreglo.length; i++) {
            if (i == 0){
                System.out.printf("Ingrese " + (i + 1) + "° valor: ");
                arreglo[i] = entrada.nextInt();
            }
            while (i > 0){
                System.out.printf("ingrese "+(i+1)+"° valor: ");
                arreglo[i] = entrada.nextInt();
                if (arreglo[i] > arreglo[i-1]){
                    break;
                }else {
                    System.out.println("El numero debe ser mayor a "+arreglo[i-1]);
                }
            }
        }
        entrada.close();
    }
}
