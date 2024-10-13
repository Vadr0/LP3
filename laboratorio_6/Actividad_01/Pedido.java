package Actividad_01;

public class Pedido {
    private String nombreplato;

    public Pedido(String nombreplato) {
        this.nombreplato = nombreplato;
    }
    public String getNombreplato() {
        return nombreplato;
    }
    @Override
    public String toString() {
        return this.nombreplato;
    }
}
