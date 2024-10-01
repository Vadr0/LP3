package Actividad04;

public class Test {
    public static void main(String[] args) {
        Pila pila1 = new Pila(4);
        Pila pila2 = new Pila(4);

        pila1.push(1);
        pila1.push(2);
        pila1.push(3);

        pila2.push(1);
        pila2.push(2);
        pila2.push(3);

        System.out.println(pila1.equals(pila2));
    }
}
