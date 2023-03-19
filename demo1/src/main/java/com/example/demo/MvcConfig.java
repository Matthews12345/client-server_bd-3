package com.example.demo;
// конфигурационный класс
// для объединени всех методов в одно Spring boot приложение
// все зависимости будут взаимодействовать во всех классах
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.context.annotation.Configuration; // for creating the bean for this class
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry; // allows to create simple automated controllers pre-configured with status code and/or a view.
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer; // метод конфигурации
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("main/resources/templates/login"); // указываем обрабатываемый запрос и нужный шаблон
    }
}
