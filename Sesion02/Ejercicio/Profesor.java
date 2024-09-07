package Ejercicio;

class Profesor extends Persona {
    private String departamento;
    public Profesor(String nombre, String direccion, String
            departamento) {
        super(nombre, direccion);
        this.departamento = departamento;
    }
    @Override
    public void mostrarInformacion() {
        System.out.println("Profesor: " + nombre + ", Departamento: "
                + departamento);
    }
}