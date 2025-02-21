/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.mycompany.projects.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author RoLoNeGaTiVo
 */
public class DatabaseInitializer {
    // URL de conexión a la base de datos SQLite
    private static final String URL = "jdbc:sqlite:mycompany.db";
     // Método estático que inicializa la base de datos creando la tabla si no existe
    public static void initializeDatabase() {
        try (Connection connection = DriverManager.getConnection(URL);
             Statement statement = connection.createStatement()) {

            // Crear la tabla companies si no existe
            String sql = "CREATE TABLE IF NOT EXISTS companies (" +
                    "nit TEXT PRIMARY KEY, " +
                    "name TEXT NOT NULL, " +
                    "phone TEXT, " +
                    "web TEXT, " +
                    "sector TEXT NOT NULL, " +
                    "email TEXT NOT NULL, " +
                    "password TEXT NOT NULL)";
            statement.execute(sql);

        } catch (SQLException e) {
            System.err.println("Error al inicializar la base de datos: " + e.getMessage());
        }
    }
}
