package com.oracle.api.service;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import com.oracle.api.dtos.DepartmentDto;
import com.oracle.api.dtos.EmployeeDto;
import com.oracle.api.dtos.Token;
import com.oracle.api.model.Department;
import com.oracle.api.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {
  private static final String GRANT_TYPE = "grant_type";
  private static final String SCOPE = "scope";
  private static final String LOCAL = "read";
  private static final String PASSWORD_GRANT_TYPE = "password";
  private static final String CLIENT_CREDS_GRANT_TYPE = "client_credentials";
  private static final String USERNAME = "dumb_leraner3";
  private static final String PASSWORD = "progressive3";
  private DepartmentRepository departmentRepository;
  private ResponseEntity<Token> token;
  private RestTemplate restTemplate;
  private String url="http://localhost:8080/oauth/token";
 // private HttpEntity http;
  @Autowired
  public DepartmentServiceImpl(DepartmentRepository departmentRepository,RestTemplate restTemplate){
    
    this.departmentRepository =departmentRepository;
    this.restTemplate = restTemplate;
  }
 
  public Optional<Department> getDepartmentById(int id) {
   
    return departmentRepository.findById(id);

  }
  public void postDepartment(Department department) {
    departmentRepository.save(department);
  }

  public List<Department> getdepartmentbyquery(String id,String location) {
   
    return departmentRepository.findByNameAndLocNot(id, location);

  }
  public List<DepartmentDto> recievetrimdata(){
    
    List<Department> departmet = null;

    int count=1;
    int i=0;
    int j=0;
    int k=0;
    List<String> departmet1 = new ArrayList<String>();
    List<DepartmentDto> ttss = new ArrayList<DepartmentDto>();
    departmet1.add("UDC");
    departmet1.add("LDC");
    departmet = departmentRepository.getsampledata(departmet1,Instant.now().minus(130, ChronoUnit.MINUTES));
   
    for(i=0;i<departmet.size();i=i+1) {
     
      if(departmet.get(i)!=null) {
        String a= DateTimeFormatter.ofPattern("yyyy-MM-dd").withZone(ZoneId.of("UTC")).format(departmet.get(i).getLastUpdateDate());
       
        for(j=i+1;j<departmet.size();j=j+1) {
          
          String b = DateTimeFormatter.ofPattern("yyyy-MM-dd").withZone(ZoneId.of("UTC")).format(departmet.get(j).getLastUpdateDate());
         
          if(a.substring(a.length() - 2).equals(b.substring(b.length() - 2))) {
           count=count+1;
          
           departmet.set(j, null);
          }
        }
        ttss.add(new DepartmentDto(a,count));
        count=1;
      }
    
    }
     return ttss;
  
  }
  
  public ResponseEntity<Token> gettingToken() {
    MultiValueMap<String, String> formUrlEncoded = new LinkedMultiValueMap<>();
    formUrlEncoded.add(GRANT_TYPE, CLIENT_CREDS_GRANT_TYPE);
    formUrlEncoded.add(SCOPE, LOCAL);
    
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setBasicAuth(USERNAME, PASSWORD);
   // httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
   // new HttpEntity<>(formUrlEncoded, httpHeaders);
   // httpHeaders.AUTHORIZATION()
    try {
      token = restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(formUrlEncoded, httpHeaders), Token.class);
    }
    catch(RestClientException e) {
      System.out.println(e);
    }
    return token;
  }
}
