/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.mycompany.projects.access;
import co.edu.unicauca.mycompany.projects.domain.entities.Company;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yisus
 */
public class CompanyBinaryRepository implements IReadOnlyRepository{
    
    @Override
    public List<Company> listAll() {
        // Implementar la lógica para leer desde un archivo binario
        // Ejemplo: Leer un archivo .dat y retornar la lista de empresas
        return new ArrayList<>(); // Retornar la lista de empresas
    }
}
