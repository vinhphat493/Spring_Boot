package com.example.app.domain.repository;

import org.springframework.stereotype.Repository;

/**

//@Repository
public class UserRepository {
    public void save(String name) {
        System.out.println("Saving: " + name);
    }
}*/


/**
 public interface UserRepository {
 void save(String name);
 }
 * */

/**
 * 1.3
 @Repository
 public class UserRepository {
     public void save(String name) {
        System.out.println("[Repository] Saving: " + name);
     }
 }
 * */

public interface UserRepository {
    void save(String name);
}

