package Ejercicio02;

public class Main {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        try{
            System.out.println("Suma: " + calculadora.suma(10, Double.parseDouble("33")));
            System.out.println("Resta: " + calculadora.resta(5, 10));
            System.out.println("Multiplicación: " + calculadora.multiplicacion(10, 2));
            System.out.println("División: " + calculadora.division(10, 0));
        } catch (DivisionPorCeroException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
