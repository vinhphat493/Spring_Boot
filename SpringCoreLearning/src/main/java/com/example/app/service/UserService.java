package com.example.app.service;

import com.example.app.domain.repository.UserRepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final ObjectProvider<UserRequest> userRequestObjectProvider;

    public UserService(ObjectProvider<UserRequest> userRequestObjectProvider) {
        this.userRequestObjectProvider = userRequestObjectProvider;
    }

    public void addUser(Long id) {
        UserRequest userRequest = userRequestObjectProvider.getObject();
        userRequest.setUserId(id);
        System.out.println("Added user: " + userRequest.getUserId());
    }
}