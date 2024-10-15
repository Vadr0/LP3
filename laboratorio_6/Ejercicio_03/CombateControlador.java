package Ejercicio_03;

public class CombateControlador {
    private CombateModelo modelo;
    private CombateVista vista;

    public CombateControlador() {
        modelo = new CombateModelo();
        vista = new CombateVista();
    }
    public void iniciarCombate() {
        vista.mostrarMsj("Iniciando Combate...\n");
        // Se instacia al enemigo
        Enemigo enemigo = new Enemigo("Orco-Lord");
        modelo.setEnemigo(enemigo);

        vista.mostrarMsj("Ingrese su Nombre: ");
        String nombre = vista.SolicitarNombre();
        Jugador jugador = new Jugador(nombre); // instancia del Jugador
        modelo.setJugador(jugador);

        String opcion;
        do {
            vista.menuCombate();
            vista.mostrarMsj("Seleccione una opcion: ");
            opcion = vista.solicitarOpcionCombate();
            switch (opcion) {
                case "1":
                    atacar();
                    break;
                case "2":
                    verInventario();
                    break;
                case "3":
                    usarItem();
                    break;
                case "4":

                    break;
                case "5":
                    vista.interfazCombate(modelo.getJugador(), modelo.getEnemigo());
                    vista.mostrarMsj("Saliendo de combate...");
                    vista.cerrarScanner2();
                    break;
                default:
                    vista.mostrarMsj("Opcion no valida, Vuelva a intentar. ");
            }

        } while (!opcion.equals("5"));
    }
    public void atacar(){
        vista.mostrarMsj("Atacando...\n");
        modelo.jugadorAtaque();
        vista.mostrarMsj("Enemigo contraataca...\n");
        modelo.enemigoAtaque();
        vista.interfazCombate(modelo.getJugador(), modelo.getEnemigo());
    }
    public void verInventario(){
        vista.mostrarMsj("Interfaz Inventario\n");
        modelo.inicarInventarioPlayer();
    }
    public void usarItem(){
        String item;
        vista.mostrarMsj("Equipar Item\n");
        modelo.mostrarItems();
        vista.mostrarMsj("Ingrese Nombre del Item:");
        item = vista.SolicitarNombre();
        switch (item) {
            case "Daga":
                modelo.equipararma(10);
                vista.mostrarMsj("Daga equipada\n");
                vista.interfazCombate(modelo.getJugador(), modelo.getEnemigo());
                break;
            case "Hacha":
                modelo.equipararma(30);
                vista.mostrarMsj("Hacha equipada\n");
                vista.interfazCombate(modelo.getJugador(), modelo.getEnemigo());
                break;
            case "Espada":
                modelo.equipararma(20);
                vista.mostrarMsj("Espada equipada\n");
                vista.interfazCombate(modelo.getJugador(), modelo.getEnemigo());
                break;
            case "PocionA":
                modelo.usarPocion(10);
                vista.mostrarMsj("PocionA equipada\n");
                vista.interfazCombate(modelo.getJugador(), modelo.getEnemigo());
                break;
            case "PocionB":
                modelo.usarPocion(20);
                vista.mostrarMsj("PocionB equipada\n");
                vista.interfazCombate(modelo.getJugador(), modelo.getEnemigo());
                break;
            case "PocionS":
                modelo.usarPocion(30);
                vista.mostrarMsj("Pocionc equipada\n");
                vista.interfazCombate(modelo.getJugador(), modelo.getEnemigo());
                break;
            default:
                vista.mostrarMsj("Error. No existe el item\n");
                break;
        }
    }
}
//System.out.println("1. Atacar");
//        System.out.println("2. Ver inventario");
//        System.out.println("3. Equipar Arma");
//        System.out.println("4. Usar Poción");
//        System.out.println("5. Salir");