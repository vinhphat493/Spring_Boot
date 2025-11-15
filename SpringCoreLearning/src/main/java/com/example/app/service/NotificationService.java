package com.example.app.service;

import org.springframework.stereotype.Service;

public class NotificationService {
    public void notify(String msg) {
        System.out.println("[✅ Notification] " + msg);
    }
}
