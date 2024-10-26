package Ejercicio01;

import java.sql.*;
import java.util.Scanner;

public class BDApp {
    public static void registrarClaseControlador(){
        try {
            // registrar el controlador de clase
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: "+e.getMessage());
        }
    }
    public static Connection crearConexion() {
        String url = "jdbc:sqlite:Ejercicio01\\mi_base.db";
        Connection conn = null;
        try {
            // intenta establecer conexión con la url
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println("Error: "+e.getMessage());
        }
        return conn;
    }

    private static void crearTablaPersonas() {
        // Instrucción SQL que creara una Tabla si no existe en la DB
        String sql = "CREATE TABLE IF NOT EXISTS personas (\n"
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + " nombre TEXT NOT NULL,\n"
                + " edad INTEGER,\n"
                + " ciudad TEXT\n"
                + ");";
        /*  Se establece la conexión con la base de datos,
            crea una sentencia (statement) y
            cierra la conexión  */
        try (Connection conn = crearConexion(); Statement stmt = conn.createStatement()) {
            stmt.execute(sql); // ejecuta la instrucción SQL
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void insertarRegistros(String nombre, int edad, String ciudad) {
        // Instrucción parametrizada SQL
        String sql = "INSERT INTO personas(nombre, edad, ciudad) VALUES(?, ?, ?)";
        /*  Se establece la conexión con la base de datos,
            crea una sentencia parametrizada (PreparedStatement) y
            cierra la conexión  */
        try (Connection conn = crearConexion(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // se estableces los valores en el indice de los párametros especificados
            pstmt.setString(1, nombre);
            pstmt.setInt(2, edad);
            pstmt.setString(3, ciudad);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void mostrarRegistros() {
        String sql = "SELECT * FROM personas";
        try (Connection conn = crearConexion(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" + rs.getString("nombre") + "\t" + rs.getInt("edad") + "\t" + rs.getString("ciudad"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void borrarRegistro(int id) {
        // Instrucción parametrizada SQL
        String sql = "DELETE FROM personas WHERE id = ?";
        /*  Se establece la conexión con la base de datos,
            crea una sentencia parametrizada (PreparedStatement) y
            cierra la conexión  */
        try (Connection conn = crearConexion(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // se estableces los valores en el indice de los párametros especificados
            pstmt.setInt(1, id);
            pstmt.executeUpdate(); // Ejecuta la consulta
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void actualizarRegristro(int id, String nombre, int edad, String ciudad) {
        // Instrucción parametrizada SQL
        String sql = "UPDATE personas SET nombre = ?, edad = ?, ciudad = ? WHERE id = ?";
        /*  Se establece la conexión con la base de datos,
            crea una sentencia parametrizada (PreparedStatement) y
            cierra la conexión  */
        try (Connection conn = crearConexion(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // se estableces los valores en el indice de los párametros especificados
            pstmt.setString(1, nombre);
            pstmt.setInt(2, edad);
            pstmt.setString(3, ciudad);
            pstmt.setInt(4, id);
            pstmt.executeUpdate();  // Ejecuta la consulta
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        registrarClaseControlador(); // registrar el controlador de clase

        crearTablaPersonas();

        System.out.println("Ingresa la clave para continuar:");
        String clave = sc.nextLine();

        if (!clave.equals("1234")) {
            System.out.println("Clave incorrecta, operación cancelada.");
            return;
        }

        int opcion;
        do {
            System.out.println("\n1. Ingresar");
            System.out.println("2. Mostrar");
            System.out.println("3. Borrar");
            System.out.println("4. Actualizar");
            System.out.println("5. Salir");
            opcion = sc.nextInt();
            sc.nextLine();  // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.println("Nombre:");
                    String nombre = sc.nextLine();
                    System.out.println("Edad:");
                    int edad = sc.nextInt();
                    sc.nextLine();  // limpiar buffer
                    System.out.println("Ciudad:");
                    String ciudad = sc.nextLine();
                    insertarRegistros(nombre, edad, ciudad);
                    break;
                case 2:
                    mostrarRegistros();
                    break;
                case 3:
                    System.out.println("ID a borrar:");
                    int idBorrar = sc.nextInt();
                    borrarRegistro(idBorrar);
                    break;
                case 4:
                    System.out.println("ID a actualizar:");
                    int idActualizar = sc.nextInt();
                    sc.nextLine();  // limpiar buffer
                    System.out.println("Nuevo nombre:");
                    String nuevoNombre = sc.nextLine();
                    System.out.println("Nueva edad:");
                    int nuevaEdad = sc.nextInt();
                    sc.nextLine();  // limpiar buffer
                    System.out.println("Nueva ciudad:");
                    String nuevaCiudad = sc.nextLine();
                    actualizarRegristro(idActualizar, nuevoNombre, nuevaEdad, nuevaCiudad);
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != 5);
    }
}
