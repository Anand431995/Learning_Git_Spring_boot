package com.oracle.api.dtos;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class DepartmentDto {
  
  private String lastUpdateDate;
  
  private long count;

}
