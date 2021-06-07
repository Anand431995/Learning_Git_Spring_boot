/*-
    =============================================================================
     Copyright (c) 2005, 2018 Oracle and/or its affiliates. All rights reserved.
    ================================================================================
*/
package com.oracle.api.model;

import java.io.IOException;
import java.time.Instant;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * Serializer for Instant
 * 
 * @author suschall
 *
 */


public class InstantSerializer extends JsonSerializer<Instant> {

  @Override
  public void serialize(Instant arg0, JsonGenerator arg1, SerializerProvider arg2) throws IOException {
    arg1.writeString(arg0.toString());
  }

}
