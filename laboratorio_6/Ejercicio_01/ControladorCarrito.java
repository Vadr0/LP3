package Ejercicio_01;

import java.util.ArrayList;

public class ControladorCarrito {
    VistaCarrito vistaCarrito;
    ModeloCarrito modeloCarrito;
    ModeloCarrito historialCompras;
    public ControladorCarrito() {
        vistaCarrito = new VistaCarrito();
        modeloCarrito = new ModeloCarrito();
        historialCompras = new ModeloCarrito();
    }
    public void agregarPedido() {
        String nombre = vistaCarrito.solicitarNombre();
        double precio = 0;
        // repite el Bucle si se ingresa un precion <= 0
        do {
            try {
                precio = Double.parseDouble(vistaCarrito.solicitarPrecio());
            } catch (NumberFormatException e) { // Error al hacer casting de String a Double
                vistaCarrito.mostrarMensaje("Error: valor invalido");
            }
        } while (precio <= 0);
        // Si el nombre no es null se crea el Producto y agrega al carrito
        if (!nombre.isEmpty()) {
            this.modeloCarrito.agregarProducto(new Producto(nombre, precio));
            this.vistaCarrito.mostrarMensaje("Produco agregado: " + nombre + " precio: "+ precio);
        } else {
            // Si es null, no se creara el Producto y se muestra un msj
            this.vistaCarrito.mostrarMensaje("El nombre del producto no puedo estar vacio");
        }
    }
    public void mostrarCarrito() {
        this.vistaCarrito.mostrarCarrito(modeloCarrito.getCarrito());
    }
    public void eliminarProducto() {
        // Se muestra el carrito
        this.vistaCarrito.mostrarCarrito(modeloCarrito.getCarrito());
        // Se pide ingresesar el número del producto en el carrito
        this.vistaCarrito.mostrarMensaje("Ingrese el N° del producto a eliminar");
        int numProd = 0;
        try { // Se captura posibles errores ( Al ingresar caracteres / un indice fuera de rango)
            numProd = Integer.parseInt(vistaCarrito.solicitarOpcion());
            // se obtiene el producto del Carrito
            Producto prodEliminar = modeloCarrito.obtenerProducto(numProd-1);
            // Se elimina el producto
            modeloCarrito.eliminarProducto(prodEliminar);
            vistaCarrito.mostrarMensaje("Producto eliminado: [" + prodEliminar + "]");
        // Captura: Error al convertir un String a Int
        } catch (NumberFormatException e) {
            vistaCarrito.mostrarMensaje("Error: valor invalido");
        // Captura: Error al acceder a un índice fuera de rango
        } catch (IndexOutOfBoundsException e) {
            vistaCarrito.mostrarMensaje("Error: no existe el producto");
        }
    }
    // Retorna el monto sumada de cada producto
    private double calcularMonto() {
        ArrayList <Producto> carrito = modeloCarrito.getCarrito();
        double monto = 0;
        for (Producto p : carrito) {
            monto += p.getPrecio();
        }
        return monto;
    }
    // Retorna un monto (descuento) según el monto total del carrito
    public double categoriaDescuento(){
        double monto = calcularMonto();
        if (monto > 1000 && monto < 2000)
            return 50;
        if (monto < 3000)
            return .120;
        if (monto >= 3000)
            return 200;
        return 0;
    }
    // retorna el Costo final al que se aplica el descuento
    public double calcularDescuento() {
        return calcularMonto() - categoriaDescuento();
    }
    // Muestra el monto incial, descuento y costo final
    public void aplicarDescuento() {
        vistaCarrito.mostrarMensaje("Monto: " + calcularMonto());
        vistaCarrito.mostrarMensaje("Descuento: " + categoriaDescuento());
        vistaCarrito.mostrarMensaje("Costo Final: " + calcularDescuento());
    }
    // Muestra a través de la vista el historial de compra
    public void mostrarHistorial() {
        this.vistaCarrito.mostrarCarrito(historialCompras.getCarrito());
    }
    // al realizar la compra de deben agregar los productos al historialCompras
    public void agregarCompras() {
        ArrayList <Producto> carrito = modeloCarrito.getCarrito();
        for (Producto p : carrito) {
            historialCompras.agregarProducto(p);
        }
    }
    // al realizar la compra se debe vaciar el carrito
    private void vaciarCarrito() {
        modeloCarrito.vaciarCarrito();
    }
    // métododo realizarCompra
    public void realizarCompra() {
        vistaCarrito.mostrarMensaje("Realizando Compra...");
        agregarCompras(); // Agrega las compras al historial Compras
        aplicarDescuento(); // muestra el costoFinal
        vaciarCarrito(); // vacia el carrito
        vistaCarrito.mostrarMensaje("Compra Realizada");
    }
    public void iniciar() {
        String opcion;
        do {
            vistaCarrito.mostrarMenu();
            opcion = vistaCarrito.solicitarOpcion();
            switch (opcion) {
                case "1":  // Agregar Producto
                    agregarPedido();
                    break;
                case "2":  // Mostrar Carrito
                    mostrarCarrito();
                    break;
                case "3":  // Eliminar Producto
                    eliminarProducto();
                    break;
                case "4":  // Aplicar Descuento
                    vistaCarrito.descuentos();
                    aplicarDescuento();
                    break;
                case "5":  // Calcular Envio
                    vistaCarrito.mostrarMensaje("El envio tardare entre 2 a 5 dias\nposteriores a la compra");
                    break;
                case "6":  // Historial de compras
                    vistaCarrito.mostrarMensaje("Historial de Compras");
                    mostrarHistorial();
                    break;
                case "7":  // Realizar la compra
                    realizarCompra();

                    break;
                case "8":  // Salir
                    vistaCarrito.cerrarScanner();
                    break;
                default:
                        vistaCarrito.mostrarMensaje("Error: opcion invalida");
            }
        } while (!opcion.equals("8"));
    }
}
