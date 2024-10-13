package Actividad_01;

public class ControladorPedido {
    public ModeloPedido modelo;
    public PedidoVista vista;

    public ControladorPedido(ModeloPedido modelo, PedidoVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }
    public void agregarPedido(String nombrePlato) {
        if (!nombrePlato.isEmpty()) {
            this.modelo.agregarPedido(new Pedido(nombrePlato));
            this.vista.mostrarMensaje("Pedido agregado: "+nombrePlato);
        } else {
            this.vista.mostrarMensaje("El nombre del plato no puede estar vacio");
        }
    }
    public void mostrarPedidos() {
        this.vista.mostrarPedidos(modelo.getPedidos());
    }
    public void iniciar(){
        String opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.solicitarOpcion();
            switch (opcion) {
                case "1":
                    String nombrePlato = vista.solicitarNombrePlato();
                    agregarPedido(nombrePlato);
                    break;
                case "2":
                    mostrarPedidos();
                    break;
                default:
                    vista.mostrarMensaje("Opcion no valida, intentalo denuevo");
            }

        } while (!opcion.equals("3"));

    }
}
