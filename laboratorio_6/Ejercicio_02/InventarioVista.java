package Ejercicio_02;

import java.util.Scanner;
import java.util.ArrayList;

public class InventarioVista {
    private Scanner sc;
    public InventarioVista() {
        sc = new Scanner(System.in);
    }
    public void mostrarInvetario(ArrayList<Item> items) {
        System.out.printf("%-15s %-20s\n","Nombre","Descripcion");
        for (Item item : items){
            System.out.printf("%-15s %-20s\n",item.getNombre(),item.getDescripcion());
        }
    }
    public void mostrarDetalles(ArrayList<Item> items) {
        int i = 1;
        for (Item item : items) {
            System.out.println("\nItem < " + i++ + " >");
            mostrarItem(item);
        }
    }
    public void mostrarItem(Item item) {
        System.out.println("    Nombre: " + item.getNombre());
        System.out.println("    Cantidad: " + item.getCantidad());
        System.out.println("    Tipo: " + item.getTipo());
        System.out.println("    Descripcion: " + item.getDescripcion());
        // verifica del tipo de Item
        if (item instanceof Arma) {
            // casting para poder obtener el damage)
            System.out.println("    Dañó: "+ ((Arma) item).getDamage());
        } else if (item instanceof Pocion) {
            System.out.println(("   Cura:"+ ((Pocion) item).getCura()));
        }

    }
    public void mensaje(String mensaje) {
        System.out.print(mensaje);
    }
    public void mostrarMenu() {
        System.out.println("\n Inventario: ");
        System.out.println("1. Agregar Item");
        System.out.println("2. Eliminar Item");
        System.out.println("3. Ver Inventario");
        System.out.println("4. Mostrar detalles");
        System.out.println("5. Buscar Item");
        System.out.println("6. Salir");
    }
    public String solicitarOpcion() {
        return sc.nextLine();
    }
    public void cerrarScanner(){
        sc.close();
    }
    public String solicitarNombre(){
        return sc.nextLine();
    }
}
//private String nombre;
//private int cantidad;
//private T tipo;
//private String descripcion;