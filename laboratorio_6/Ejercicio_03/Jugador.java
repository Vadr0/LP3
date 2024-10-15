package Ejercicio_03;


import Ejercicio_02.InventarioControlador;
public class Jugador{
    private String nombre;
    private int vida;
    private int damage;
    private InventarioControlador inventario;
    public Jugador(String nombre){
        this.nombre = nombre;
        this.vida = 100;
        this.damage = 5;
        this.inventario = new InventarioControlador();
    }
    public String getNombre() {
        return nombre;
    }
    public int getVida() {
        return vida;
    }
    public int getDanio() {
        return this.damage;
    }
    public void usarInventario() {
        inventario.iniciar();
    }
    public void equiparArma(int damage){
        this.damage += damage;
    }
    public void usarPocion(int pocion){
        this.vida += pocion;
    }
    public void recibirDamge(int damage){
        this.vida -= damage;
    }
    public void listaItems(){
        inventario.verInventarioDefaul();
    }
    public void usarItem(){
        inventario.buscarItem();
    }
}
