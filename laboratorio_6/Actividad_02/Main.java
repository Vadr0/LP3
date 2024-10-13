package Actividad_02;

public class Main {
    public static void main(String[] args){
        ModeloPedido modelo = new ModeloPedido();
        PedidoVista vista = new PedidoVista();
        ControladorPedido controlador = new ControladorPedido(modelo, vista);
        controlador.iniciar();
    }
}
