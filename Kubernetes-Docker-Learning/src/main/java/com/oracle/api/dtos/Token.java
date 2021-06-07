package com.oracle.api.dtos;

import lombok.Data;

@Data
public class Token {
  private String access_token;
  private String token_type;
  private long expires_in;
  private String scope;
  private long timestamp;
}
