public class Ejercicio1 {
    public static int sumaArray(int[] arr){
        int suma = 0;
        for(int i = 0; i < arr.length; i++){
            suma += arr[i];
        }
        return suma;
    }
    public static void main(String[] args) {
        int[] lista = {1,3,5,7};
        System.out.println("Suma: "+sumaArray(lista));
    }
}