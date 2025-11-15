package com.example.app.domain.repository;

import org.springframework.stereotype.Repository;

@Repository("mysql")
public class MySQLUserRepository implements UserRepository {
//    public MySQLUserRepository(String dbUrl) {
//        System.out.println("Connected to MySQL: " + dbUrl);
//    }

    @Override
    public void save(String name) {
        System.out.println("[MySQL] Saving: " + name);
    }
}
