package Actividad_02;

import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class ModeloPedido {
    private List<Pedido> pedidos;
    private List<Pedido> pedidosCheck;

    public ModeloPedido() {
        pedidos = new ArrayList<>();
        pedidosCheck = new ArrayList<>();
    }
    public void agregarPedido(Pedido p) {
        pedidos.add(p);
    }
    public List<Pedido> getPedidos() {
        return pedidos;
    }
// Actividad 02
    public void eliminarPedido(int indice) {
        pedidos.remove(indice);
    }
    public void actualizarPedido(int indice, String nombrePlato) {
        // obtiene el pedido según el indice
        Pedido pedido = pedidos.get(indice);
        pedido.setNombreplato(nombrePlato); // modifica el atributo
    }
    public int buscarPedido(String nombrePlato) {
        for (Pedido p : pedidos) { // Itera cada elemento
            // compara el argumento con el atributo del elemento
            if (nombrePlato.equals(p.getNombreplato())) {
                return pedidos.indexOf(p);
            }
        }
        return -1;
    }
    public int contarPedidos(){
        return pedidos.size();
    }
}