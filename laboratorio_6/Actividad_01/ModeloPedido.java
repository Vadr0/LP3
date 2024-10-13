package Actividad_01;

import java.util.ArrayList;
import java.util.List;

public class ModeloPedido {
    private List<Pedido> pedidos;

    public ModeloPedido() {
        pedidos = new ArrayList<>();
    }
    public void agregarPedido(Pedido p) {
        pedidos.add(p);
    }
    public List<Pedido> getPedidos() {
        return pedidos;
    }
}