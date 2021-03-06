/*-
    =============================================================================
     Copyright (c) 2005, 2018 Oracle and/or its affiliates. All rights reserved.
    ================================================================================
*/
package com.oracle.api.model;

import org.slf4j.MDC;

/**
 * ThreadLocal based Context holder for every Request. Makes use of {@link MDC}.
 *
 * @author srnagesh
 */
public enum RequestContext {

  // @formatter:off
    CORRELATION_ID_KEY("x-oal-correlationID"),
    TENANT_CODE_KEY("x-oal-tenantCode"),
    APP_CODE_KEY("x-oal-appCode"),
    USERNAME_KEY("x-oal-userName"),
    ROLES_KEY("x-oal-role-names");
    // @formatter:on

  private final String value;

  /**
   * Initialize
   *
   * @param value value of the enum
   */
  RequestContext(String value) {

    this.value = value;
  }

  /**
   * Value of the enum
   *
   * @return value
   */
  public String value() {

    return this.value;
  }

  /**
   * Add elements to the RequestContext
   *
   * @param contextKey {@link RequestContext}
   * @param value value of the given {@link RequestContext}
   */
  public static void put(RequestContext contextKey, String value) {

    MDC.put(contextKey.value(), value);
  }

  /**
   * Gets the value of enum using the {@link RequestContext}
   *
   * @param contextKey contextKey
   * @return value of the given {@link RequestContext}
   */
  public static String get(RequestContext contextKey) {

    return MDC.get(contextKey.value());
  }

  /**
   * Clears the ThreadLocalContext
   */
  public static void clearThreadLocalContext() {

    MDC.clear();
  }
}
