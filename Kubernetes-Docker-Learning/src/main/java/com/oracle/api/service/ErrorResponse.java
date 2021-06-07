/*-
    =============================================================================
     Copyright (c) 2005, 2018 Oracle and/or its affiliates. All rights reserved.
    ================================================================================
*/
package com.oracle.api.service;

import java.util.List;
import org.springframework.http.HttpStatus;
import lombok.Builder;
import lombok.Data;

/**
 * Object representing an Error to be sent to the API caller incase of an Error.
 * 
 * @author srnagesh
 *
 */
@Data
@Builder
@SuppressWarnings({"checkstyle:javadocmethod"})
class ErrorResponse {

  private final HttpStatus status;
  private final List<String> errors;

  private String description;
}
