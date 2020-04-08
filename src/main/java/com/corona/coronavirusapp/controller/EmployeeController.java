package com.corona.coronavirusapp.controller;

import com.corona.coronavirusapp.RecordNotFoundException;
import com.corona.coronavirusapp.model.EmployeeEntity;
import com.corona.coronavirusapp.service.EmployeeServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by USER on 22/3/2020.
 */@RestController
@RequestMapping("/employees")
public class EmployeeController
{
    @Autowired
    EmployeeServiceImplementation service;


    /**
     * get Api to return list of all employees.
     * @return List of Employees
     */
    @GetMapping()
    public ResponseEntity<List<EmployeeEntity>> getAllEmployees() {
        List<EmployeeEntity> employeeList = service.getAllEmployees();
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeEntity> getEmployeeById(
            @PathVariable("id") final Long id) throws RecordNotFoundException {
        EmployeeEntity employeeEntity = service.getEmployeeById(id);
        return new ResponseEntity<>(employeeEntity, HttpStatus.OK);
    }



    @PostMapping()
    public ResponseEntity<EmployeeEntity> saveEmployee(
            @RequestBody final  EmployeeEntity employeeEntity) {
        EmployeeEntity savedEmployee = service.saveEmployee(employeeEntity);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }



    @PutMapping("/{id}")
    public ResponseEntity<EmployeeEntity> updateEmployeeById(
            @PathVariable("id") final Long id,
            @RequestBody final EmployeeEntity employeeEntityToUpdate) throws RecordNotFoundException {
        EmployeeEntity updatedEmployee
                = service.updateEmployeeById(id, employeeEntityToUpdate);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployeeById(
            @PathVariable("id") final Long id) throws RecordNotFoundException {
        service.deleteEmployeeId(id);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }


    @GetMapping("/search1/{searchString}")
    public ResponseEntity<List<EmployeeEntity>> getEmployeeByFirstNameContaining(
            @PathVariable("searchString") final String searchString) {
        List<EmployeeEntity> employeeList
                = service.getEmployeeByNameContaining(searchString);
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }


    @GetMapping("/search2/{searchString}")
    public ResponseEntity<List<EmployeeEntity>> getEmployeeByNameLike(
            @PathVariable("searchString") final String searchString) {
        List<EmployeeEntity> employeeEntityList
                = service.getEmployeeByNameLike(searchString);
        return new ResponseEntity<>(employeeEntityList, HttpStatus.OK);
    }


















//Old code
   /* @GetMapping
    public ResponseEntity<List<EmployeeEntity>> getAllEmployees() {
        List<EmployeeEntity> list = service.getAllEmployees();

        return new ResponseEntity<List<EmployeeEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        EmployeeEntity entity = service.getEmployeeById(id);

        return new ResponseEntity<EmployeeEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EmployeeEntity> createOrUpdateEmployee(EmployeeEntity employee)
            throws RecordNotFoundException {
        EmployeeEntity updated = service.createOrUpdateEmployee(employee);
        return new ResponseEntity<EmployeeEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteEmployeeById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        service.deleteEmployeeById(id);
        return HttpStatus.FORBIDDEN;
    }*/

}