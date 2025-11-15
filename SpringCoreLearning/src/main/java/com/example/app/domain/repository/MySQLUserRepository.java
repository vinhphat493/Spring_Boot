package com.example.app.domain.repository;

public class MySQLUserRepository implements UserRepository {
    public MySQLUserRepository(String dbUrl) {
        System.out.println("Connected to MySQL: " + dbUrl);
    }

    @Override
    public void save(String name) {
        System.out.println("[MySQL] Saving: " + name);
    }
}
