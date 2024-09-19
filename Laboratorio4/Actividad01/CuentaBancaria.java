package Actividad01;

public class CuentaBancaria {
    private int numCuenta;
    private String titular;
    private double saldo;

    public CuentaBancaria(int numCuenta, String titular, double saldo) {
        this.numCuenta = numCuenta;
        this.titular = titular;
        validarSaldoInicial(saldo);
        this.saldo = saldo;
        System.out.println("Cuenta creada con exito");
    }
    public void depositar(double monto) {
        validarDeposito(monto);
        this.saldo += monto;
    }
    public void retirar(double monto) throws SaldoInsuficienteException {
        validarRetiro(monto);
        this.saldo -= monto;
    }
//Validaciones
    private void validarSaldoInicial(double saldo) {
        if (saldo < 0) {
            throw new IllegalArgumentException("El saldo no puede ser menor que 0");
        }
    }
    private void validarDeposito(double saldo) {
        if (saldo <= 0) {
            throw new IllegalArgumentException("Error: Monto invalido ");
        }
    }
    private void validarRetiro(double monto) throws SaldoInsuficienteException {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto no puede ser negativo");
        }
        if (monto > this.saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente");
        }
    }
}
