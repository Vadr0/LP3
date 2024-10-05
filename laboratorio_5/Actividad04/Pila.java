package Actividad04;

// clase generica llamada Pila
public class Pila<E> {
    private final int tamano; // tamaño maximo de la pila
    private int superior; // indice del elemento superior
    private E[] elementos; // arreglo para los elementos

    // constructor que inicializa la pila
    public Pila(int tamano) {
        this.tamano = tamano > 0 ? tamano : 10; // establece tamaño
        this.superior = -1; // inicializa el indice superior
        elementos = (E[]) new Object[tamano]; // crea el arreglo
    }

    // agrega un elemento a la pila
    public void push(E valorAMeter) {
        if (superior == tamano - 1) { // si la pila está llena
            throw new ExcepcionPilaLlena(String.format("La Pila esta llena, no se puede meter: %s", valorAMeter));
        }
        elementos[++superior] = valorAMeter; // añade el elemento
    }

    // elimina y devuelve el elemento superior
    public E pop() {
        if (superior == -1) { // si la pila está vacía
            throw new ExceptionPilaVacia("La Pila esta vacia, no se puede sacar");
        }
        return elementos[superior--]; // devuelve y decrementa
    }

    // compara si dos pilas son iguales
    public boolean equals(Pila<E> otraPila) {
        if (otraPila == null || this.tamano != otraPila.tamano || this.superior != otraPila.superior) {
            return false; // verifica null y tamaños
        }
        for (int i = 0; i <= this.superior; i++) {
            if (elementos[i] != otraPila.elementos[i]) {
                return false; // compara elementos
            }
        }
        return true; // son iguales
    }

    // obtiene el indice del elemento superior
    public int getSuperior() {
        return superior; // retorna el indice
    }
}
