package Actividad04;

public class CuentaBancaria {
    protected int numCuenta;
    protected String titular;
    protected double saldo;
    protected boolean activo;

    public CuentaBancaria(int numCuenta, String titular, double saldo) {
        this.numCuenta = numCuenta;
        this.titular = titular;
        if (saldo < 0) {
            throw new IllegalArgumentException("El saldo no puede ser menor que 0");
        }
        this.saldo = saldo;
        this.activo = true;
        System.out.println("Cuenta creada con exito");
    }
    public void depositar(double monto) {
        if (this.activo) {
            if (monto <= 0) {
                throw new IllegalArgumentException("Error: Monto invalido ");
            }
            this.saldo += monto;
        } else {
            System.out.println("Cuenta cerrada.");
        }
    }
    public void retirar(double monto) throws SaldoInsuficienteException, LimiteCreditoExcedidoException {
        if (this.activo) {
            if (monto <= 0) {
                throw new IllegalArgumentException("El monto no puede ser negativo");
            }
            if (monto > this.saldo) {
                throw new SaldoInsuficienteException("Saldo insuficiente");
            }
            this.saldo -= monto;
        } else {
            System.out.println("Cuenta cerrada.");
        }
    }
    public void transferir(double monto, CuentaBancaria cuentaBancaria) throws CuentaNoEncontradaException, SaldoInsuficienteException, LimiteCreditoExcedidoException {
        if (cuentaBancaria.getActivo()) {
            this.retirar(monto);
            cuentaBancaria.depositar(monto);
        } else {
            throw new CuentaNoEncontradaException("Cuenta no encontrada");
        }
    }
    public void cerrarCuenta() throws SaldoNoCeroException {
        if (this.saldo > 0){
            throw new SaldoNoCeroException("Error: No se puede cerrar cuenta "+ this.numCuenta+", saldo: "+this.saldo);
        }
    }

    public boolean getActivo() {
        return this.activo;
    }
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    public double getSaldo() {
        return this.saldo;
    }
}
