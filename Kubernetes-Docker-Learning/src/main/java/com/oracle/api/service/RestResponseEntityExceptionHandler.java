/*-
    =============================================================================
     Copyright (c) 2005, 2020 Oracle and/or its affiliates. All rights reserved.
    ================================================================================
*/
package com.oracle.api.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

/**
 * Global Exception Handler for Rest APIs
 *
 * @author srnagesh
 */
@Slf4j
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

  /**
   * Handler for Bad Requests
   *
   * @param ex Exception handled
   * @param request WebRequest
   * @return ResponseEntity
   */
  @ExceptionHandler({IllegalArgumentException.class})
  //@ResponseStatus(HttpStatus.BAD_REQUEST)
  ResponseEntity<Object> handleBadRequests(IllegalArgumentException ex, final WebRequest request) {

    final List<String> errors = new ArrayList<>();
    errors.add(ex.getLocalizedMessage());

    final ErrorResponse appError = ErrorResponse.builder().status(HttpStatus.BAD_REQUEST).errors(errors).build();

    return handleExceptionInternal(ex, appError, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
  }

/*  @Override
  protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
      HttpStatus status, WebRequest request) {

    final List<String> errors = new ArrayList<>();
    errors.add(ex.getLocalizedMessage());

    final ErrorResponse appError = ErrorResponse.builder().status(HttpStatus.BAD_REQUEST).errors(errors).build();

    return handleExceptionInternal(ex, appError, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
  }

  /**
   * Handles BadRequestException
   *
   * @param exception the {@link BadRequestException} to handle
   * @param request WebRequest
   * @return ResponseEntity
   * /
  @ExceptionHandler(BadRequestException.class)
  public ResponseEntity<Object> handleBadRequestException(final BadRequestException exception,
      final WebRequest request) {
    log.error("Bad Request exception caught: {}", exception.getMessage());
    final List<String> errors = new ArrayList<>();
    errors.add(exception.getLocalizedMessage());

    final ErrorResponse appError = ErrorResponse.builder().status(HttpStatus.BAD_REQUEST).errors(errors).build();

    return handleExceptionInternal(exception, appError, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
  }

  /**
   * Handles ResourceNotFoundException
   *
   * @param exception the {@link BadRequestException} to handle
   * @param request WebRequest
   * @return ResponseEntity
   * /
  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<Object> handleResourceNotFoundException(final ResourceNotFoundException exception,
      final WebRequest request) {
    log.error("Resource not found exception caught: {}", exception.getMessage());
    final List<String> errors = new ArrayList<>();
    errors.add(exception.getLocalizedMessage());

    final ErrorResponse appError = ErrorResponse.builder().status(HttpStatus.NOT_FOUND).errors(errors).build();

    return handleExceptionInternal(exception, appError, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
  }

  /**
   * Handles PersistenceException type of exceptions, sets HTTP status to 500, "Internal Server Error"
   *
   * @param exception the {@link PersistenceException} to handle
   * @param request WebRequest
   * @return ResponseEntity
   * /
  @ExceptionHandler(PersistenceException.class)
  public ResponseEntity<Object> handlePersistenceException(final PersistenceException exception,
      final WebRequest request) {
    log.error("Persistence exception caught: {}", exception.getMessage());
    final List<String> errors = new ArrayList<>();
    errors.add(exception.getLocalizedMessage());

    final ErrorResponse appError = ErrorResponse.builder().status(INTERNAL_SERVER_ERROR).errors(errors).build();

    return handleExceptionInternal(exception, appError, new HttpHeaders(), INTERNAL_SERVER_ERROR, request);
  }

  /**
   * Handles BuilderException type of exceptions, sets HTTP status to 500, "Internal Server Error"
   *
   * @param exception the {@link BuilderException} to handle
   * @param request WebRequest
   * @return ResponseEntity
   * /
  @ExceptionHandler(BuilderException.class)
  public ResponseEntity<Object> handleBuilderException(final BuilderException exception, final WebRequest request) {
    log.error("Builder exception caught: {}", exception.getMessage());
    final List<String> errors = new ArrayList<>();
    errors.add(exception.getLocalizedMessage());

    final ErrorResponse appError = ErrorResponse.builder().status(INTERNAL_SERVER_ERROR).errors(errors).build();

    return handleExceptionInternal(exception, appError, new HttpHeaders(), INTERNAL_SERVER_ERROR, request);
  } */
}
