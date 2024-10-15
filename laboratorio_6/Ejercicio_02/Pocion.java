package Ejercicio_02;

public class Pocion extends Item {
    private int cura;

    public Pocion(String nombre, int cantidad, String tipo, String descripcion, int cura) {
        super(nombre, cantidad, tipo, descripcion);
        this.cura = cura;
    }
    public int getCura() {
        return cura;
    }
}
