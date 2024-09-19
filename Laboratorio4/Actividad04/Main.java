package Actividad04;

import java.io.IOException;

public class Main {
    public static void main(String[] args){
        try{
            CuentaBancaria cuenta1 = new CuentaBancaria(501001,"Yhosfer",1200.0);
            CuentaCredito cuenta2 = new CuentaCredito(501002, "Anderson",1000, 2000);

            // Operaciones
            cuenta1.depositar(30);
            cuenta1.retirar(155);
            cuenta2.transferir(300, cuenta1);

            // Generar reportes
            System.out.println("Generando reporte de transacciones...");
            ReporteTransacciones.generarReporte(cuenta1);
            ReporteTransacciones.generarReporte(cuenta2);
            // Leer reportes
            System.out.println("Leyendo reporte de transacciones...");
            ReporteTransacciones.leerReporte();

            // Cerrrar Cuenta
            cuenta2.cerrarCuenta();

        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }catch (SaldoInsuficienteException e){
            System.out.println(e.getMessage());
        }catch (CuentaNoEncontradaException e){
            System.out.println(e.getMessage());
        }catch (SaldoNoCeroException e){
            System.out.println(e.getMessage());
        }catch (LimiteCreditoExcedidoException e) {
            System.out.println(e.getMessage());
        }catch (HistorialVacioException e){
            System.out.println(e.getMessage());
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
