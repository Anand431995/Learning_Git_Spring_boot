package com.oracle.api.service;

import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import com.oracle.api.dtos.DepartmentDto;
import com.oracle.api.dtos.EmployeeDto;
import com.oracle.api.dtos.Token;
import com.oracle.api.model.Department;

public interface DepartmentService {
  public Optional<Department> getDepartmentById(int id);
  public void postDepartment(Department department);
  default int postlistener() {
    return 5;
  }
  public List<Department> getdepartmentbyquery(String name,String location);
  
  public List<DepartmentDto> recievetrimdata();
  //public List<DepartmentDto> receivetrimdata1();
  public ResponseEntity<Token> gettingToken();

}
