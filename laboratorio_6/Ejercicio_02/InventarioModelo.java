package Ejercicio_02;

import java.util.ArrayList;

public class InventarioModelo {
    // Lista de ítems que posee el jugador
    private ArrayList<Item> itemsJugador;
    // Lista de ítems predeterminados disponibles para agregar al inventario
    private ArrayList<Item> itemsDefecto;
    // Constructor que inicializa las listas y agrega ítems predeterminados a la lista de ítems por defecto
    public InventarioModelo() {
        this.itemsJugador = new ArrayList<>();
        this.itemsDefecto = new ArrayList<>();
        // Agregando ítems predeterminados a la lista
        itemsDefecto.add(new Arma("Daga", 1, "Arma", "Dagas veloces (daño 10)", 10));
        itemsDefecto.add(new Arma("Hacha", 1, "Arma", "Hacha pesada (daño 30)", 30));
        itemsDefecto.add(new Arma("Espada", 1, "Arma", "Espada ligera (daño 20)", 20));
        itemsDefecto.add(new Pocion("PocionA", 1, "Poción", "Poción básica (curación: 10)", 10));
        itemsDefecto.add(new Pocion("PocionB", 1, "Poción", "Poción media (curación: 20)", 20));
        itemsDefecto.add(new Pocion("PocionS", 1, "Poción", "Poción máxima (curación: 30)", 30));
    }
    // Método para agregar un ítem al inventario del jugador
    public void agregarItem(Item item) {
        itemsJugador.add(item);
    }
    // Método para eliminar un ítem del inventario del jugador
    public void eliminarItem(Item item) {
        itemsJugador.remove(item);
    }
    // Devuelve la lista de ítems en el inventario del jugador
    public ArrayList<Item> obtenerItems() {
        return itemsJugador;
    }
    // Busca un ítem en el inventario del jugador por su nombre
    public Item buscarItem(String name) {
        for (Item item : itemsJugador) {
            if (name.equals(item.getNombre())) {
                return item;
            }
        }
        return null;  // Devuelve null si el ítem no se encuentra
    }
    // Devuelve la lista de ítems predeterminados que se pueden agregar al inventario
    public ArrayList<Item> obtenerItemsDefecto() {
        return itemsDefecto;
    }
}
