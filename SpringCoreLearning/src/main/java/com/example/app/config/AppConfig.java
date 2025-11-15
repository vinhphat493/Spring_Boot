package com.example.app.config;

//import com.example.app.domain.repository.MongoDBUserRepository;
//import com.example.app.domain.repository.MySQLUserRepository;
import com.example.app.domain.repository.UserRepository;
import com.example.app.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example.app")
public class AppConfig {

//    @Bean
//    public UserRepository userRepository() {
//        // Kiểm soát database tuỳ theo environment
//        String dbType = System.getenv("DB_TYPE");
//        if ("mongodb".equalsIgnoreCase(dbType)) {
//            return new MongoDBUserRepository("mongodb://localhost:27017");
//        } else {
//            return new MySQLUserRepository("jdbc:mysql://localhost:3306/mydb");
//        }
//    }
}