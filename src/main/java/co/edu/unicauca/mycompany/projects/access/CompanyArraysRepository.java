package co.edu.unicauca.mycompany.projects.access;

import co.edu.unicauca.mycompany.projects.domain.entities.Company;
import co.edu.unicauca.mycompany.projects.domain.entities.Sector;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación del repositorio con Arreglos
 *
 * @author Libardo, Julio
 */
public class CompanyArraysRepository implements IReadOnlyRepository, IWritableRepository {

    public static List<Company> myArray;

    public CompanyArraysRepository() {
        myArray = new ArrayList<>();
        myArray.add(new Company("012-12-22", "Lacteos Popayan", "313234123", "www.lacteospopayan.com", Sector.SERVICES, "lacteos@example.com", "password123"));
        myArray.add(new Company("323-12-56", "Electromillonaria", "314334334", "www.electromillonaria.com", Sector.TECHNOLOGY, "electro@example.com", "password456"));
    }

    @Override
    public boolean save(Company newCompany) {
        if (!existsNit(newCompany.getNit())) {
            myArray.add(newCompany);
            return true;
        }
        return false;
    }

    @Override
    public List<Company> listAll() {
        return myArray;
    }

    private boolean existsNit(String nit) {
        for (Company company : myArray) {
            if (company.getNit().equals(nit)) {
                return true;
            }
        }
        return false;
    }

}
