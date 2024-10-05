package Actividad01;

// clase llamada Imprimir que contiene metodos genericos para imprimir arreglos
public class Imprimir {
    // metodo generico para imprimir todos los elementos de un arreglo
    public static <E> void imprimirArreglo(E[] arregloEntrada) {
        for (E elemento : arregloEntrada) {
            System.out.printf("%s", elemento);
        }
        System.out.println(); 
    }
    // metodo generico para imprimir los elementos de un arreglo entre dos indices dados
    public static <E> void imprimirArreglo(E[] arregloEntrada, int indInfe, int indSuper) {
        // verifica si los indices son validos
        if (indInfe < 0 || indSuper >= arregloEntrada.length || indSuper < indInfe || indInfe > indSuper) {
            throw new InvalidSubscripException("Indice fuera de rango"); // lanza excepcion si los indices no son validos
        }
        for (int i = indInfe; i <= indSuper; i++) {
            System.out.printf("%s \n", arregloEntrada[i]);
        }
    }
    // metodo principal para probar los metodos imprimirArreglo
    public static void main(String[] args) {
        Integer[] arreglosInteger = {1, 2, 3, 4, 6, 10}; // arreglo de enteros
        Double[] arreglosDouble = {1.1, 2.2, 3.3, 4.4, 5.5}; // arreglo de doubles
        try {
            // intenta imprimir una parte del arreglo de enteros
            imprimirArreglo(arreglosInteger, 0, 3);
        } catch (InvalidSubscripException e) {
            // captura la excepcion y muestra el mensaje de error
            System.out.println("Error: " + e.getMessage());
        }
    }
}
