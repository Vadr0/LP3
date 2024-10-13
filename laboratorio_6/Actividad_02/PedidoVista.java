package Actividad_02;

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
            System.out.printf("%-10s %-20s\n","N°Pedido","Nombre Plato");
            //System.out.println("\n----------------------------");
            for (Pedido p : pedidos) {
                System.out.printf("%-10d %-20s\n",i++,p);
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
        System.out.println("7. Salir");

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

}
