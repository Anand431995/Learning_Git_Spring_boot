/*-
    =============================================================================
     Copyright (c) 2005, 2021 Oracle and/or its affiliates. All rights reserved.
    ================================================================================
*/
package com.oracle.api.dtos;

import java.util.Date;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Dto class for mapping the response from ocm Event table
 * 
 * @author anand
 *
 */
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class OcmDto {

  private Date lastUpdateDate;

  private long count;
}
