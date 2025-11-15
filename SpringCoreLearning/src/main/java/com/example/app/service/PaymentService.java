package com.example.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private NotificationService notificationService;

    @Autowired(required = true)
    public void setNotificationService(NotificationService notificationService) {
        System.out.println("[DEBUG] Setter setNotificationService called!");
        this.notificationService = notificationService;
    }

    public void processPayment(Double amount) {
        System.out.println("[Payment] Processing $" + amount);

        if (notificationService != null) {
            notificationService.notify("Payment success!");
        } else {
            System.out.println("[Warning] No notification service!");
        }
    }
}
