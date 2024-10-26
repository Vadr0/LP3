package Ejercicio02;

import Ejercicio01.BDApp;

import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class GestorPersonas {
    private BDApp app;
    private List<Persona> personas;
    private Scanner sc;

    public GestorPersonas() {
        app = new BDApp();
        personas = new ArrayList<>();
        sc = new Scanner(System.in);
        cargarPersonasBD();
    }
    private void cargarPersonasBD() {
        // Instrucción SQL
        String sql = "select * FROM personas";
        /*  Se establece la conexión con la base de datos,
            crea una sentencia (statement) y
            cierra la conexión  */
        try (Connection con = app.crearConexion(); Statement st = con.createStatement()) {
            // Tabla de datos que representa un conjunto de datos de la BD
            ResultSet rs = st.executeQuery(sql);
            // recorre cada fila
            while (rs.next()) {
                // se obtiene los valores de las columnas
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                int edad = rs.getInt("edad");
                String ciudad = rs.getString("ciudad");

                // Agregar cada registro a la lista de personas
                personas.add(new Persona(id, nombre, edad, ciudad));
            }

        } catch (SQLException e) {
            System.out.println("Error: "+e.getMessage());
        }
    }

    public void mostrarPersonas(String campo, String condicion, boolean ascendente, int limite) {
        List<Persona> resultados = personas.stream()
                .filter(persona -> condicion == null || persona.cumpleCondicion(campo, condicion))
                .sorted(getComparator(campo, ascendente))
                .limit(limite > 0 ? limite : personas.size())
                .collect(Collectors.toList());

        resultados.forEach(System.out::println);
    }

    private Comparator<Persona> getComparator(String campo, boolean ascendente) {
        Comparator<Persona> comparator = switch (campo) {
            case "nombre" -> Comparator.comparing(Persona::getNombre);
            case "edad" -> Comparator.comparingInt(Persona::getEdad);
            case "ciudad" -> Comparator.comparing(Persona::getCiudad);
            default -> Comparator.comparingInt(Persona::getId);
        };
        return ascendente ? comparator : comparator.reversed();
    }

    public void iniciarGestor() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el campo para ordenar (id, nombre, edad, ciudad): ");
        String campo = scanner.nextLine().trim();

        System.out.print("Ingrese una condición de filtro (o dejar en blanco para no aplicar condición): ");
        String condicion = scanner.nextLine().trim();
        if (condicion.isEmpty()) condicion = null;

        System.out.print("¿Desea ordenar ascendente? (true/false): ");
        boolean ascendente = scanner.nextBoolean();

        System.out.print("Ingrese el límite de registros a mostrar (0 para sin límite): ");
        int limite = scanner.nextInt();

        mostrarPersonas(campo, condicion, ascendente, limite);
        scanner.close();
    }
}