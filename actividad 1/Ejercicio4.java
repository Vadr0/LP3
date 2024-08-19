public class Ejercicio4 {
    public static void main(String[] args) {
        double num1 = 5.6;
        double num2 = 2.4;
        double num3 = 8.1;
        
        double menor = menorDeTres(num1, num2, num3);
        System.out.println("El menor número es: " + menor);
    }

    public static double menorDeTres(double a, double b, double c) {
        return Math.min(a, Math.min(b, c));
    }
}
