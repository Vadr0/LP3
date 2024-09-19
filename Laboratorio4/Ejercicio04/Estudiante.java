package Ejercicio04;

public class Estudiante {
    private String nombre;

    public Estudiante() {}
    public Estudiante(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public String toString() {
        return "nombre: " + nombre;
    }
}
