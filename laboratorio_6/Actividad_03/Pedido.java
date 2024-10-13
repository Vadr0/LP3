package Actividad_03;

public class Pedido {
    private String nombreplato;
    private String estado;

    public Pedido(String nombreplato) {
        this.nombreplato = nombreplato;
        // (Pendiente: p | Entregado: e | Eliminado: x)
        this.estado = "p";
    }
    public String getNombreplato() {
        return nombreplato;
    }
    public void setNombreplato(String nombreplato) {
        this.nombreplato = nombreplato;
    }
    @Override
    public String toString() {
        return this.nombreplato;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
}
