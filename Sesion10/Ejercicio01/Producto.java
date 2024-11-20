package Ejercicio01;

class Producto {
    private String nombre;
    private double precio;
    private int cantidadStock;
    private String categoria;

    // Constructor
    public Producto(String nombre, double precio, int cantidadStock, String categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadStock = cantidadStock;
        this.categoria = categoria;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    // Método para obtener la información del producto como texto
    public String getInfoProducto() {
        return String.format(
                "Producto: %s | Precio: $%.2f | Stock: %d | Categoría: %s",
                nombre, precio, cantidadStock, categoria
        );
    }
}