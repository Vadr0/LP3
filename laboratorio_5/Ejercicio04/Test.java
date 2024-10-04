package Ejercicio04;

public class Test {
    public static <F> void main(String[] args) {
        Par<Double,Integer> par1 = new Par<>(1.2, 1);
        Par<Double,Integer> par2 = new Par<>(1.3, 1);
        Par<Double,Integer> par3 = new Par<>(1.4, 1);
        Par<Double,Integer> par4 = new Par<>(1.5, 1);

        Contenedor  contePar = new Contenedor();
        contePar.agregarPar(par1);
        contePar.agregarPar(par2);
        contePar.agregarPar(par3);
        contePar.agregarPar(par4);

        contePar.mostrarPares();



    }
    public static <F,S>void imprimirPar(Par<F,S> par, Par<F,S> par2) {
        System.out.println("Par 1: "+par.toString());
        System.out.println("Par 2: "+par2.toString());
    }
}
