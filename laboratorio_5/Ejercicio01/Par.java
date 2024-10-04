package Ejercicio01;

public class Par <F,S>{
    private F primero;
    private S segundo;
    public Par(F primero, S segundo) {
        this.primero = primero;
        this.segundo = segundo;
    }
    public F getPrimero() {
        return this.primero;
    }
    public S getSegundo() {
        return this.segundo;
    }
    public void setPrimero(F primero) {
        this.primero = primero;
    }
    public void setSegundo(S segundo) {
        this.segundo = segundo;
    }
    @Override
    public String toString() {
        return "Primero: %s, Segundo: %s".formatted(this.primero, this.segundo);
    }
}
