package Ejercicio04;

import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        Estudiante est = new Estudiante();
        Estudiante est1 = new Estudiante("Alvaro");
        Estudiante est2 = new Estudiante("Antonio");
        Estudiante est3 = new Estudiante("Angel");

        RegistroEstudiantes reg = new RegistroEstudiantes();
        try{
            // Registro de alumnos
            reg.agregarEstudiante(est1);
            reg.agregarEstudiante(est2);
            reg.agregarEstudiante(est3);

            // Busqueda de alumno
            reg.buscarEstudiante("Alvaro");
            reg.buscarEstudiante("Ander");

        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        } catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }
    }
}
