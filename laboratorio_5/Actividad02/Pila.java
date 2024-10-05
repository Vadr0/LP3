package Actividad02;

// clase generica llamada Pila que implementa una pila de elementos
public class Pila<E> {
    private final int tamano; // tamaño maximo de la pila
    private int superior; // indice del elemento superior en la pila
    private E[] elementos; // arreglo para almacenar los elementos de la pila

    // constructor que inicializa el tamaño de la pila
    public Pila(int tamano) {
        this.tamano = tamano > 0 ? tamano : 10; // si tamano es menor o igual a 0, se establece en 10
        this.superior = -1; // inicializa el indice superior
        elementos = (E[]) new Object[tamano]; // crea el arreglo de elementos
    }
    // metodo para agregar un elemento a la pila
    public void push(E valorAMeter) {
        if (superior == tamano - 1) { // si la pila está llena
            throw new ExcepcionPilaLlena(String.format("La Pila esta llena, no se puede meter %s", valorAMeter)); // lanza excepcion
        }
        // añade valorAMeter en la Pila
        elementos[++superior] = valorAMeter; // incrementa el indice superior y agrega el elemento
    }
    // metodo para eliminar y devolver el elemento superior de la pila
    public E pop() {
        if (superior == -1) { // si la pila está vacía
            throw new ExceptionPilaVacia("La Pila esta vacia, no se puede sacar"); // lanza excepcion
        }
        return elementos[superior--]; // devuelve el elemento superior y decrementa el indice
    }
    // metodo principal para probar la clase Pila
    public static void main(String[] args) {
        Pila<String> pila = new Pila<String>(10); // crea una nueva pila de tipo String con tamaño 10
    }
}
