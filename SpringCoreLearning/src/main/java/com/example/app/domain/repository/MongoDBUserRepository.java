package com.example.app.domain.repository;

public class MongoDBUserRepository implements UserRepository {
    public MongoDBUserRepository(String dbUrl) {
        System.out.println("Connected to MongoDB: " + dbUrl);
    }

    @Override
    public void save(String name) {
        System.out.println("[MongoDB] Saving: " + name);
    }
}
