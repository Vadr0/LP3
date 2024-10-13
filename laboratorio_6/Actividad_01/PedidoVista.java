package Actividad_01;

import java.util.Scanner;
import java.util.List;

public class PedidoVista {
    private Scanner scaner;
    public PedidoVista() {
        scaner = new Scanner(System.in);
    }
    public String solicitarNombrePlato() {
        System.out.print("Ingrese el nombre del plato: ");
        return scaner.nextLine();
    }
    public void mostrarPedidos(List<Pedido> pedidos) {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos");
        } else {
            for (Pedido p : pedidos) {
                System.out.println(p);
            }
        }

    }
    public void mostrarMenu() {
        System.out.println("\nOpciones:");
        System.out.println("1. Agregar pedido");
        System.out.println("2. Mostrar pedidos");
        System.out.println("3. Salir");
    }
    public String solicitarOpcion() {
        System.out.print("Ingrese el opcion: ");
        return scaner.nextLine();
    }
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
    public void cerrarScanner() {
        scaner.close();
    }
}
