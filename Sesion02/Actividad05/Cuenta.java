package Actividad05;

public abstract class Cuenta {
    protected double saldo;

    public Cuenta(double saldo) {
        this.saldo = saldo;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    @Override
    public String toString() {
        return "saldo = " + saldo;
    }
    public void depositar(double monto) {
        this.saldo += monto;
    }
    public void retirar(double monto) {
        if (monto < this.saldo){
            this.saldo -= monto;
        } else {
            System.out.println("El saldo insuficiente para realizar el retiro.");
        }
    }
    public abstract void consultar();

}
