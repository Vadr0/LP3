package Ejercicio_01;

import java.util.ArrayList;
import java.util.Scanner;

public class VistaCarrito {
    private Scanner sc = new Scanner(System.in);
    public void mostrarCarrito(ArrayList<Producto> carrito) {
        if (carrito.isEmpty()) {
            System.out.println("Carrito: vacio");
        } else {
            int i= 1;
            System.out.printf("%-12s %-12s %-12s\n","N°","Producto","Precio");
            for (Producto p : carrito) {
                System.out.printf("%-12d %-12s %-12s\n",i++,p.getNombre(),p.getPrecio());
            }
        }
    }
    public void mostrarMenu() {
        System.out.println("\n Carrito Online: ");
        System.out.println("1. Agregar Producto");
        System.out.println("2. Mostrar Carrito");
        System.out.println("3. Eliminar Producto");
        System.out.println("4. Aplicar Descuento");
        System.out.println("5. Calcular Envío");
        System.out.println("6. Historial de compras");
        System.out.println("7. Realizar la Compra");
        System.out.println("8. Salir\n");
    }
    public String solicitarOpcion() {
        System.out.print("Ingrese un opcion: ");
        return sc.nextLine();
    }
    public String solicitarNombre() {
        System.out.print("Ingrese un nombre: ");
        return sc.nextLine();
    }
    public String solicitarPrecio() {
        System.out.print("Ingrese un precio: ");
        return sc.nextLine();
    }
    public void cerrarScanner() {
        sc.close();
    }
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
    public void descuentos(){
        System.out.println("\nMonto > s/.1000 | Descuento de s/.50");
        System.out.println("Monto > s/.2000 | Descuento de s/.125");
        System.out.println("Monto > s/.3000 | Descuento de s/.200");
    }
}
