package Actividad_03;

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
    //Actividad 02
    public void eliminarPedido() {
        if (modelo.contarPedidos()== 0) {
            return;
        }
        try {
            int indice = Integer.parseInt(vista.ingresarIndice());
            modelo.eliminarPedido(indice-1);
            this.vista.mostrarMensaje("Pedido eliminado");
        } catch (NumberFormatException e) {
            //System.out.println("Error: La cadena ingresada no es un número válido.");
            vista.mostrarMensaje("Error: La cadena ingresada no es un número válido.");
        } catch (IndexOutOfBoundsException e) {
            //System.out.println("Error: "+e.getMessage());
            vista.mostrarMensaje("Error: Pedido no existe.");
        }
    }
    public void actualizarPedido(String nombrePlato) {
        int indice = modelo.buscarPedido(nombrePlato);
        if (indice == -1) {
            this.vista.mostrarMensaje("El nombre del plato no existe");
        } else {
            String nuevoPlato = vista.solicitarNombrePlato();
            if (!nombrePlato.isEmpty()) {
                modelo.actualizarPedido(indice, nuevoPlato);
                this.vista.mostrarMensaje("Pedido actualizado");
            } else {
                this.vista.mostrarMensaje("El nombre del plato no puede estar vacio");
            }
        }
    }
    public void buscarPedido(String nombrePlato) {
        int indice = modelo.buscarPedido(nombrePlato);
        if (indice == -1){
            this.vista.mostrarMensaje("El nombre del plato no existe");
        } else {
            vista.mostrarPedido(indice, modelo.getPedidos());
        }
    }
    public void contarPedidos() {
        vista.mostrarMensaje("Total Pedidos: "+modelo.contarPedidos());
    }
    // Actividad 03

    public void marcarPedido() {
        try {
            int indice = Integer.parseInt(vista.ingresarIndice());
            modelo.complearPedido(indice);
        } catch (NumberFormatException e) {
            //System.out.println("Error: La cadena ingresada no es un número válido.");
            vista.mostrarMensaje("Error: La cadena ingresada no es un número válido.");
        } catch (IndexOutOfBoundsException e) {
            //System.out.println("Error: "+e.getMessage());
            vista.mostrarMensaje("Error: Pedido no existe.");
        }
    }
    public void mostrarPedidosPendientes() {
        vista.mostrarPedidosPendientes(modelo.getPedidos());
    }
    public void mostrarPedidosCheack(){
        vista.mostrarPedidos(modelo.getPedidosCheck());
    }
    public void contadorNoCheack() {
        vista.mostrarMensaje("N° Pedidos pendientes: "+modelo.contarPedidosNoCheck());
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
                case "3":
                    vista.mostrarPedidos(modelo.getPedidos());
                    eliminarPedido();
                    break;
                case "4":
                    String nombrePlato2 = vista.solicitarNombrePlato();
                    actualizarPedido(nombrePlato2);
                    break;
                case "5":
                    String nombrePlato3 = vista.solicitarNombrePlato();
                    buscarPedido(nombrePlato3);
                    break;
                case "6":
                    contarPedidos();
                    break;
                case "7":
                    marcarPedido();
                    break;
                case "8":
                    mostrarPedidosPendientes();
                    break;
                case "9":
                    mostrarPedidosCheack();
                    break;
                case "10":
                    contadorNoCheack();
                    break;
                case "11":
                    vista.mostrarMensaje("Saliendo... \nFin.");
                    break;
                default:
                    vista.mostrarMensaje("Opcion no valida, intentalo denuevo");
            }
        } while (!opcion.equals("11"));
    }
}
