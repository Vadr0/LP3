import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        Scanner am = new Scanner(System.in);

        // Solicitar horas, minutos y segundos al usuario
        System.out.print("ingresa el número de horas --> ");
        int horas = am.nextInt();

        System.out.print("ingresa el número de minutos --> ");
        int minutos = am.nextInt();

        System.out.print("ingresa el número de segundos --> ");
        int segundos = am.nextInt();

        // Convertir todo a segundos
        int totalSegundos = (horas * 3600) + (minutos * 60) + segundos;

        // Imprimir el resultado
        System.out.println("el tiempo total en segundos es :D --> " + totalSegundos);
    }
}