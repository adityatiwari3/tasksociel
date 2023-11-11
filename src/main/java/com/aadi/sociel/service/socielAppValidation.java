package com.aadi.sociel.service;
import org.springframework.stereotype.Service;

@Service
public class socielAppValidation {
    public boolean isValidUser(String user) {
        return user != null && !user.isBlank() && user.matches("^[a-zA-Z\\s]+$");
    }
}
