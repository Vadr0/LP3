package Ej1;
import java.io.IOException;
public class Main {
 public static void main(String[] args) {
 ProcesadorCaracteres procesador = new
ProcesadorCaracteres();

 while (true) {
 try {
 procesador.procesar();
System.out.println("Carácter procesado
correctamente.");
 } catch (ExcepcionVocal e) {
 System.out.println(e.getMessage());
 } catch (ExcepcionNumero e) {
 System.out.println(e.getMessage());
32
 } catch (ExcepcionBlanco e) {
 System.out.println(e.getMessage());
 } catch (ExcepcionSalida e) {
 System.out.println(e.getMessage());
System.out.println("Programa finalizado.");
 break;
 } catch (IOException e) {
 System.out.println("Error de entrada/salida: "
+ e.getMessage());
 break;
 }
 }
 }
}
