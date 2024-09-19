package Actividad03;


public class CuentaCredito extends CuentaBancaria {
    private double limiteCredito;

    public CuentaCredito(int numCuenta,String titular, double saldo, double limiteCredito) {
        super(numCuenta,titular,saldo);
        this.limiteCredito = limiteCredito;
    }
    @Override
    public void retirar(double monto) throws LimiteCreditoExcedidoException {
        if (monto <= 0) {
            throw new IllegalArgumentException("Monto no puede ser negativo");
        }
        verificarLimiteCredito(monto);
        this.saldo -= monto;
        System.out.println("Retiro exitoso, Nuevo saldo: "+this.saldo);
    }
    public void transferencia(double monto, CuentaBancaria cuenta) throws LimiteCreditoExcedidoException {
        if (monto <= 0) {
            throw new IllegalArgumentException("Monto no puede ser negativo");
        }
        verificarLimiteCredito(monto);
        this.retirar(monto);
        cuenta.depositar(monto);
        System.out.println("Transferencia realizada exitosa");
    }

    private void verificarLimiteCredito(double monto) throws LimiteCreditoExcedidoException {
        if (monto > this.limiteCredito + this.saldo) {
            throw new LimiteCreditoExcedidoException("Exceso de limite de Credito");
        }
    }
}
