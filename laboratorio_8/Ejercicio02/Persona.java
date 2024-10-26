package Ejercicio02;

class Persona {
    private int id;
    private String nombre;
    private int edad;
    private String ciudad;

    public Persona(int id, String nombre, int edad, String ciudad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.ciudad = ciudad;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getCiudad() {
        return ciudad;
    }
    public boolean cumpleCondicion(String campo, String valor) {
        return switch (campo) {
            case "nombre" -> nombre.equalsIgnoreCase(valor);
            case "edad" -> Integer.toString(edad).equals(valor);
            case "ciudad" -> ciudad.equalsIgnoreCase(valor);
            default -> false;
        };
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", nombre='" + nombre + '\'' + ", edad=" + edad + ", ciudad='" + ciudad + '\'' + '}';
    }
}