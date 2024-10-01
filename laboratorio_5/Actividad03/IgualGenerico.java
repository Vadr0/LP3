package Actividad03;

public class IgualGenerico {
    public static < T > boolean esIgualA(T ob1, T ob2) {
        if (ob1 == null|| ob2 == null) {
            throw new NullPointerException("el objeto es null");
        }

        return ob1.equals(ob2);
    }
    public static void main(String[] args) {
        try {
            Integer a = 10;
            Integer b = 20;
            System.out.printf("%s es igual a %s?: " + esIgualA(a, b),a,b);
            System.out.println();

            Object obj1 = new Object();
            Object obj2 = new Object();
            System.out.printf("Objeto1 es igual a Objeto2?: " + esIgualA(obj1, obj2));
            System.out.println();

            String str1 = "hola";
            String str2 = null;
            System.out.printf("%s es igual a %s?: " + esIgualA(str1, str2),str1,str2);
            System.out.println();


        } catch (NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
