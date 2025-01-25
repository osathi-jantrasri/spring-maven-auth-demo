package com.example.spring_maven_auth_demo.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_maven_auth_demo.enumerator.UserRole;
import com.example.spring_maven_auth_demo.model.Document;
import com.example.spring_maven_auth_demo.service.DocumentService;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {

    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping("/public")
    public List<Document> getPublicDocuments() {
        return documentService.getDocumentsForUser(UserRole.GUEST); 
    }

    @GetMapping("/secured")
    public List<Document> getSecuredDocuments(Authentication authentication) {
        UserRole role = UserRole.valueOf(
            authentication.getAuthorities().iterator().next().getAuthority().replace("ROLE_", "")
        );
        return documentService.getDocumentsForUser(role);
    }
}