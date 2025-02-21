
package co.edu.unicauca.mycompany.projects.access;
import co.edu.unicauca.mycompany.projects.domain.entities.Company;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yisus
 */

//Implementacion de la interfaz IReadOnlyReposiroty.
public class CompanyBinaryRepository implements IReadOnlyRepository{
    
    @Override
    public List<Company> listAll() {
        // Implementar la lógica para leer desde un archivo binario
        // Ejemplo: Leer un archivo .dat y retornar la lista de empresas
        return new ArrayList<>(); // Retornar la lista de empresas
    }
}
