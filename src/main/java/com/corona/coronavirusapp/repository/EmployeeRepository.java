package com.corona.coronavirusapp.repository;

import com.corona.coronavirusapp.model.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository
        extends CrudRepository<EmployeeEntity, Long> {


    List<EmployeeEntity> findByFirstNameContaining(String value);

    @Query("SELECT fn FROM EmployeeEntity  fn WHERE fn.firstName LIKE %:value%")
    List<EmployeeEntity> findByFirstNameLike(@Param("value")String value);

}