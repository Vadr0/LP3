package Actividad01;

public class Main {
    public static void main(String[] args){
        try{
            CuentaBancaria cuenta1 = new CuentaBancaria(501001,"Yhosfer",1200.0);
            cuenta1.depositar(30);
            cuenta1.retirar(-155);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }catch (SaldoInsuficienteException e){
            System.out.println(e.getMessage());
        }
    }
}
