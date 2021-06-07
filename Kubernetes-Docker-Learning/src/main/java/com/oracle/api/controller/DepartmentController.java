package com.oracle.api.controller;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.oracle.api.beans.datacheck;
import com.oracle.api.dtos.DepartmentDto;
import com.oracle.api.dtos.EmployeeDto;
import com.oracle.api.dtos.Token;
import com.oracle.api.enums.employeeEnums;
import com.oracle.api.event.employeeEvent;
import com.oracle.api.model.Department;
import com.oracle.api.service.DepartmentService;
import com.sun.istack.logging.Logger;

@RestController
public class DepartmentController extends datacheck {
  
  private DepartmentService departmentService;
  private final ApplicationEventPublisher eventPublisher;
  private String[] ab;
  private String regex = "R";
  @Autowired
  public DepartmentController(DepartmentService departmentService ,ApplicationEventPublisher eventPublisher) {
    this.departmentService=departmentService;
    this.eventPublisher=eventPublisher;
    
  }

  @GetMapping("/getdepartment")
 public  Optional<Department> getDepartment(@PathVariable int id) {
    
  return  departmentService.getDepartmentById(id);
   
    
  }
  @PostMapping("/postdepartment")
  public void postDepartment(@RequestBody Department department) {
    employeeEvent ea=new employeeEvent(1,"aad");
    eventPublisher.publishEvent(ea);
    departmentService.postDepartment(department);
    
    
  }
  @GetMapping("/getdepartment1")
  public Instant check(@RequestParam(name="code") String p) {
   
    //return departmentService.getdepartmentbyquery("SSC", "PUNE");
   /* String a="2021-04-08";
    String b="2021-04-08";
    if(a.substring(a.length() - 2).equals(b.substring(b.length() - 2))) {
      return true;
    }
   
    return false; */
    System.out.println(p);
    String date="2018-10-28T19:34:50.63Z";
  return Instant.parse(date);
    //Instant.parse(text)
    
  }
  @GetMapping("/getdep")
  public String getdepartment() {
    //return departmentService.getdepartmentbyquery("IDC","PUNE");
    //return Instant.now();
    Instant p= Instant.now();
    for(int i=0;i<12;i++) {
      p = p.minus(30, ChronoUnit.MINUTES);
      System.out.println(p);
      System.out.println("//\\");
      
     // datacheck dp = new datacheck();
      //System.out.println(a);
      //datacheck dp = new datacheck();
    }
    return DateTimeFormatter.ofPattern("yyyy-MM-dd").withZone(ZoneId.of("UTC")).format(Instant.now());
  }
  @GetMapping(value="/getpep")
  public List<DepartmentDto> gettrimdata(){
    
   // return departmentService.recievetrimdata();
    //return Instant.now();//.minus(30, ChronoUnit.MINUTES);
    return departmentService.recievetrimdata();
  }
  //@RequestMapping(value = {"/article", "/article/{contract}"})
  @GetMapping(value = {"/article", "/article/{contract}"})
  public String[] checkenum(@PathVariable(name="contract",required = false) String contracts) {
   
     String[] lt=contracts.split(",");
    //Long ls=Long.parseLong(lt[0]);
    //return lt.length;
      return lt;
    //return contract;
      //return Instant.now();
  
  } 
  
  @GetMapping("/gettoken")
  public ResponseEntity<Token> success() {
    return departmentService.gettingToken();
  }
}
