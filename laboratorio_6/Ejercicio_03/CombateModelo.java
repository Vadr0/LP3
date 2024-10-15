package Ejercicio_03;

public class CombateModelo {
    private int turno;
    private Jugador jugador;
    private Enemigo enemigo;
    public CombateModelo() {
        turno = 0;
        jugador = null;
        enemigo = null;
    }
    public CombateModelo(Jugador jugador, Enemigo enemigo) {
        this.jugador = jugador;
        this.enemigo = enemigo;
        this.turno = 1;
    }
    public int getTurno() {
        return turno;
    }
    public void siguienteTurno() {
        turno++;
    }
    // getters y setters
    public Jugador getJugador() {
        return jugador;
    }
    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
    public Enemigo getEnemigo() {
        return enemigo;
    }
    public void setEnemigo(Enemigo enemigo) {
        this.enemigo = enemigo;
    }
    // fin getters y setters
    // ataque del jugador hacia el enemigo
    public void jugadorAtaque() {
        enemigo.recibirDamage(jugador.getDanio());
    }
    // ataque del enemigo
    public void enemigoAtaque() {
        jugador.recibirDamge(enemigo.getAtaque());
    }
    public void equipararma(int damage) {
        jugador.equiparArma(damage);
    }
    public void usarPocion(int pocion) {
        jugador.usarPocion(pocion);
    }
    public void mostrarItems() {
        jugador.listaItems();
    }
    public void inicarInventarioPlayer() {
        jugador.usarInventario();
    }
}
