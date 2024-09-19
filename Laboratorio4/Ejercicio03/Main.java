package Ejercicio03;

public class Main {
    public static void main(String[] args) {
        try {
            //Creación del objeto de tipo Numero
            Numero num1 = new Numero(13);

            num1.setValor(-3.1);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
