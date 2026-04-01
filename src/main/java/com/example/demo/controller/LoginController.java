package com.example.demo.controller;

import com.example.demo.model.LoginRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    // Hardcoded credentials for simple validation
    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "password";

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("loginRequest", new LoginRequest());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginRequest loginRequest, Model model) {
        if (VALID_USERNAME.equals(loginRequest.getUsername()) && VALID_PASSWORD.equals(loginRequest.getPassword())) {
            return "success";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }

    @GetMapping("/success")
    public String success() {
        return "success";
    }
}
