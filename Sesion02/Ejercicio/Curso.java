package Ejercicio;

import java.util.ArrayList;
import java.util.List;
class Curso {
    private String nombreCurso;
    private String categoria;
    private Profesor profesor;
    private List<Estudiante> estudiantes;
    public Curso(String nombreCurso, String categoria, Profesor profesor) {
        this.nombreCurso = nombreCurso;
        this.categoria = categoria;
        this.profesor = profesor;
        this.estudiantes = new ArrayList<>();
    }
    // getters
    public String getNombreCurso() {
        return nombreCurso;
    }
    public Profesor getProfesor() {
        return profesor;
    }
    public void inscribirEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }
    public void mostrarEstudiantes() {
        System.out.println("Curso: " + nombreCurso);
        for (Estudiante estudiante : estudiantes) {
            estudiante.mostrarInformacion();
        }
    }
    public int obtenerNumeroEstudiantes() {
        return estudiantes.size();
    }
}