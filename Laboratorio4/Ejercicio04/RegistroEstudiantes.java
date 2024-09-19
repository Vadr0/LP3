package Ejercicio04;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class RegistroEstudiantes {
    ArrayList<Estudiante> estudiantes;
    public RegistroEstudiantes() {
        estudiantes = new ArrayList<>();
    }

    public void agregarEstudiante(Estudiante est) {
        if (est.getNombre() == null){
            throw new IllegalArgumentException("El nombre no puede ser nulo");
        }
        estudiantes.add(est);
    }
    public void buscarEstudiante(String nombre) {
        if (nombre == null){
            throw new IllegalArgumentException("El nombre no puede ser nulo");
        }
        for (Estudiante est : estudiantes) {
            if (est.getNombre().equals(nombre)){
                System.out.println("Estudiante encontrado " + est);
                return;
            }
        }
        throw new NoSuchElementException("No existe un estudiante de nombre : "+nombre);
    }
}
