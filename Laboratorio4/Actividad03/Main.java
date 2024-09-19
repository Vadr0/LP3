package Actividad03;

public class Main {
    public static void main(String[] args){
        try{

            CuentaBancaria cuenta1 = new CuentaBancaria(501001,"Yhosfer",1200.0);
            cuenta1.depositar(30);
            cuenta1.retirar(155);
            CuentaCredito cuenta2 = new CuentaCredito(501002, "Anderson",1000, 2000);
            cuenta2.transferir(300, cuenta1);
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
        }
    }
}
