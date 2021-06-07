package com.oracle.api.event;

import java.util.List;
import org.springframework.context.ApplicationEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class employeeEvent extends ApplicationEvent{
  
  private int rollno;
  private String name;
  
  public employeeEvent(Object source) {
    super(source);
    // TODO Auto-generated constructor stub
  }
  public employeeEvent(int rollno,String name) {
  
    super(rollno);
    this.name=name;
    this.rollno=rollno;
  }
 

}
