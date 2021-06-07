package com.oracle.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import com.oracle.api.model.document;

public interface DocumentRepository extends JpaRepository<document,Integer>{

}
