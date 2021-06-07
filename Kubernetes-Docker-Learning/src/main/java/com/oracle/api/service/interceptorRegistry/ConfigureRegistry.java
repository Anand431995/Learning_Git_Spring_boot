package com.oracle.api.service.interceptorRegistry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import com.oracle.api.model.registry;

@Configuration
public class ConfigureRegistry extends WebMvcConfigurerAdapter{

/*  private registry reg;
  
  @Autowired
  public ConfigureRegistry(registry reg)
  {
    this.reg=reg;
  }
*/
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    // TODO Auto-generated method stub
    super.addInterceptors(registry);
    registry.addInterceptor(new registry()).addPathPatterns("/getdep");
  }
  

  
}
