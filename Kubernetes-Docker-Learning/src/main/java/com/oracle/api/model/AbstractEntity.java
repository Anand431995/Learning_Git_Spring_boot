/*-
    =============================================================================
     Copyright (c) 2005, 2018 Oracle and/or its affiliates. All rights reserved.
    ================================================================================
*/
package com.oracle.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import com.oracle.api.model.InstantSerializer;
import lombok.Builder;
import com.oracle.api.model.InstantSerializer;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


/**
 * Abstract Implementation of the {@link Entity} to provide default behavior. Entity classes must Extend this Abstract
 * Class.
 *
 * @param <T>
 * @author suschall
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractEntity<T> implements Entity<T> {

  @Column(name = "CREATED_BY",  length = 240)
  @CreatedBy
  private String createdBy;

  @Column(name = "CREATION_DATE", nullable = false)
  @CreatedDate
  @JsonSerialize(using = InstantSerializer.class)
  @JsonDeserialize(using = InstantDeSerializer.class)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "UTC")
  private Instant creationDate;

  @Column(name = "LAST_UPDATED_BY", length = 240)
  @LastModifiedBy
  private String lastUpdatedBy;

  @Column(name = "LAST_UPDATE_DATE", nullable = false)
  @LastModifiedDate
  @JsonSerialize(using = InstantSerializer.class)
  @JsonDeserialize(using = InstantDeSerializer.class)
  private Instant lastUpdateDate;

  public Instant getLastUpdateDate() {
    return lastUpdateDate;
  }

  public void setLastUpdateDate(Instant lastUpdateDate) {
    this.lastUpdateDate = lastUpdateDate;
  }

  @Column(name = "VERSION")
  @Version
  private long version;

}
