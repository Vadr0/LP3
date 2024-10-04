package Actividad04;

public class Test {
    public static void main(String[] args) {
        Pila < Integer> pila1 = new Pila<>(3);
        Pila < Integer> pila2 = new Pila<>(3);

        try {
            pila1.push(1);
            pila1.push(2);
            pila1.push(3);
            pila1.push(4);

            pila2.push(1);
            pila2.push(2);
            pila2.push(3);


        }catch (ExcepcionPilaLlena e) {
            System.out.println("Error: " + e.getMessage());
        }catch (ExceptionPilaVacia e) {
            System.out.println("Error: " + e.getMessage());
        }catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println(pila1.equals(pila2));
    }
}
