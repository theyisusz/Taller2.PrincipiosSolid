package co.edu.unicauca.mycompany.projects.domain.services;
import co.edu.unicauca.mycompany.projects.access.IReadOnlyRepository;
import co.edu.unicauca.mycompany.projects.access.IWritableRepository;
import co.edu.unicauca.mycompany.projects.domain.entities.Company;
import java.util.List;

/**
 *
 * @author Libardo Pantoja, Julio Hurtado
 */
public class CompanyService {

    // Dependencias para operaciones de solo lectura y escritura en el repositorio
    private IReadOnlyRepository readOnlyRepository;
    private IWritableRepository writableRepository;

    /**
     * Constructor de CompanyService que recibe repositorios de lectura y escritura.
     * @param readOnlyRepository Repositorio para operaciones de solo lectura.
     * @param writableRepository Repositorio para operaciones de escritura.
     */
    public CompanyService(IReadOnlyRepository readOnlyRepository, IWritableRepository writableRepository) {
        this.readOnlyRepository = readOnlyRepository;
        this.writableRepository = writableRepository;
    }

    /**
     * Obtiene la lista de todas las empresas registradas en el sistema.
     * @return Lista de objetos Company.
     */
    public List<Company> getAllCompanies() {
        return readOnlyRepository.listAll();
    }

    /**
     * Guarda una nueva empresa en el sistema.
     * @param newCompany Objeto Company a guardar.
     * @return true si la empresa se guardó exitosamente, false en caso contrario.
     */
    public boolean saveCompany(Company newCompany) {
        return writableRepository.save(newCompany);
    }

}
