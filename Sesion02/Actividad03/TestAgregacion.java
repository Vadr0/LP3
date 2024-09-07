package Actividad03;

public class TestAgregacion {
    public static void main(String[] args) {
        Motor motor1 = new Motor(100,60);
        //Coche sin motor
        Automovil coche1 = new Automovil("DXD",4,"Mazda","rx7");
        coche1.setMotor(motor1);
        System.out.println(coche1);
    }
}
