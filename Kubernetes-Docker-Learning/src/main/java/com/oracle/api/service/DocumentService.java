package com.oracle.api.service;

import java.util.Optional;
import org.springframework.web.multipart.MultipartFile;
import com.oracle.api.model.document;

public interface DocumentService {
  
  public document uploadImage(MultipartFile multipartfile);
public Optional<document> getfile(Integer id);
}
