package Actividad05;

public class CuentaCorriente extends Cuenta {
    private int contadorRetiros;
    private final int RETIROS_FREE = 3;
    private final double TARIFA_TRANSACCION = 3.5;


    public CuentaCorriente(double saldoInicial) {
        super(saldoInicial);
        this.contadorRetiros = 0;
    }
    @Override
    public void retirar(double monto) {
        if (contadorRetiros >= RETIROS_FREE) {
            monto += TARIFA_TRANSACCION;
        }
        super.retirar(monto);
        contadorRetiros++;
    }
    @Override
    public void consultar() {
        contadorRetiros = 0;
        System.out.println("Contador de retiros reiniciado. Saldo actual: " + this.saldo);
    }
}
