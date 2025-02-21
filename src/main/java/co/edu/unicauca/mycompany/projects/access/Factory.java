package co.edu.unicauca.mycompany.projects.access;

import java.util.HashMap;
import java.util.Map;

/**
 * Fabrica que se encarga de instanciar ProductRepository o cualquier otro que
 * se cree en el futuro.
 *
 * @author Libardo, Julio
 */
public class Factory {

    private static Factory instance; // Instancia única de la fábrica (Singleton)
    // Mapas para almacenar los repositorios de solo lectura y de escritura
    private Map<String, IReadOnlyRepository> readOnlyRepositories;
    private Map<String, IWritableRepository> writableRepositories;

    // Constructor privado para evitar la instanciación externa
    private Factory() {
        readOnlyRepositories = new HashMap<>();
        writableRepositories = new HashMap<>();

        CompanyArraysRepository arraysRepo = new CompanyArraysRepository();
        readOnlyRepositories.put("ARRAYS", arraysRepo);
        writableRepositories.put("ARRAYS", arraysRepo);

        CompanySqliteRepository sqliteRepo = new CompanySqliteRepository();
        readOnlyRepositories.put("SQLITE", sqliteRepo);
        writableRepositories.put("SQLITE", sqliteRepo);
    }

    // Método estático para obtener la única instancia de la fábrica (Singleton)
    public static Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    // Método para obtener un repositorio de solo lectura basado en su identificador
    public IReadOnlyRepository getReadOnlyRepository(String repository) {
        return readOnlyRepositories.get(repository);
    }
    
    // Método para obtener un repositorio con capacidad de escritura basado en su identificador
    public IWritableRepository getWritableRepository(String repository) {
        return writableRepositories.get(repository);
    }

}
