class InvalidSubscriptException extends Exception {
    public InvalidSubscriptException(String message) {
        super(message);
    }
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////


public class PruebaMetodoGenerico {
    // método genérico imprimirArreglo
    public static <E> void imprimirArreglo(E[] arregloEntrada) {
        // muestra los elementos del arreglo
        for (E elemento : arregloEntrada) {
            System.out.printf("%s ", elemento);
        }
        System.out.println();
    } // fin del método imprimirArreglo

    // método sobrecargado imprimirArreglo con índices
    public static <E> int imprimirArreglo(E[] arregloEntrada, int subindiceInferior, int subindiceSuperior) throws InvalidSubscriptException {
        // validar los índices
        if (subindiceInferior < 0 || subindiceSuperior >= arregloEntrada.length || subindiceInferior >= subindiceSuperior || subindiceInferior <= 0 || subindiceSuperior <= 0) {
            throw new InvalidSubscriptException("Índices inválidos: fuera de rango o subindiceSuperior es menor o igual a subindiceInferior, o los índices no son mayores a 0.");
        }

        // mostrar los elementos del arreglo dentro del rango especificado
        for (int i = subindiceInferior; i <= subindiceSuperior; i++) {
            System.out.printf("%s ", arregloEntrada[i]);
        }
        System.out.println();

        // devolver la cantidad de elementos impresos
        return subindiceSuperior - subindiceInferior + 1;
    }

    public static void main(String args[]) {
        // crea arreglos de objetos Integer, Double y Character
        Integer[] arregloInteger = {1, 2, 3, 4, 5, 6};
        Double[] arregloDouble = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7};
        Character[] arregloCharacter = {'H', 'O', 'L', 'A'};

        try {
            System.out.println("El arreglo arregloInteger contiene:");
            imprimirArreglo(arregloInteger); // pasa un arreglo Integer
            System.out.println("El arreglo arregloInteger de subíndice 1 a 4 contiene:");
            imprimirArreglo(arregloInteger, 1, 4);

            System.out.println("\nEl arreglo arregloDouble contiene:");
            imprimirArreglo(arregloDouble); // pasa un arreglo Double
            System.out.println("El arreglo arregloDouble de subíndice 2 a 5 contiene:");
            imprimirArreglo(arregloDouble, 2, 5);

            System.out.println("\nEl arreglo arregloCharacter contiene:");
            imprimirArreglo(arregloCharacter); // pasa un arreglo Character
            System.out.println("El arreglo arregloCharacter de subíndice 1 a 2 contiene:");
            imprimirArreglo(arregloCharacter, 1, 2);
        } catch (InvalidSubscriptException e) {
            System.err.println(e.getMessage());
        }
    } // fin de main
} // fin de la clase PruebaMetodoGenerico
