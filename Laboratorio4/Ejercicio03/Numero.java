package Ejercicio03;

public class Numero {
    private double valor;
    public Numero(double valor) {
        this.validarValor(valor);
        this.valor = valor;
        System.out.println("Objeto de tipo Numero creado con éxito");
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        validarValor(valor);
        this.valor = valor;
    }
    // Método para validar el valor ingresado
    private void validarValor(double valor){
        if(valor<0){
            throw new IllegalArgumentException("Valor no puede ser negativo");
        }
    }
}
