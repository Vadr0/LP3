package Actividad02;

public class Main {
    public static void main(String[] args){
        try{

            CuentaBancaria cuenta1 = new CuentaBancaria(501001,"Yhosfer",1200.0);
            cuenta1.depositar(30);
            cuenta1.retirar(155);
            CuentaBancaria cuenta2 = new CuentaBancaria(501002, "Anderson",1000);
            cuenta1.transferir(300, cuenta2);
            cuenta1.cerrarCuenta();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }catch (SaldoInsuficienteException e){
            System.out.println(e.getMessage());
        }catch (CuentaNoEncontradaException e){
            System.out.println(e.getMessage());
        }catch (SaldoNoCeroException e){
            System.out.println(e.getMessage());
        }
    }
}
