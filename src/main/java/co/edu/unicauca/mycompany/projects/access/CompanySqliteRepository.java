package co.edu.unicauca.mycompany.projects.access;

import co.edu.unicauca.mycompany.projects.domain.entities.Company;
import co.edu.unicauca.mycompany.projects.domain.entities.Sector;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación del repositorio con Sqlite
 *
 * @author Libardo, Julio
 */



public class CompanySqliteRepository implements IReadOnlyRepository, IWritableRepository  {
 // URL de conexión a la base de datos SQLite
 private static final String URL = "jdbc:sqlite:mycompany.db";
    // Constructor que se asegura de inicializar la base de datos
    public CompanySqliteRepository() {
        DatabaseInitializer.initializeDatabase(); // Asegurarse de que la base de datos esté inicializada
    }
    // Implementación del método save() de IWritableRepository
    // Guarda una nueva compañía en la base de datos
    @Override
    public boolean save(Company newCompany) {
        String sql = "INSERT INTO companies(nit, name, phone, web, sector, email, password) VALUES(?,?,?,?,?,?,?)";

        try (Connection connection = DriverManager.getConnection(URL);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, newCompany.getNit());
            statement.setString(2, newCompany.getName());
            statement.setString(3, newCompany.getPhone());
            statement.setString(4, newCompany.getPageWeb());
            statement.setString(5, newCompany.getSector().toString());
            statement.setString(6, newCompany.getEmail());
            statement.setString(7, newCompany.getPassword());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            System.err.println("Error al guardar la empresa: " + e.getMessage());
            return false;
        }
    }
    // Implementación del método listAll() de IReadOnlyRepository
    // Obtiene todas las compañías almacenadas en la base de datos
    @Override
    public List<Company> listAll() {
        List<Company> companies = new ArrayList<>();
        String sql = "SELECT nit, name, phone, web, sector, email, password FROM companies";

        try (Connection connection = DriverManager.getConnection(URL);
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String nit = resultSet.getString("nit");
                String name = resultSet.getString("name");
                String phone = resultSet.getString("phone");
                String web = resultSet.getString("web");
                Sector sector = Sector.valueOf(resultSet.getString("sector"));
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");

                companies.add(new Company(nit, name, phone, web, sector, email, password));
            }

        } catch (SQLException e) {
            System.err.println("Error al listar las empresas: " + e.getMessage());
        }

        return companies;
    }

   
}
