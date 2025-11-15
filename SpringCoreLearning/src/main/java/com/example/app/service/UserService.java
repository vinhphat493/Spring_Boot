package com.example.app.service;

import com.example.app.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 @Service
 public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(String name) {
        userRepository.save(name);
    }
 }
 * */

/**
 @Service
 public class UserService {
     private final UserRepository userRepository;
     private final EmailService emailService;

     public UserService(UserRepository userRepository, EmailService emailService) {
         this.userRepository = userRepository;
         this.emailService = emailService;
     }

     public void addUser(String name, String email) {
         userRepository.save(name);
         emailService.sendEmail(email);
     }
 }
 * */

@Repository
public class UserService {
    private final UserRepository userRepository;

    public UserService(@Qualifier("mongodb") UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(String name) {
        userRepository.save(name);
    }
}



