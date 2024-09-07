package Actividad01;

public class TestCoche {
    public static void main(String[] args) {
        Coche auto = new Coche("Supra", "Toyota", 2015, 15000.0);

        // Detalles coche
        System.out.println("\nDetalles del coche :");
        System.out.println("Marca: " + auto.getMarca());
        System.out.println("Modelo : " + auto.getModelo());
        System.out.println("Año de fabricación: " +
                auto.getAnoFrabricacion());
        System.out.println("Precio: $" + auto.getPrecio());
        System.out.println("Aplicar descuento: " + auto.aplicarDescuento());
        auto.encenderCoche();
        auto.acelerar();
        auto.frenar();
        auto.apagarCoche();
    }
}