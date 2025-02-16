package co.edu.unicauca.mycompany.projects.domain.services;

import co.edu.unicauca.mycompany.projects.access.IReadOnlyRepository;
import co.edu.unicauca.mycompany.projects.access.IWritableRepository;
import co.edu.unicauca.mycompany.projects.domain.entities.Company;
import co.edu.unicauca.mycompany.projects.domain.entities.Sector;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

/**
 * Pruebas unitarias para la clase CompanyService.
 */
public class CompanyServiceTest {

    @Mock
    IReadOnlyRepository readOnlyRepositoryMock; // Mock para el repositorio de solo lectura

    @Mock
    IWritableRepository writableRepositoryMock; // Mock para el repositorio de escritura

    private CompanyService companyService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializa los mocks
        companyService = new CompanyService(readOnlyRepositoryMock, writableRepositoryMock); // Inyección de los mocks
    }

    @Test
    void testGetAllCompanies() {
        // Simulación de datos
        List<Company> companies = Arrays.asList(
            new Company("123456", "Empresa A", "3434343", "www.mipagina1.com", Sector.SERVICES, "gerente1@gmail.com", "123"),
            new Company("123457", "Empresa B", "3434344", "www.mipagina2.com", Sector.SERVICES, "gerente2@gmail.com", "123"),
            new Company("123458", "Empresa C", "3434345", "www.mipagina3.com", Sector.SERVICES, "gerente3@gmail.com", "123")
        );

        // Configurar el comportamiento del mock de solo lectura
        when(readOnlyRepositoryMock.listAll()).thenReturn(companies);

        // Llamado al método
        List<Company> result = companyService.getAllCompanies();

        // Verificación
        assertNotNull(result);
        assertEquals(3, result.size());
        assertEquals("Empresa A", result.get(0).getName());
        assertEquals("Empresa B", result.get(1).getName());

        // Verifica que listAll() fue llamado una vez
        verify(readOnlyRepositoryMock, times(1)).listAll();
    }

    @Test
    void testSaveCompany_Success() {
        // Crear una nueva empresa
        Company newCompany = new Company("123459", "Empresa D", "3434345", "www.mipagina4.com", Sector.SERVICES, "gerente4@gmail.com", "123");

        // Configurar el comportamiento del mock de escritura
        when(writableRepositoryMock.save(newCompany)).thenReturn(true); // Simula éxito

        // Llamado al método
        boolean result = companyService.saveCompany(newCompany);

        // Verificación
        assertTrue(result);
        verify(writableRepositoryMock, times(1)).save(newCompany);
    }

    @Test
    void testSaveCompany_Failure() {
        // Crear una nueva empresa
        Company newCompany = new Company("123459", "Empresa D", "3434345", "www.mipagina4.com", Sector.SERVICES, "gerente4@gmail.com", "123");

        // Configurar el comportamiento del mock de escritura
        when(writableRepositoryMock.save(newCompany)).thenReturn(false); // Simula fallo

        // Llamado al método
        boolean result = companyService.saveCompany(newCompany);

        // Verificación
        assertFalse(result);
        verify(writableRepositoryMock, times(1)).save(newCompany);
    }
}