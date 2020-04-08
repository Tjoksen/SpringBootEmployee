package com.corona.coronavirusapp.service;

import com.corona.coronavirusapp.RecordNotFoundException;
import com.corona.coronavirusapp.model.EmployeeEntity;
import com.corona.coronavirusapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class EmployeeServiceImplementation implements IEmployeeService {

    @Autowired
    EmployeeRepository repository;

    @Override
    public List<EmployeeEntity> getAllEmployees() {
        return (List<EmployeeEntity>) repository.findAll();
    }

    @Override
    public EmployeeEntity getEmployeeById(Long id) throws RecordNotFoundException {
        Optional<EmployeeEntity> employeeEntity= Optional.of(repository.findById(id).get());
        if(employeeEntity.isPresent()){
            return repository.findById(id).get();
        }
        else{
            throw new  RecordNotFoundException("Employee not  found");
        }

    }

    @Override
    public EmployeeEntity saveEmployee(EmployeeEntity employeeEntity) {
        return repository.save(employeeEntity);
    }

    @Override
    public EmployeeEntity updateEmployeeById(Long id, EmployeeEntity employeeToUpdate) throws RecordNotFoundException {
        Optional<EmployeeEntity> employeeFromDbTest= Optional.of(repository.findById(id).get());
        if(employeeFromDbTest.isPresent()){
            // Fetch the Employee from db
      EmployeeEntity employeeFromDb= repository.findById(id).get();
            employeeFromDb.setFirstName(employeeToUpdate.getFirstName());
            employeeFromDb.setLastName(employeeToUpdate.getLastName());
            employeeFromDb.setEmail(employeeToUpdate.getEmail());
            return repository.save(employeeFromDb);
        }
        else{
            throw new  RecordNotFoundException("Employee not  found");
        }

    }

    @Override
    public void deleteEmployeeId(Long id)  throws RecordNotFoundException{
        Optional<EmployeeEntity> employeeEntity= Optional.of(repository.findById(id).get());
        if(employeeEntity.isPresent()){
           repository.deleteById(id);
        }
        else{
            throw new  RecordNotFoundException("Employee not  found");
        }



    }

    @Override
    public List<EmployeeEntity> getEmployeeByNameContaining(String searchString) {
        return repository.findByFirstNameContaining(searchString);
    }

    @Override
    public List<EmployeeEntity> getEmployeeByNameLike(String searchString) {
        return repository.findByFirstNameLike(searchString);
    }


    //old code


/*
    public List<EmployeeEntity> getAllEmployees()
    {
        List<EmployeeEntity> employeeList = (List<EmployeeEntity>) repository.findAll();

        if(employeeList.size() > 0) {
            return employeeList;
        } else {
            return new ArrayList<EmployeeEntity>();
        }
    }

    public EmployeeEntity getEmployeeById(Long id) throws RecordNotFoundException
    {
        Optional<EmployeeEntity> employee = repository.findById(id);

        if(employee.isPresent()) {
            return employee.get();
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }

    public EmployeeEntity createOrUpdateEmployee(EmployeeEntity entity) throws RecordNotFoundException
    {
        Optional<EmployeeEntity> employee = repository.findById(entity.getId());

        if(employee.isPresent())
        {
            EmployeeEntity newEntity = employee.get();
            newEntity.setEmail(entity.getEmail());
            newEntity.setFirstName(entity.getFirstName());
            newEntity.setLastName(entity.getLastName());
            newEntity.setId(entity.getId());

            newEntity = repository.save(newEntity);

            return newEntity;
        } else {
            entity = repository.save(entity);

            return entity;
        }
    }

    public void deleteEmployeeById(Long id) throws RecordNotFoundException
    {
        Optional<EmployeeEntity> employee = repository.findById(id);

        if(employee.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }*/
}
