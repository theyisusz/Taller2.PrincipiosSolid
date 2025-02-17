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

    private static Factory instance;
    private Map<String, IReadOnlyRepository> readOnlyRepositories;
    private Map<String, IWritableRepository> writableRepositories;

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

    public static Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    public IReadOnlyRepository getReadOnlyRepository(String repository) {
        return readOnlyRepositories.get(repository);
    }

    public IWritableRepository getWritableRepository(String repository) {
        return writableRepositories.get(repository);
    }

}
