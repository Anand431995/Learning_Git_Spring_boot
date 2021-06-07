package com.oracle.api.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import com.oracle.api.model.AbstractEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Department extends AbstractEntity<Department>{
  @Id
 private int id;
  
 private String name;
  
 private String loc;
  
  @OneToMany(targetEntity=Employee.class,cascade=CascadeType.ALL)
  @JoinColumn(name="cp_fk" , referencedColumnName ="id")
 public List<Employee> emp;

  @Override
  public boolean sameIdentityAs(Department other) {
    // TODO Auto-generated method stub
    return false;
  }

}
