package com.oracle.api.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.oracle.api.model.Employee;
import com.oracle.api.model.document;
import com.oracle.api.service.DocumentService;
import com.oracle.api.service.EmployeeService;

@RestController
public class EmployeeController {
  

  private  EmployeeService employeeService;
  private DocumentService documentService;
  @Autowired
  public EmployeeController(EmployeeService employeeService ,DocumentService documentService) {
    
    this.employeeService=employeeService;
    this.documentService=documentService;
  }
  @PostMapping("/postemployee")
  public void postEmployee(@RequestBody Employee employee) {
    employeeService.postemployee(employee);
    
  }
  @GetMapping("/getemployee/{id}")
  public Optional<Employee> getEmployeeById(@PathVariable int id) {
   // return new Employee();
   return employeeService.getEmployeeById(id);
  }
  @PostMapping("/uploadFiles")
  public void postDocument(@RequestParam("file") MultipartFile multipartfiles) {
    documentService.uploadImage(multipartfiles);
  }
  @GetMapping("/getfile/{id}")
  public Optional<document> getDocument(@PathVariable int id) {
   return documentService.getfile(id);
  }

}
