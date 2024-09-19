package Ejercicio02;

public class Calculadora {
    public double suma(double a, double b){
        return a+b;
    }
    public double resta(double a, double b){
        return a-b;
    }
    public double multiplicacion(double a, double b){
        return a*b;
    }
    public double division(double a, double b){
        if (b == 0) {
            throw new DivisionPorCeroException("No se puede dividir por cero");
        }
        return a/b;
    }
}
