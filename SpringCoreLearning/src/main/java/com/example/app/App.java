package com.example.app;

import com.example.app.config.AppConfig;
import com.example.app.service.PaymentService;
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

        UserService userService = context.getBean("userService", UserService.class);
        userService.addUser("John Doe");

        PaymentService paymentService = context.getBean(PaymentService.class);
        paymentService.processPayment(100.0);
    }
}