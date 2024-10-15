package Ejercicio_02;

public class Arma extends Item{
    private int damage;

    public Arma(String nombre, int cantidad, String tipo, String descripcion, int damage) {
        super(nombre, cantidad, tipo, descripcion);
        this.damage = damage;
    }
    public int getDamage() {
        return damage;
    }
}
