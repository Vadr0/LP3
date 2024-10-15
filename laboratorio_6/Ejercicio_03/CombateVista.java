package Ejercicio_03;

import java.util.Scanner;

public class CombateVista {
    private Scanner sc2;

    public CombateVista() {
        sc2 = new Scanner(System.in);
    }
    public String solicitarOpcionCombate() {
        return sc2.nextLine();
    }
    public String SolicitarNombre() {
        return sc2.nextLine();
    }
    public void menuCombate(){
        System.out.println("\nTu turno:");
        System.out.println("1. Atacar");
        System.out.println("2. Ver inventario");
        System.out.println("3. Usar Item");
        System.out.println("4. Salir");
    }
    public void interfazCombate(Jugador jugador, Enemigo enemigo) {
        System.out.printf("%-5s %-15s %-15s\n","","JUGADOR","ENEMIGO");
        System.out.printf("%-5s %-15s %-15s\n","",jugador.getNombre(),enemigo.getNombre());
        System.out.printf("%-5s %-15s %-15s\n","VIDA",jugador.getVida(),enemigo.getVida());
    }
    public void mostrarMsj(String msj){
        System.out.print(msj);
    }
    public void cerrarScanner2(){
        sc2.close();
    }
}
