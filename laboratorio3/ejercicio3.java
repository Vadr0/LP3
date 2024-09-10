public abstract class Vehiculo {
    public abstract void acelerar();
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////

public class Coche extends Vehiculo {
    @Override
    public void acelerar() {
        System.out.println("El coche está acelerando usando el motor");
    }
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////

public class Bicicleta extends Vehiculo {
    @Override
    public void acelerar() {
        System.out.println("La bicicleta está acelerando pedaleando");
    }
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////

public class Main {
    public static void main(String[] args) {
        Vehiculo coche = new Coche();
        Vehiculo bicicleta = new Bicicleta();

        testAcelerar(coche);
        testAcelerar(bicicleta);
    }

    public static void testAcelerar(Vehiculo vehiculo) {
        vehiculo.acelerar();
    }
}
