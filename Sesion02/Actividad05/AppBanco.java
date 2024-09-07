package Actividad05;

import java.util.Scanner;

public class AppBanco {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Cuenta[] cuentas = new Cuenta[6];
        cuentas[0] = new CuentaAhorros(1000,3);
        cuentas[1] = new CuentaAhorros(2000,3);
        cuentas[2] = new CuentaAhorros(3000,3);
        cuentas[3] = new CuentaCorriente(50);
        cuentas[4] = new CuentaCorriente(300);
        cuentas[5] = new CuentaCorriente(0);

        int opcion;
        do {
            System.out.println("\nMenú:");
            System.out.println("1)Depositar");
            System.out.println("2)Retirar");
            System.out.println("3)Consultar");
            System.out.println("4)Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            //Retiro y deposito
            if (opcion == 1 || opcion == 2) {
                System.out.println("Ingrese una cuenta:");
                int numCuenta = scanner.nextInt();
                System.out.println("Ingrese un monto:");
                double monto = scanner.nextDouble();
                if (opcion ==1) {
                    cuentas[numCuenta].depositar(monto);
                }else if(opcion==2){
                    cuentas[numCuenta].retirar(monto);
                }
            //Consulta
            }else if(opcion == 3) {
                       for(int i = 0; i < cuentas.length; i++) {
                           cuentas[i].consultar();
                       }
            }
        } while (opcion != 4);
    scanner.close();
    }
}
