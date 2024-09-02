package Actividad05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Cuenta {
    protected double saldo;

    public Cuenta(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void depositar(double cantidad) {
        saldo += cantidad;
    }

    public void retirar(double cantidad) {
        if (cantidad <= saldo) {
            saldo -= cantidad;
        } else {
            System.out.println("Saldo insuficiente para realizar el retiro.");
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public abstract void consultar(); // Método abstracto a ser implementado por subclases
}

class CuentaAhorro extends Cuenta {
    private double tasaInteres;
    private double minSaldoMens;

    public CuentaAhorro(double saldoInicial, double tasaInteres) {
        super(saldoInicial);
        this.tasaInteres = tasaInteres;
        this.minSaldoMens = saldoInicial;
    }

    @Override
    public void retirar(double cantidad) {
        super.retirar(cantidad);
        if (saldo < minSaldoMens) {
            minSaldoMens = saldo;
        }
    }

    @Override
    public void consultar() {
        double interes = minSaldoMens * tasaInteres;
        depositar(interes);
        System.out.println("Intereses capitalizados. Nuevo saldo: " + getSaldo());
        minSaldoMens = saldo; // Reinicia el saldo mínimo mensual
    }
}

class CuentaCorriente extends Cuenta {
    private int contadorRetiros;
    private static final int RETIROS_GRATUITOS = 3;
    private static final double TARIFA_TRANSACCION = 3.0;

    public CuentaCorriente(double saldoInicial) {
        super(saldoInicial);
        this.contadorRetiros = 0;
    }

    @Override
    public void retirar(double cantidad) {
        if (contadorRetiros >= RETIROS_GRATUITOS) {
            cantidad += TARIFA_TRANSACCION;
        }
        super.retirar(cantidad);
        contadorRetiros++;
    }

    @Override
    public void consultar() {
        contadorRetiros = 0; // Reinicia el contador de retiros
        System.out.println("Contador de retiros reiniciado. Saldo actual: " + getSaldo());
    }
}

public class BancoApp {
    public static void main(String[] args) {
        List<Cuenta> cuentas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        cuentas.add(new CuentaAhorro(1000.0, 0.02));
        cuentas.add(new CuentaCorriente(500.0));
        cuentas.add(new CuentaAhorro(1500.0, 0.03));

        int opcion;
        do {
            System.out.println("\nMenú:");
            System.out.println("1)Depositar");
            System.out.println("2)Retirar");
            System.out.println("3)Consultar");
            System.out.println("4)Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Número de cuenta: ");
                    int cuentaDepositar = scanner.nextInt();
                    System.out.print("Monto a depositar: ");
                    double montoDeposito = scanner.nextDouble();
                    if (cuentaDepositar >= 0 && cuentaDepositar < cuentas.size()) {
                        cuentas.get(cuentaDepositar).depositar(montoDeposito);
                        System.out.println("Nuevo saldo: " + cuentas.get(cuentaDepositar).getSaldo());
                    } else {
                        System.out.println("Número de cuenta inválido.");
                    }
                    break;
                case 2:
                    System.out.print("Número de cuenta: ");
                    int cuentaRetirar = scanner.nextInt();
                    System.out.print("Monto a retirar: ");
                    double montoRetiro = scanner.nextDouble();
                    if (cuentaRetirar >= 0 && cuentaRetirar < cuentas.size()) {
                        cuentas.get(cuentaRetirar).retirar(montoRetiro);
                        System.out.println("Nuevo saldo: " + cuentas.get(cuentaRetirar).getSaldo());
                    } else {
                        System.out.println("Número de cuenta inválido.");
                    }
                    break;
                case 3:
                    for (int i = 0; i < cuentas.size(); i++) {
                        System.out.println("Cuenta " + i + ":");
                        cuentas.get(i).consultar();
                    }
                    break;
                case 4:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 4);

        scanner.close();
    }
}
