package Actividad01;

public class Imprimir {
    public static <E> void imprimirArreglo(E [] arregloEntrada){
        for (E elemento : arregloEntrada){
            System.out.printf("%s",elemento);
        }
        System.out.println();
    }
    public static <E> void imprimirArreglo(E [] arregloEntrada, int indInfe, int indSuper){
        if (indInfe < 0 || indSuper >= arregloEntrada.length || indSuper < indInfe || indInfe > indSuper){
            throw new InvalidSubscripException("Indice fuera de rango");
        }
        for (int i = indInfe; i <= indSuper; i++){
            System.out.printf("%s \n",arregloEntrada[i]);
            //System.out.println();

        }

    }

    public static void main(String[] args) {
        Integer [] arreglosInteger = { 1, 2, 3, 4 , 6, 10};
        Double [] arreglosDouble = { 1.1, 2.2, 3.3, 4.4, 5.5};

        try{
            imprimirArreglo(arreglosInteger,0,3);
        } catch (InvalidSubscripException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
