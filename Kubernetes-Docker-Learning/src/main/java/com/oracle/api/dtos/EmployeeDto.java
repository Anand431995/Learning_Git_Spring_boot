package com.oracle.api.dtos;

import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class EmployeeDto {
  
 private String status;
  
 private long count;

  /*public EmployeeDto(String status, long count) {
    super();
    this.status = status;
    this.count = count;
  }

  public EmployeeDto() {
    super();
    // TODO Auto-generated constructor stub
  } */
  
}
