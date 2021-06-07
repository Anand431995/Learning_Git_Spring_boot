package com.oracle.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class document {
 @Id
 //@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer id;
 
private String name;
private String docType;
@Lob
private byte[] image;
}
