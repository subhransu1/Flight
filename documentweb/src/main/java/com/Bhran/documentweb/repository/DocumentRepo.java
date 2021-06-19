package com.Bhran.documentweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Bhran.documentweb.entities.Document;

public interface DocumentRepo extends JpaRepository<Document, Long>{

}
