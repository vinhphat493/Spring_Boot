package com.example.app.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class UserRequest {
    private Long userId;

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        System.out.println("User ID: " + userId + " - Instance id : " + System.identityHashCode(this));
        return userId;
    }
}
