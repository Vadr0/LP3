package Actividad04;

public class Actividad04 {
    public static void main(String[] args) {

        Persona persona1 = new Persona(1, "Juan", "Perez", 12345, 1000.0);

        System.out.println(persona1.toString());

        persona1.getCuenta().depositar(500.0);
        System.out.println("Después de depositar 500.0: " + persona1.toString());

        persona1.getCuenta().retirar(200.0);
        System.out.println("Después de retirar 200.0: " + persona1.toString());

        persona1.getCuenta().retirar(2000.0); // Intentar retirar más del saldo disponible
    }
    public static class Persona {
        private int id;
        private String nombre;
        private String apellido;
        private Cuenta cuenta; // Composición con la clase Cuenta

        public Persona(int id, String nombre, String apellido, int numeroCuenta, double saldo) {
            this.id = id;
            this.nombre = nombre;
            this.apellido = apellido;
            this.cuenta = new Cuenta(numeroCuenta, saldo); // Se crea un objeto de la clase Cuenta
        }

        // Getters y setters
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        public Cuenta getCuenta() {
            return cuenta;
        }

        public void setCuenta(Cuenta cuenta) {
            this.cuenta = cuenta;
        }

        @Override
        public String toString() {
            return "Persona [ID=" + id + ", Nombre=" + nombre + " " + apellido + ", " + cuenta.toString() + "]";
        }
    }

    public static class Cuenta {
        private int numero;
        private double saldo;

        public Cuenta(int numero, double saldo) {
            this.numero = numero;
            this.saldo = saldo;
        }

        // Constructor sobrecargado para inicializar sin saldo
        public Cuenta(int numero) {
            this(numero, 0.0); // Llama al constructor principal con saldo cero
        }

        // Getters y setters
        public int getNumero() {
            return numero;
        }

        public void setNumero(int numero) {
            this.numero = numero;
        }

        public double getSaldo() {
            return saldo;
        }

        public void setSaldo(double saldo) {
            if (saldo >= 0) {
                this.saldo = saldo;
            } else {
                System.out.println("El saldo no puede ser negativo.");
            }
        }

        public void depositar(double cantidad) {
            if (cantidad > 0) {
                saldo += cantidad;
            } else {
                System.out.println("La cantidad a depositar debe ser positiva.");
            }
        }

        public void retirar(double cantidad) {
            if (cantidad > 0 && cantidad <= saldo) {
                saldo -= cantidad;
            } else {
                System.out.println("Fondos insuficientes o cantidad no válida.");
            }
        }

        @Override
        public String toString() {
            return "Cuenta [Número de Cuenta=" + numero + ", Saldo=" + saldo + "]";
        }
    }
}
