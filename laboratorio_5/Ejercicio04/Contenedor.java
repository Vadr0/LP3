package Ejercicio04;

import java.util.ArrayList;

public class Contenedor  {
    ArrayList <Par> contenedor;
    public Contenedor() {
        contenedor = new ArrayList<>();
    }
    public void agregarPar(Par par) {
        contenedor.add(par);
    }
    public Par obtenerPar(int indice) {
        return contenedor.get(indice);
    }
    public ArrayList<Par> obtenerPars() {
        return contenedor;
    }
    public void mostrarPares(){
        for (Par par : contenedor) {
            System.out.println(par);
        }
    }
}
