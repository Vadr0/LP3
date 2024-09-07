package Actividad04;

public class Persona{
    private int id;
    private String nombre;
    private String apellido;
    private Cuenta cuenta;

    public Persona(int id, String n, String a, int numCuenta){
        this.id = id;
        this.nombre = n;
        this.apellido = a;
        this.cuenta = new Cuenta(numCuenta);
    }
    public Persona(int id, String n, String a, int numCuenta, double saldo){
        this.id = id;
        this.nombre = n;
        this.apellido = a;
        this.cuenta = new Cuenta(numCuenta, saldo);
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getApellido(){
        return apellido;
    }
    public void setApellido(String apellido){
        this.apellido = apellido;
    }
    public Cuenta getCuenta(){
        return cuenta;
    }
    public void setCuenta(Cuenta cuenta){
        this.cuenta = cuenta;
    }
    @Override
    public String toString(){
        return "Id: "+ id + "\nNombre: "+nombre + "\nApellido: "
                +apellido + "\nCuenta: "+cuenta;
    }
}
