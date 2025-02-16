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

    private IReadOnlyRepository readOnlyRepository;
    private IWritableRepository writableRepository;

    public CompanyService(IReadOnlyRepository readOnlyRepository, IWritableRepository writableRepository) {
        this.readOnlyRepository = readOnlyRepository;
        this.writableRepository = writableRepository;
    }

    public List<Company> getAllCompanies() {
        return readOnlyRepository.listAll();
    }

    public boolean saveCompany(Company newCompany) {
        return writableRepository.save(newCompany);
    }

}
