package com.oracle.api.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.oracle.api.model.document;
import com.oracle.api.repository.DocumentRepository;

@Service
public class DocumentServiceImpl implements DocumentService{
 
  @Autowired
  private DocumentRepository documentRepository;
  
  
  public document uploadImage(MultipartFile file) {
    
    String filename=file.getOriginalFilename();
    try {
      document doc=new document(1,filename,file.getContentType(),file.getBytes());
      return documentRepository.save(doc);
    }
    catch(Exception e) {
      e.printStackTrace();
    }
   return null;
  }
  public Optional<document> getfile(Integer id) {
    
   return documentRepository.findById(id);
  }

}
