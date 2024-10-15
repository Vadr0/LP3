package Ejercicio_03;

public class Enemigo {
    private String nombre;
    private int vida;
    private int ataque;

    public Enemigo(String nombre) {
        this.nombre = nombre;
        this.vida = 100;
        this.ataque = 20;
    }
    public String getNombre() {
        return nombre;
    }
    public int getVida() {
        return vida;
    }
    public int getAtaque() {
        return ataque;
    }
    public void recibirDamage(int damage) {
        vida -= damage;
    }
}
