package Ej1;
import java.io.IOException;
public class ProcesadorCaracteres {
 private LeerEntrada lector;
 public ProcesadorCaracteres() {
   this.lector = new LeerEntrada(System.in);
 }
 public void procesar() throws IOException, ExcepcionVocal,
ExcepcionNumero, ExcepcionBlanco, ExcepcionSalida {
   char caracter = lector.getChar();

 if ("aeiouAEIOU".indexOf(caracter) != -1) {
   throw new ExcepcionVocal("Se ha ingresado una
vocal: " + caracter);
 } else if (Character.isDigit(caracter)) {
   throw new ExcepcionNumero("Se ha ingresado un
número: " + caracter);
 } else if (Character.isWhitespace(caracter)) {
   throw new ExcepcionBlanco("Se ha ingresado un
espacio en blanco");
 } else if (caracter == 'q' || caracter == 'Q') {
   throw new ExcepcionSalida("Se ha ingresado el
carácter de salida");
 }
 }
}
