package Ejercicio;

abstract class Persona {
    protected String nombre;
    protected String direccion;
    public Persona(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }
    public abstract void mostrarInformacion();
}