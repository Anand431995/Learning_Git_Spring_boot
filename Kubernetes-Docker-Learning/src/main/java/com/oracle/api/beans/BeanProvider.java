package com.oracle.api.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanProvider {
  
  @Bean
  public void pushtomasteraftercut() {
    
  }
  @Bean
  public RestTemplate resttemplateprovider() {
    return new RestTemplate();
  }
  @Bean
  public void secondpushtomaster()
  {
    
  }
  @Bean
  public void help() {
    
  }

  @Bean
  public void pushingtofeature() {
    
  }
  @Bean
  public void pushingtofeaturetwo() {
    //datacheck dp = new datacheck();
    //dp.a=20;
   
  }
}
