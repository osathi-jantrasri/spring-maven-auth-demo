package com.example.spring_maven_auth_demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.spring_maven_auth_demo.enumerator.UserRole;
import com.example.spring_maven_auth_demo.model.Document;
import com.example.spring_maven_auth_demo.repository.DocumentRepository;

@Service
public class DocumentService {

    private final DocumentRepository documentRepository;

    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public List<Document> getDocumentsForUser(UserRole role) {
        return documentRepository.findAll().stream()
            .filter(doc -> doc.getAllowedRoles().contains(role))
            .collect(Collectors.toList());
    }
}
