package Ejercicio_02;

import java.util.ArrayList;

public class InventarioModelo {
    private ArrayList<Item> itemsJugador;
    private ArrayList<Item> itemsDefecto;
    public InventarioModelo() {
        this.itemsJugador = new ArrayList<>();
        this.itemsDefecto = new ArrayList<>();
        itemsDefecto.add(new Arma("Daga", 1,"Arma","dagas veloces (damage 10)",10));
        itemsDefecto.add(new Arma("Hacha", 1,"Arma","Hacha pesada (damage 30)",30));
        itemsDefecto.add(new Arma("Espada", 1,"Arma","Espada ligera (damage 20)",20));
        itemsDefecto.add(new Pocion("PocionA", 1,"Poción","Poción basica (curación: 10)",10));
        itemsDefecto.add(new Pocion("PocionB", 1,"Poción","Poción media (curación: 20)",20));
        itemsDefecto.add(new Pocion("PocionS", 1,"Poción","Poción maxima (curación: 30)",30));
    }
    public void agregarItem(Item item) {
        itemsJugador.add(item);
    }
    public void eliminarItem(Item item) {
        itemsJugador.remove(item);
    }
    public ArrayList<Item> obtenerItems (){
        return itemsJugador;
    }
    public Item buscarItem(String name) {
        for (Item item : itemsJugador) {
            if (name.equals(item.getNombre()))
                return item;
        }
        return null;
    }
    public ArrayList<Item> obtenerItemsDefecto() {
        return itemsDefecto;
    }
}
