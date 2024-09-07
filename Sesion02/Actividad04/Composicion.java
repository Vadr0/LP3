package Actividad04;

public class Composicion {
    public static void main(String[] args) {
        Persona persona01 = new Persona(1,"John","Boy",1001,2200.99);
        Persona persona02 = new Persona(2,"Alfred","Apellido",1002);

        System.out.println(" ** Persona 01 **");
        System.out.println(persona01);



        System.out.println("\n ** Persona 02 **");
        System.out.println(persona02.getCuenta());
        System.out.println("Ingreso de Dinero");

        Cuenta cuenta002 = persona02.getCuenta();
        cuenta002.setSaldo(200);

        System.out.println(persona02);
    }
}
