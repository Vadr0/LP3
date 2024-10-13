package Ejercicio_01;

import java.util.ArrayList;

public class ModeloCarrito {
    private ArrayList<Producto> carrito;
    public ModeloCarrito() {
        carrito = new ArrayList<>();
    }
    public ArrayList<Producto> getCarrito() {
        return carrito;
    }
    public void agregarProducto(Producto producto) {
        carrito.add(producto);
    }
    public void eliminarProducto(Producto producto) {
        carrito.remove(producto);
    }
    public Producto obtenerProducto(int posicion) {
        return carrito.get(posicion);
    }
}
