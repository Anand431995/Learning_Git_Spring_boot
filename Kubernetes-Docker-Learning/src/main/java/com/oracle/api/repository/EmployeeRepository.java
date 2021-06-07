package com.oracle.api.repository;

import org.springframework.data.repository.CrudRepository;
import com.oracle.api.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee,Integer> {

}
