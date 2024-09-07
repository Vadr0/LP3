package Ejercicio;

class Estudiante extends Persona {
    private String matricula;
    public Estudiante(String nombre, String direccion, String
            matricula) {
        super(nombre, direccion);
        this.matricula = matricula;
    }
    @Override
    public void mostrarInformacion() {
        System.out.println("Estudiante: " + nombre + ", Matrícula: "
                + matricula);
    }
}
