package Actividad01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class actividad {
    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:Actividad01\\ejemplo1.db");
            if (con != null) {
                System.out.println("Conexion exitosa");
            }
            Statement st = con.createStatement();

            st.execute("CREATE TABLE IF NOT EXISTS empleado (id integer PRIMARY KEY , name text, age integer);");
            System.out.println("Creación de  table empleado exitosa");

            st.execute("insert into empleado VALUES (1,'Carlos',11)");
            st.execute("insert into empleado VALUES (2,'Juan',22)");
            System.out.println("Inseción exitosa");
            System.out.println("Lista de empleados:");
            ResultSet rs = st.executeQuery("select * from empleado");

            System.out.printf("%-3s %-10s %-5s\n","ID","Nombre","Edad");
            while (rs.next())
                System.out.printf("%-3d %-10s %-5d\n",rs.getInt(1),rs.getString(2), rs.getInt(3));

            System.out.println("Borrando empleado Carlos");
            String sql = "DELETE FROM empleado WHERE id = 1";
            st.execute(sql);
            System.out.println("Nueva lista de Empleados:");
            ResultSet rs1 = st.executeQuery("select * from empleado");

            System.out.printf("%-3s %-10s %-5s\n","ID","Nombre","Edad");
            while (rs.next())
                System.out.printf("%-3d %-10s %-5d\n",rs.getInt(1),rs.getString(2), rs.getInt(3));

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
