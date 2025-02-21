
package co.edu.unicauca.mycompany.projects.main;

import co.edu.unicauca.mycompany.projects.access.Factory;
import co.edu.unicauca.mycompany.projects.access.IReadOnlyRepository;
import co.edu.unicauca.mycompany.projects.access.IWritableRepository;
import co.edu.unicauca.mycompany.projects.domain.services.CompanyService;
import co.edu.unicauca.mycompany.projects.presentation.GUIMenu;
import javax.swing.JFrame;


/**
 *Clase principal de la aplicación. Se encarga de inicializar los componentes
 * principales y mostrar la interfaz gráfica.
 * 
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Hacia futuro el tipo de repositorio lo podemos leer de un archivo plano
             // La configuración del tipo de repositorio podría almacenarse en un archivo
        // de configuración (setup.properties) para evitar recompilar la aplicación en el futuro.
        Factory factory = Factory.getInstance();
        //IReadOnlyRepository readOnlyRepo = factory.getReadOnlyRepository("ARRAYS"); // Podría ser "SQLITE" o "BINARY"
        //IWritableRepository writableRepo = factory.getWritableRepository("ARRAYS"); // Podría ser "SQLITE"
        IReadOnlyRepository readOnlyRepo = factory.getReadOnlyRepository("SQLITE"); // Usar SQLITE
        IWritableRepository writableRepo = factory.getWritableRepository("SQLITE"); // Usar SQLITE
        
        CompanyService service = new CompanyService(readOnlyRepo, writableRepo);
        GUIMenu instance = new GUIMenu(service);
        instance.setExtendedState(JFrame.MAXIMIZED_BOTH);// Maximiza la ventana al abrirse.
        instance.setVisible(true);// Hace visible la interfaz gráfica.
        
        
    }
    
}
