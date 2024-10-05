package Ejercicio04;

import java.util.ArrayList;
// clase llamada Contenedor que almacena una lista de objetos par
public class Contenedor {
    ArrayList<Par> contenedor; // lista de objetos par
    // constructor para inicializar la lista
    public Contenedor() {
        contenedor = new ArrayList<>();
    }
    // metodo para agregar un objeto Par a la lista
    public void agregarPar(Par par) {
        contenedor.add(par);
    }
    // metodo para obtener un objeto Par de la lista por su indice
    public Par obtenerPar(int indice) {
        return contenedor.get(indice);
    }
    // metodo para obtener todos los objetos Par de la lista
    public ArrayList<Par> obtenerPars() {
        return contenedor;
    }
    // metodo para mostrar todos los pares en la lista
    public void mostrarPares() {
        for (Par par : contenedor) {
            System.out.println(par); // imprime cada par usando su metodo toString
        }
    }
}
