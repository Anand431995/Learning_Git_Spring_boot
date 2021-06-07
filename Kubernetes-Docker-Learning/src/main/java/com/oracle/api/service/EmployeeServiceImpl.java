package com.oracle.api.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.oracle.api.model.Employee;
import com.oracle.api.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
  
  private EmployeeRepository employeeRepository;
 
  @Autowired
  public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
    
    this.employeeRepository=employeeRepository;
  }
  public EmployeeServiceImpl() {
    
  }
 public void postemployee(Employee employee) {
  
  employeeRepository.save(employee);
 }
  public Optional<Employee> getEmployeeById(int id) {
  
    return employeeRepository.findById(id);
 }
}
