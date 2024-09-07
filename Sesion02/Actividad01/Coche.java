package Actividad01;

public class Coche {
    private String modelo;
    private String marca;
    int anoFrabricacion;
    private double precio;

    // Constructor por defecto
    public Coche() {
        this.modelo = "none";
        this.marca = "none";
        this.anoFrabricacion = 0;
        this.precio = 0.0;
    }
    public Coche(String modelo, String marca, int anoFrabricacion,
                 double precio) {
        this.modelo = modelo;
        this.marca = marca;
        this.anoFrabricacion = anoFrabricacion;
        this.precio = precio;
    }
    public boolean aplicarDescuento() {
        if (this.anoFrabricacion < 2010) {
            return true;
        }
        return false;
    }
    public void encenderCoche() {
        System.out.println("Encendiendo coche: "+this.modelo);
    }
    public void acelerar() {
        System.out.println("Acelerando coche: "+this.modelo);
    }
    public void frenar() {
        System.out.println("Frenando coche: "+this.modelo);
    }
    public void apagarCoche() {
        System.out.println("Apagando coche: "+this.modelo);
    }
    // Metodos getters y setters
    public String getMarca() {
        return marca;
    }
    public String getModelo() {
        return modelo;
    }
    public int getAnoFrabricacion() {
        return anoFrabricacion;
    }
    public double getPrecio() {
        return precio;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public void setAnoFrabricacion(int anoFrabricacion) {
        this.anoFrabricacion = anoFrabricacion;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
}