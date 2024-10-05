package Ejercicio01;

// clase generica llamada Par que almacena dos objetos de tipos diferentes
public class Par <F,S>{
    private F primero; // primer elemento del par
    private S segundo; // segundo elemento del par

    // constructor para inicializar los valores de primero y segundo
    public Par(F primero, S segundo) {
        this.primero = primero;
        this.segundo = segundo;
    }

    // metodo para obtener el valor del primer elemento
    public F getPrimero() {
        return this.primero;
    }

    // metodo para obtener el valor del segundo elemento
    public S getSegundo() {
        return this.segundo;
    }

    // metodo para actualizar el valor del primer elemento
    public void setPrimero(F primero) {
        this.primero = primero;
    }

    // metodo para actualizar el valor del segundo elemento
    public void setSegundo(S segundo) {
        this.segundo = segundo;
    }

    // metodo para convertir los valores del par a una cadena de texto
    @Override
    public String toString() {
        return "Primero: %s, Segundo: %s".formatted(this.primero, this.segundo);
    }
}
