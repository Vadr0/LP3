public class Empleado {
    private String nombre;
    private double salario;
    private String departamento;

    public Empleado(String nombre, double salario, String departamento) {
        this.nombre = nombre;
        this.salario = salario;
        this.departamento = departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSalario() {
        return salario;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}


/////////////////////////////////////////////////////////////////////////////////////////////////


public class CalculadoraPago {
    public double calcularPagoMensual(Empleado empleado) {
        return empleado.getSalario() / 12;
    }
}


//////////////////////////////////////////////////////////////////////////////////////////////////


public class Main {
    public static void main(String[] args) {
        Empleado empleado = new Empleado("Rodrigo Delgado", 120000, "Ingeniería de Sistemas");
        CalculadoraPago calculadoraPago = new CalculadoraPago();

        double pagoMensual = calculadoraPago.calcularPagoMensual(empleado);
        System.out.println("El pago mensual de " + empleado.getNombre() + " es: " + pagoMensual);
    }
}

