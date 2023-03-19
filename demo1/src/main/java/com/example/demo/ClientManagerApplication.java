package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer; // связывает bean-компоненты Servlet, Filter и ServletContextInitializer из контекста приложения с сервером
@SpringBootApplication
public class ClientManagerApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(ClientManagerApplication.class,args);
    }
}
