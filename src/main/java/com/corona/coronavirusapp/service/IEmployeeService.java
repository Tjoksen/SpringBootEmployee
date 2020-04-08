package com.corona.coronavirusapp.service;


import com.corona.coronavirusapp.RecordNotFoundException;
import com.corona.coronavirusapp.model.EmployeeEntity;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IEmployeeService  {
    /**
     * Get All Planets.
     * @return List of all planets.
     */
    List<EmployeeEntity> getAllEmployees();
    /**
     * Get Planet By Id.
     * @param id Id
     * @return Planet
     */
    EmployeeEntity getEmployeeById(Long id) throws RecordNotFoundException;
    /**
     * Save Planet.
     * @param planet Planet to save
     * @return Saved Planet
     */
    EmployeeEntity saveEmployee(EmployeeEntity planet);
    /**
     * Update Planet.
     * @param id Id
     * @param planetToUpdate Planet to Update
     * @return Updated Planet
     */
    EmployeeEntity updateEmployeeById(Long id, EmployeeEntity planetToUpdate) throws RecordNotFoundException;
    /**
     * Delete Planet by Id.
     * @param id Id
     */
    void deleteEmployeeId(Long id) throws RecordNotFoundException;
    /**
     * Search Planet by name containing.
     * @param searchString SearchString
     * @return Search result
     */
    List<EmployeeEntity> getEmployeeByNameContaining(String searchString);
    /**
     * Search Planet by name like.
     * @param searchString SearchString
     * @return Search result
     */
    List<EmployeeEntity> getEmployeeByNameLike(String searchString);
}
