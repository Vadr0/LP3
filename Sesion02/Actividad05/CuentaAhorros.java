package Actividad05;

public class CuentaAhorros extends Cuenta{
    private double tasaInteres ;
    private double minSaldoMes;

    public CuentaAhorros(double saldoInicial, double tasaInteres){
        super(saldoInicial);
        this.minSaldoMes = saldoInicial;
        this.tasaInteres = tasaInteres;
    }
    @Override
    public void retirar(double monto) {
        super.retirar(monto);
        if (this.saldo < minSaldoMes) {
            minSaldoMes = this.saldo;
        }
    }

    @Override
    public void consultar() {
        double interes = minSaldoMes * tasaInteres/100;
        depositar(interes);
        System.out.println("Interess capitalizados. Nuevo Saldo: " + this.saldo);
        // Reinicia el saldo mínimo mensual
        minSaldoMes = this.saldo;
    }
}
