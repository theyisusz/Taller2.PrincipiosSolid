/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.unicauca.mycompany.projects.access;
import co.edu.unicauca.mycompany.projects.domain.entities.Company;
/**
 *
 * @author Yisus
 */
public interface IWritableRepository {
    boolean save(Company newCompany);
}
