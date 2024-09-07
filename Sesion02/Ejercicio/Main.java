package Ejercicio;

public class Main {
    public static void main(String[] args) {
        SistemaGestion sistema = new SistemaGestion();
        Profesor prof1 = new Profesor("Ingeniera: MARISOL CRISTEL GALARZA FLORES", "Av. Siempreviva 742", "programación");
        sistema.crearCurso("Programacion", "LP3", prof1);
        Estudiante est1 = new Estudiante("Rodrigo Delgado", "Calle Falsa 123", "2023001324");
        Estudiante est2 = new Estudiante("Alvaro Montoya", "Calle Real 456", "2023002587");
        Estudiante est3 = new Estudiante("Yhosfer Quispe", "Calle Real 201", "2023002236");
        Estudiante est4 = new Estudiante("Orlando Montenegro", "Calle Real 689", "2023002987");
        sistema.inscribirEstudianteEnCurso("Programacion", est1);
        sistema.inscribirEstudianteEnCurso("Programacion", est2);
        sistema.inscribirEstudianteEnCurso("Programacion", est3);
        sistema.inscribirEstudianteEnCurso("Programacion", est4);
        sistema.mostrarCursos();
    }
}
