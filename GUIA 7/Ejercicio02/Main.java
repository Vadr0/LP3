package Ejercicio02;

import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try{
            Gestor gestor = new Gestor("E:\\Lp3\\Git\\Sesion07\\Ejercicio02\\personajes.txt");

            while(true){
                menu();
                System.out.print("Ingrese una Opción: ");
                String opcion = sc.nextLine();

                switch(opcion){
                    case "1":
                        gestor.listarPersonajes();
                        break;
                    case "2":
                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();
                        System.out.print("Vida: ");
                        int vida = Integer.parseInt(sc.nextLine());
                        System.out.print("Ataque: ");
                        int ataque = Integer.parseInt(sc.nextLine());
                        System.out.print("Defensa: ");
                        int defensa = Integer.parseInt(sc.nextLine());
                        System.out.print("Alcance: ");
                        int alcance = Integer.parseInt(sc.nextLine());
                        gestor.agregarPersonajes(new Personaje(nombre, vida, ataque, defensa, alcance));
                        break;
                    case "3":
                        System.out.print("Nombre del personaje a modificar: ");
                        String nombreMod = sc.nextLine();
                        System.out.print("Vida: ");
                        int vidaN = Integer.parseInt(sc.nextLine());
                        System.out.print("Ataque: ");
                        int ataqueN = Integer.parseInt(sc.nextLine());
                        System.out.print("Defensa: ");
                        int defensaN = Integer.parseInt(sc.nextLine());
                        System.out.print("Alcance: ");
                        int alcanceN = Integer.parseInt(sc.nextLine());
                        gestor.modificarPersonaje(nombreMod, vidaN, ataqueN, defensaN, alcanceN);
                        break;
                    case "4":
                        System.out.print("Nombre del personaje a eliminar: ");
                        String nombreDel = sc.nextLine();
                        gestor.eliminarPersonaje(nombreDel);
                        break;
                    case "5":
                        System.out.println("Filtrando ");
                        break;
                    case "6":
                        String nombre2, atributo;
                        int valor;
                        System.out.print("Nombre del personaje a modificar: ");
                        nombre2 = sc.nextLine();
                        System.out.print("[vida|ataque|defensa|alcance]: ");
                        atributo = sc.nextLine();
                        atributo.toLowerCase();
                        System.out.print("Valor: ");
                        valor = Integer.parseInt(sc.nextLine());
                        gestor.actualizarAtributo(nombre2,atributo,valor);
                    case "7":
                        gestor.mostrarEstadisticasGenerales();
                        break;
                    case "8":
                        System.out.print("Ingrese ruta Absoluta (PersonajesExternos.txt): ");
                        String rutaExterna = sc.nextLine();
                        gestor.importarPersonajesExternos(rutaExterna);
                        break;
                    case "9":
                        System.out.print("Ingrese nombre del personaje: ");
                        String nombre3 = sc.nextLine();
                        gestor.subirNivelPersonaje(nombre3);
                        break;
                    case "10":
                        System.out.print("Saliendo... ");
                        return;
                    default:
                        System.out.println("Opción no válida.");
                }
            }

        } catch (NumberFormatException | IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }

    public static void menu(){
        System.out.println("\nMenú de Personajes");
        System.out.println("1. Listar personajes");
        System.out.println("2. Agregar personaje");
        System.out.println("3. Modificar personaje");
        System.out.println("4. Eliminar personaje");
        System.out.println("5. Filtrar según por atributo");
        System.out.println("6. Actualizar Atributo");
        System.out.println("7. Mostrar Estadicticas Generales");
        System.out.println("8. Importar Personajes Externos");
        System.out.println("9. Subir nivel de personaje");
        System.out.println("10. Salir");
    }
}