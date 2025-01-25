package com.example.spring_maven_auth_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring_maven_auth_demo.model.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {
}