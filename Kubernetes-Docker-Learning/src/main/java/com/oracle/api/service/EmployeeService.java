package com.oracle.api.service;

import java.util.Optional;
import com.oracle.api.model.Employee;

public interface EmployeeService {
  
  public void postemployee(Employee employee);
  public Optional<Employee> getEmployeeById(int id);
}
