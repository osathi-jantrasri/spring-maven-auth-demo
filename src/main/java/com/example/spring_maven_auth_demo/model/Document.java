package com.example.spring_maven_auth_demo.model;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.Data;
import java.util.List;

import com.example.spring_maven_auth_demo.enumerator.UserRole;

@Entity
@Data
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    
    @ElementCollection
    @CollectionTable(name = "document_allowed_roles", joinColumns = @JoinColumn(name = "document_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "allowed_role")
    private List<UserRole> allowedRoles;
}
