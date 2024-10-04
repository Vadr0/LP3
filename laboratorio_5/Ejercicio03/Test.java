package Ejercicio03;

public class Test {
    public static void main(String[] args) {
        Par<Double,Integer> par1 = new Par<>(1.2, 1);
        Par<Double,Integer> par2 = new Par<>(1.2, 1);


        System.out.println(par1.esIgual(par2));
        imprimirPar(par1, par2);
    }
    public static <F,S>void imprimirPar(Par<F,S> par, Par<F,S> par2) {
        System.out.println("Par 1: "+par.toString());
        System.out.println("Par 2: "+par2.toString());
    }
}
