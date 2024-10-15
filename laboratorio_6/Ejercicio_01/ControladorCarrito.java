package Ejercicio_01;

import java.util.ArrayList;

public class ControladorCarrito {
    // Instancias de la vista y los modelos para gestionar el carrito y el historial de compras
    VistaCarrito vistaCarrito;
    ModeloCarrito modeloCarrito;
    ModeloCarrito historialCompras;

    // Constructor inicializa la vista y los modelos
    public ControladorCarrito() {
        vistaCarrito = new VistaCarrito();
        modeloCarrito = new ModeloCarrito();
        historialCompras = new ModeloCarrito();
    }

    // Método para agregar un producto al carrito
    public void agregarPedido() {
        // Solicita el nombre del producto desde la vista
        String nombre = vistaCarrito.solicitarNombre();
        double precio = 0;

        // Bucle para asegurar que el precio ingresado es válido (> 0)
        do {
            try {
                // Intenta convertir el precio ingresado en un número
                precio = Double.parseDouble(vistaCarrito.solicitarPrecio());
            } catch (NumberFormatException e) {
                // Mensaje de error si el precio no es un número válido
                vistaCarrito.mostrarMensaje("Error: valor invalido");
            }
        } while (precio <= 0);

        // Si el nombre no está vacío, se crea y se agrega el producto al carrito
        if (!nombre.isEmpty()) {
            this.modeloCarrito.agregarProducto(new Producto(nombre, precio));
            this.vistaCarrito.mostrarMensaje("Producto agregado: " + nombre + " precio: " + precio);
        } else {
            // Mensaje de error si el nombre del producto está vacío
            this.vistaCarrito.mostrarMensaje("El nombre del producto no puede estar vacio");
        }
    }

    // Método para mostrar los productos en el carrito
    public void mostrarCarrito() {
        this.vistaCarrito.mostrarCarrito(modeloCarrito.getCarrito());
    }

    // Método para eliminar un producto del carrito
    public void eliminarProducto() {
        // Muestra el contenido del carrito
        this.vistaCarrito.mostrarCarrito(modeloCarrito.getCarrito());
        // Pide al usuario que ingrese el número del producto a eliminar
        this.vistaCarrito.mostrarMensaje("Ingrese el N° del producto a eliminar");
        int numProd = 0;

        // Intenta obtener el número de producto y eliminarlo
        try {
            numProd = Integer.parseInt(vistaCarrito.solicitarOpcion());
            Producto prodEliminar = modeloCarrito.obtenerProducto(numProd - 1);
            modeloCarrito.eliminarProducto(prodEliminar);
            vistaCarrito.mostrarMensaje("Producto eliminado: [" + prodEliminar + "]");
        } catch (NumberFormatException e) {
            vistaCarrito.mostrarMensaje("Error: valor invalido");
        } catch (IndexOutOfBoundsException e) {
            vistaCarrito.mostrarMensaje("Error: no existe el producto");
        }
    }

    // Calcula el monto total del carrito sumando los precios de los productos
    private double calcularMonto() {
        ArrayList<Producto> carrito = modeloCarrito.getCarrito();
        double monto = 0;
        for (Producto p : carrito) {
            monto += p.getPrecio();
        }
        return monto;
    }

    // Determina un descuento basado en el monto total del carrito
    public double categoriaDescuento() {
        double monto = calcularMonto();
        if (monto > 1000 && monto < 2000)
            return 50;
        if (monto < 3000)
            return .120;
        if (monto >= 3000)
            return 200;
        return 0;
    }

    // Calcula el monto final aplicando el descuento
    public double calcularDescuento() {
        return calcularMonto() - categoriaDescuento();
    }

    // Muestra el monto inicial, el descuento aplicado y el costo final
    public void aplicarDescuento() {
        vistaCarrito.mostrarMensaje("Monto: " + calcularMonto());
        vistaCarrito.mostrarMensaje("Descuento: " + categoriaDescuento());
        vistaCarrito.mostrarMensaje("Costo Final: " + calcularDescuento());
    }

    // Muestra el historial de compras
    public void mostrarHistorial() {
        this.vistaCarrito.mostrarCarrito(historialCompras.getCarrito());
    }

    // Agrega los productos actuales del carrito al historial de compras
    public void agregarCompras() {
        ArrayList<Producto> carrito = modeloCarrito.getCarrito();
        for (Producto p : carrito) {
            historialCompras.agregarProducto(p);
        }
    }

    // Vacía el carrito después de realizar la compra
    private void vaciarCarrito() {
        modeloCarrito.vaciarCarrito();
    }

    // Método para realizar la compra
    public void realizarCompra() {
        vistaCarrito.mostrarMensaje("Realizando Compra...");
        agregarCompras(); // Agrega los productos al historial
        aplicarDescuento(); // Muestra el costo final
        vaciarCarrito(); // Vacía el carrito
        vistaCarrito.mostrarMensaje("Compra Realizada");
    }

    // Método para iniciar el menú principal de la aplicación
    public void iniciar() {
        String opcion;
        do {
            vistaCarrito.mostrarMenu();
            opcion = vistaCarrito.solicitarOpcion();
            switch (opcion) {
                case "1":  
                    agregarPedido();
                    break;
                case "2":  
                    mostrarCarrito();
                    break;
                case "3":  
                    eliminarProducto();
                    break;
                case "4":  
                    vistaCarrito.descuentos();
                    aplicarDescuento();
                    break;
                case "5":  
                    vistaCarrito.mostrarMensaje("El envío tardará entre 2 a 5 días posteriores a la compra");
                    break;
                case "6":  
                    vistaCarrito.mostrarMensaje("Historial de Compras");
                    mostrarHistorial();
                    break;
                case "7":  
                    realizarCompra();
                    break;
                case "8":  
                    vistaCarrito.cerrarScanner();
                    break;
                default:
                    vistaCarrito.mostrarMensaje("Error: opción inválida");
            }
        } while (!opcion.equals("8"));
    }
}
