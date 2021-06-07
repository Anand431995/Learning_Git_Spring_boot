package com.oracle.api.event;


import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import com.oracle.api.model.Department;
import com.oracle.api.model.Employee;
import com.oracle.api.repository.DepartmentRepository;
import com.oracle.api.service.DepartmentServiceImpl;
import com.oracle.api.service.EmployeeServiceImpl;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class employeeEventListener {
 
  @EventListener
  public void handlevent(employeeEvent department) {
    EmployeeServiceImpl deptemp = new EmployeeServiceImpl();
    Employee emp= new Employee(3,"ravi",4090);
   // deptemp.postemployee(emp);
    
  }

}
