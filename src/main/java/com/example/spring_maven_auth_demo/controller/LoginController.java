package com.example.spring_maven_auth_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    
    @GetMapping("/login")
    public String showLoginPage(Model model) {
        return "login"; // Should match template filename without .html
    }
}
