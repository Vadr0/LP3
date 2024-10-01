package Actividad04;

public class Pila <E> {
    private final int tamano;
    private int superior;
    private E[] elementos;

    public Pila(int tamano) {
        this.tamano = tamano > 0 ? tamano : 10;
        this.superior = -1;
        elementos = (E[]) new Object[tamano];
    }
    public void push(E valorAMeter) {
        if ( superior == tamano -1 ) { // si la pila está llena
            throw new ExcepcionPilaLlena(String.format("La Pila esta llena, no se puede meter %s", valorAMeter));
        }
        // Añade valorAMetar en la Pila
        elementos[++superior] = valorAMeter;
    }
    public E pop() {
        if ( superior == -1 ) { // Si la pila está vacíá
            throw new ExceptionPilaVacia("La Pila esta vacia, no se puede sacar");
        }
        return elementos[superior--]; // elimina y devuelve el ultimo
    }

    public boolean equals(Pila<E> otraPila) {
        if ( otraPila == null ) {
            return false;
        }
        if ( this.tamano != otraPila.tamano ) {
            return false;
        }
        for ( int i = 0; i < this.tamano; i++ ) {
            if ( elementos[i] != otraPila.elementos[i] ) {
                return false;
            }
        }
        return true;
    }

    public int getSuperior() {
        return superior;
    }
}
