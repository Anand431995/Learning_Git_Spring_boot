/*-
    =============================================================================
     Copyright (c) 2005, 2018 Oracle and/or its affiliates. All rights reserved.
    ================================================================================
*/
package com.oracle.api.model;

/**
 * @author suschall
 *
 */
import java.io.IOException;
import java.time.Instant;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/**
 * Deserializer for Instant
 * 
 * @author suschall
 *
 */
public class InstantDeSerializer extends JsonDeserializer<Instant> {
  /**
   * Instant Deserializer
   * 
   * @param arg0
   * @param arg1
   * @return Instant
   */
  @Override
  public Instant deserialize(JsonParser arg0, DeserializationContext arg1) throws IOException {

    return Instant.parse(arg0.getText());
  }
}
