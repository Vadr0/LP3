package Ejercicio02;

public class Test {
    public static void main(String[] args) {
        Par<Double,Integer> par1 = new Par<>(1.2, 1);
        Par<Double,Integer> par2 = new Par<>(1.2, 1);

        System.out.println(par1.toString());
        par1.esIgual(par2);
    }
}
