package Ejercicio_02;

import java.util.ArrayList;

public class InventarioControlador {
    InventarioVista vista;
    InventarioModelo modelo;


    public InventarioControlador() {
        vista = new InventarioVista();
        modelo = new InventarioModelo();

    }
    public void iniciar() {
        String opcion;
        do {
            vista.mostrarMenu();
            vista.mensaje("Ingrese una opción: ");
            opcion = vista.solicitarOpcion();
            switch (opcion) {
                case "1":
                    agregarItem();
                    break;
                case "2":
                    eliminarItem();
                    break;
                case "3":
                    verInventario();
                    break;
                case "4":
                    mostrarDetalles();
                    break;
                case "5":
                    buscarItem();
                    break;
                case "6":
                    vista.mensaje("Saliendo del menu de inventario\n");
                    vista.cerrarScanner();
                    break;
                default:
                    vista.mensaje("Error: opcion no valida\n");
            }
        } while (!opcion.equals("6"));
    }
    public void agregarItem() {
        vista.mostrarInvetario(modelo.obtenerItemsDefecto());
        vista.mensaje("Ingrese el Nombre de un item:");
        String nameItem = vista.solicitarNombre();
        switch (nameItem) {
            case "Daga":
                modelo.agregarItem(new Arma("Daga", 1,"Arma","dagas veloces (damage 10)",10));
                vista.mensaje("Item agregado correctamente\n");
                break;
            case "Hacha":
                modelo.agregarItem(new Arma("Hacha", 1,"Arma","Hacha pesada (damage 30)",30));
                vista.mensaje("Item agregado correctamente\n");
                break;
            case "Espada":
                modelo.agregarItem(new Arma("Espada", 1,"Arma","Espada ligera (damage 20)",20));
                vista.mensaje("Item agregado correctamente\n");
                break;
            case "PocionA":
                modelo.agregarItem(new Pocion("PocionA", 1,"Poción","Poción basica (curación: 10)",10));
                vista.mensaje("Item agregado correctamente\n");
                break;
            case "PocionB":
                modelo.agregarItem(new Pocion("PocionB", 1,"Poción","Poción basica (curación: 20)",20));
                vista.mensaje("Item agregado correctamente\n");
                break;
            case "PocionS":
                modelo.agregarItem(new Pocion("PocionS", 1,"Poción","Poción maxima (curación: 30)",30));
                vista.mensaje("Item agregado correctamente\n");
                break;
            default:
                vista.mensaje("Error: el Item no existe");
                break;
        }
    }
    public void eliminarItem() {
        vista.mensaje("Ingrese el Nombre de un item:");
        String nameItem = vista.solicitarNombre();
        ArrayList<Item> items = modelo.obtenerItems();
        boolean itemFound = false;
        for (Item iterator : items) {
            if (nameItem.equalsIgnoreCase(iterator.getNombre())) {
                modelo.eliminarItem(iterator);
                vista.mensaje("Item eliminado correctamente\n");
                itemFound = true;
                break;
            }
        }
        if (!itemFound) {
            vista.mensaje("Error: el Item no existe");
        }
    }
    public void verInventario() {
        vista.mostrarInvetario(modelo.obtenerItems());
    }
    public void mostrarDetalles() {
        vista.mostrarDetalles(modelo.obtenerItems());
    }
    public void buscarItem() {
        boolean encontrado = false;
        vista.mensaje("Ingrese el Nombre de un item:");
        String nombreItem = vista.solicitarNombre();
        ArrayList<Item> items = modelo.obtenerItems();
        for (Item item : items) {
            if (nombreItem.equals(item.getNombre())) {
                vista.mensaje("Item encontrado:\n");
                vista.mostrarItem(item);
                encontrado = true;
            }
        }
        if (!encontrado) {
            vista.mensaje("Error: el Item no existe");
        }
    }
}
//        System.out.println("1. Agregar Item");
//        System.out.println("2. Eliminar Item");
//        System.out.println("3. Ver Inventario");
//        System.out.println("4. Mostrar detalles");
//        System.out.println("5. Buscar Item");
//        System.out.println("6. Salir");