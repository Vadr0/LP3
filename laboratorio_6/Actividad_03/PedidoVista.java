package Actividad_03;

import java.util.List;
import java.util.Scanner;

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
        int i = 1;
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos");
        } else {
            System.out.printf("%-5s %-7s %-20s\n","N°","Estado","Plato");
            System.out.println("--------------------------------");
            for (Pedido p : pedidos) {
                System.out.printf("%-5d %-7s %-20s\n",i++,p.getEstado(),p.getNombreplato());
            }
        }

    }
    public void mostrarMenu() {
        System.out.println("\nOpciones:");
        System.out.println("1. Agregar pedido");
        System.out.println("2. Mostrar pedidos");
        System.out.println("3. Eliminar pedido");
        System.out.println("4. Actualizar pedido");
        System.out.println("5. Buscar pedido");
        System.out.println("6. Contar Pedidos");
        System.out.println("7. Marcar Pedido");
        System.out.println("8. Mostrar Pedidos Pendientes");
        System.out.println("9. Mostrar Pedidos Completados");
        System.out.println("10. Contador de pedidos Pendientes");
        System.out.println("11. Salir");

    }
    public String solicitarOpcion() {
        System.out.print("Ingrese la opcion: ");
        return scaner.nextLine();
    }
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
    public void cerrarScanner() {
        scaner.close();
    }
    // Actividad 02
    public String ingresarIndice() {
        System.out.print("Ingrese Numero de Pedido: ");
        return scaner.nextLine();
    }
    public void mostrarPedido(int indice, List<Pedido> pedidos) {
        System.out.println(pedidos.get(indice));
    }
    // Actividad 03
    public void mostrarPedidosPendientes(List<Pedido> pedidos) {
        int i = 1;
        System.out.printf("%-5s %-7s %-20s\n","N°","Estado","Plato");
        System.out.println("\n--------------------------------");
        for (Pedido p : pedidos) {
            if (p.getEstado().equals("p")) {
                System.out.printf("%-5d %-7s %-20s\n",i++,p.getEstado(),p.getNombreplato());
            }
        }
    }
}
