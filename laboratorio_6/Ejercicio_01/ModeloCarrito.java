package Ejercicio_01;

import java.util.ArrayList;

public class ModeloCarrito {
    // Lista que almacenará los productos agregados al carrito
    private ArrayList<Producto> carrito;
    // Constructor que inicializa la lista del carrito
    public ModeloCarrito() {
        carrito = new ArrayList<>();
    }
    // Devuelve la lista completa de productos en el carrito
    public ArrayList<Producto> getCarrito() {
        return carrito;
    }
    // Agrega un producto a la lista del carrito
    public void agregarProducto(Producto producto) {
        carrito.add(producto);
    }
    // Elimina un producto de la lista del carrito
    public void eliminarProducto(Producto producto) {
        carrito.remove(producto);
    }
    // Devuelve el producto en la posición indicada de la lista
    public Producto obtenerProducto(int posicion) {
        return carrito.get(posicion);
    }
    // Vacía todo el contenido de la lista del carrito
    public void vaciarCarrito() {
        carrito.clear();
    }
}
