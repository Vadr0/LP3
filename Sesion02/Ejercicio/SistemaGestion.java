package Ejercicio;

import java.util.ArrayList;
import java.util.List;

class SistemaGestion {
    private List<Curso> cursos;
    public SistemaGestion() {
        cursos = new ArrayList<>();
    }
    public void crearCurso(String nombreCurso, String categoria, Profesor profesor) {
        Curso curso = new Curso(nombreCurso, categoria, profesor);
        cursos.add(curso);
    }
    public void inscribirEstudianteEnCurso(String nombreCurso, Estudiante estudiante) {
        for (Curso curso : cursos) {
            if (curso.getNombreCurso().equals(nombreCurso)) { //Usar el getter
                curso.inscribirEstudiante(estudiante);
            }
        }
    }
    public void mostrarCursos() {
        for (Curso curso : cursos) {
            System.out.println("Curso: " + curso.getNombreCurso());
            System.out.println("Profesor asignado: " +
                    curso.getProfesor().nombre); // Mostrar el nombre del profesor
            curso.mostrarEstudiantes();
            System.out.println(); // Línea en blanco para separar cursos
        }
    }
}