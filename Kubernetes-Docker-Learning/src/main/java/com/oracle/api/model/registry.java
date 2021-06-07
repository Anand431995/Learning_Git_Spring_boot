package com.oracle.api.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class registry implements HandlerInterceptor{
  private static final String VALIDATION_ERROR_MSG = "Mandatory Header Param(s) "
      + RequestContext.TENANT_CODE_KEY.value() + " and " + RequestContext.APP_CODE_KEY.value() + " and "
      + RequestContext.USERNAME_KEY.value() + " not received in Request.";
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    // TODO Auto-generated method stub
   // return HandlerInterceptor.super.preHandle(request, response, handler);
    if (!StringUtils.isNotBlank(request.getHeader(RequestContext.TENANT_CODE_KEY.value()))
        || !StringUtils.isNotBlank(request.getHeader(RequestContext.APP_CODE_KEY.value()))
        || !StringUtils.isNotBlank(request.getHeader(RequestContext.USERNAME_KEY.value()))) {

      log.error(VALIDATION_ERROR_MSG);

      throw new IllegalArgumentException(VALIDATION_ERROR_MSG);
    }

    return true;
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView modelAndView) throws Exception {
    // TODO Auto-generated method stub
    HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
      throws Exception {
    // TODO Auto-generated method stub
    HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
  }
  

}
