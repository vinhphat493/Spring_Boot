package com.example.app.service;

import org.springframework.stereotype.Service;

@Service
public class EmailService {
    public void sendEmail(String email) {
        System.out.println("[Email] Sending to: " + email);
    }
}
