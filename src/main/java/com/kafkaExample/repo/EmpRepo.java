package com.kafkaExample.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kafkaExample.model.Employee;

@Repository
public interface EmpRepo extends CrudRepository<Employee, Integer>{

}
