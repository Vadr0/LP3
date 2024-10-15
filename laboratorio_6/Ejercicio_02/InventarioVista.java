package Ejercicio_02;

import java.util.Scanner;
import java.util.ArrayList;

public class InventarioVista {
    // Objeto Scanner para recibir entrada del usuario
    private Scanner sc;
    // Constructor que inicializa el Scanner
    public InventarioVista() {
        sc = new Scanner(System.in);
    }
    // Método para mostrar el inventario con los nombres y descripciones de los ítems
    public void mostrarInvetario(ArrayList<Item> items) {
        System.out.printf("%-15s %-20s\n", "Nombre", "Descripcion");
        for (Item item : items) {
            System.out.printf("%-15s %-20s\n", item.getNombre(), item.getDescripcion());
        }
    }
    // Muestra los detalles de todos los ítems en el inventario
    public void mostrarDetalles(ArrayList<Item> items) {
        int i = 1;
        for (Item item : items) {
            System.out.println("\nItem < " + i++ + " >");
            mostrarItem(item);
        }
    }
    // Muestra la información detallada de un ítem
    public void mostrarItem(Item item) {
        System.out.println("    Nombre: " + item.getNombre());
        System.out.println("    Cantidad: " + item.getCantidad());
        System.out.println("    Tipo: " + item.getTipo());
        System.out.println("    Descripción: " + item.getDescripcion());
        // Verifica si el ítem es un arma o poción y muestra información adicional
        if (item instanceof Arma) {
            // Casting a Arma para mostrar el daño
            System.out.println("    Daño: " + ((Arma) item).getDamage());
        } else if (item instanceof Pocion) {
            // Casting a Pocion para mostrar la cantidad de curación
            System.out.println("    Curación: " + ((Pocion) item).getCura());
        }
    }
    // Método para mostrar un mensaje al usuario
    public void mensaje(String mensaje) {
        System.out.print(mensaje);
    }
    // Método para mostrar el menú de opciones
    public void mostrarMenu() {
        System.out.println("\n Inventario: ");
        System.out.println("1. Agregar Item");
        System.out.println("2. Eliminar Item");
        System.out.println("3. Ver Inventario");
        System.out.println("4. Mostrar detalles");
        System.out.println("5. Buscar Item");
        System.out.println("6. Salir");
    }
    // Método para solicitar una opción del menú al usuario
    public String solicitarOpcion() {
        return sc.nextLine();
    }
    // Método para cerrar el Scanner al final del programa
    public void cerrarScanner() {
        sc.close();
    }
    // Método para solicitar el nombre de un ítem al usuario
    public String solicitarNombre() {
        return sc.nextLine();
    }
}

//private String nombre;
//private int cantidad;
//private T tipo;
//private String descripcion;
