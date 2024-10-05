package Actividad03;

// clase IgualGenerico que contiene un metodo generico para comparar dos objetos
public class IgualGenerico {

    // metodo generico que verifica si dos objetos son iguales
    public static <T> boolean esIgualA(T ob1, T ob2) {
        // verifica si alguno de los objetos es null
        if (ob1 == null || ob2 == null) {
            throw new NullPointerException("el objeto es null"); // lanza excepcion si es null
        }
        return ob1.equals(ob2); // retorna el resultado de la comparacion
    }
    // metodo principal para probar el metodo esIgualA
    public static void main(String[] args) {
        try {
            Integer a = 10; // primer objeto entero
            Integer b = 20; // segundo objeto entero
            // imprime si los objetos a y b son iguales
            System.out.printf("%s es igual a %s?: " + esIgualA(a, b), a, b);
            System.out.println();

            Object obj1 = new Object(); // primer objeto de tipo Object
            Object obj2 = new Object(); // segundo objeto de tipo Object
            // imprime si obj1 y obj2 son iguales
            System.out.printf("Objeto1 es igual a Objeto2?: " + esIgualA(obj1, obj2));
            System.out.println();

            String str1 = "hola"; // primer objeto String
            String str2 = null; // segundo objeto String (null)
            // imprime si str1 y str2 son iguales
            System.out.printf("%s es igual a %s?: " + esIgualA(str1, str2), str1, str2);
            System.out.println();

        } catch (NullPointerException e) {
            // captura la excepcion y muestra el mensaje de error
            System.out.println("Error: " + e.getMessage());
        }
    }
}
