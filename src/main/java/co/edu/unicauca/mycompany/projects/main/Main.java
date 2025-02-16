
package co.edu.unicauca.mycompany.projects.main;

import co.edu.unicauca.mycompany.projects.access.Factory;
import co.edu.unicauca.mycompany.projects.access.IReadOnlyRepository;
import co.edu.unicauca.mycompany.projects.access.IWritableRepository;
import co.edu.unicauca.mycompany.projects.domain.services.CompanyService;
import co.edu.unicauca.mycompany.projects.presentation.GUIMenu;
import javax.swing.JFrame;


/**
 *
 * @author Libardo Pantoja
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Hacia futuro el tipo de repositorio lo podemos leer de un archivo plano
        // setup.properties, asi no tendriamos que recompilar la aplicación
        Factory factory = Factory.getInstance();
        IReadOnlyRepository readOnlyRepo = factory.getReadOnlyRepository("ARRAYS"); // Podría ser "SQLITE" o "BINARY"
        IWritableRepository writableRepo = factory.getWritableRepository("ARRAYS"); // Podría ser "SQLITE"

        CompanyService service = new CompanyService(readOnlyRepo, writableRepo);
        GUIMenu instance = new GUIMenu(service);
        instance.setExtendedState(JFrame.MAXIMIZED_BOTH);
        instance.setVisible(true);
    }
    
}
