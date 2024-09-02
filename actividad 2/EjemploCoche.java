package Actividad01;

public class EjemploCoche {
    public static void main(String[] args) {
        Coche auto1 = new Coche();
        Coche auto2 = new Coche("Supra", "Toyota",2015, 15000.0);
        // Detalles del coche 1
        System.out.println("Detalles del coche auto1:");
        System.out.println("Marca: " + auto1.getMarca());
        System.out.println("Modelo : " + auto1.modelo);
        System.out.println("Año de fabricación: " + auto1.getAnoFrabricacion());
        System.out.println("Precio: $" + auto1.getPrecio());


        // Detalles coche 2
        System.out.println("\nDetalles del coche auto2:");
        System.out.println("Marca: " + auto2.getMarca());
        System.out.println("Modelo : " + auto2.modelo);
        System.out.println("Año de fabricación: " + auto2.getAnoFrabricacion());
        System.out.println("Precio: $" + auto2.getPrecio());
        System.out.println("Aplicar descuento: "+ auto2.aplicarDescuento());

    }
    public static class Coche{
        private String modelo;
        private String marca;
        int anoFrabricacion;
        private double precio;

        public Coche(){
            this.modelo = "none";
            this.marca = "none";
            this.anoFrabricacion = 0;
            this.precio = 0.0;
        }
        public Coche(String modelo,String marca, int anoFrabricacion, double precio){
            this.modelo = modelo;
            this.marca = marca;
            this.anoFrabricacion = anoFrabricacion;
            this.precio = precio;
        }

        public boolean aplicarDescuento() {
            if (this.anoFrabricacion < 2010){
                return true;
            }
            return false;
        }
        public String getModelo() {
            return modelo;
        }

        public String getMarca() {
            return marca;
        }

        public double getPrecio() {
            return precio;
        }

        public int getAnoFrabricacion() {
            return anoFrabricacion;
        }

        public void setModelo(String modelo) {
            this.modelo = modelo;
        }

        public void setPrecio(double precio) {
            this.precio = precio;
        }

        public void setMarca(String marca) {
            this.marca = marca;
        }

        public void setAnoFrabricacion(int anoFrabricacion) {
            this.anoFrabricacion = anoFrabricacion;
        }
    }
    //Metodos getters y setters
}
