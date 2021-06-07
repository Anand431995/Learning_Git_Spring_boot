/*-
    =============================================================================
     Copyright (c) 2005, 2018 Oracle and/or its affiliates. All rights reserved.
    ================================================================================
*/
package com.oracle.api.model;

/**
 * An Entity is a unique thing and is capable of being changed continuously over a long period of time. It has a unique
 * identity and is mutable.
 *
 * @author srnagesh
 * 
 */
public interface Entity<T> {

  /**
   * Entities compare by identity, not by attributes.
   *
   * @param other The other entity.
   * @return true if the identities are the same, regardles of other attributes.
   */
  boolean sameIdentityAs(T other);
}
