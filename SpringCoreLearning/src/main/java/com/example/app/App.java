package com.example.app;

import com.example.app.config.AppConfig;
import com.example.app.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

public class App {
    public static void main(String[] args) {
        /**
         * // Khởi tạo Spring IoC Container
         *         AnnotationConfigApplicationContext context =
         *                 new AnnotationConfigApplicationContext(AppConfig.class);
         *
         *         // Lấy bean UserService từ container
         *         UserService userService = context.getBean(UserService.class);
         *
         *         // Sử dụng bean
         *         userService.printUser("John Doe");
         *
         *         // Đóng container
         *         context.close();
         * */
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService service = context.getBean(UserService.class);

//        // Lần 1
//        UserService s1 = context.getBean(UserService.class);
//        s1.setUserId(100L);
//        s1.test();
//
//        // Lần 2
//        UserService s2 = context.getBean(UserService.class);
//        s2.setUserId(200L);
//        s2.test();

//        System.out.println("s1 == s2: " + (s1 == s2));

        service.addUser(100L);  // userId = 100
        service.addUser(200L);  // userId = ? (Still 100!)
    }
}