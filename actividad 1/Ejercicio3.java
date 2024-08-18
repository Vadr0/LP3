import java.util.Random;

public class Ejercicio3 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] frequencia = new int[6];

        for(int i=0; i<20; i++) {
            int valor = random.nextInt(6);
            frequencia[valor]++;
        }

        System.out.println("Frencia de cada cara:");
        for(int i=0; i<frequencia.length; i++) {
            System.out.println("cara "+(i+1)+": "+frequencia[i]);
        }
    }
}
