package net.dityotech.student_management_system.config;

import net.dityotech.student_management_system.entity.User;
import net.dityotech.student_management_system.model.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfiguration {

    @Bean
    public Product product(){
        System.err.println("::::::: inside product bean creation.");
        Product product = Product.builder()
                .id(101L)
                .name("Playstation")
                .price(1200D)
                .quantity(4L)
                .build();
        return product;
    }

    @Bean
    public User user(){
        System.err.println("::::::: inside user bean creation.");
        User user = User.builder()
                .username("test user")
                .password("test password")
                .email("test@gmail.com")
                .build();
        return user;
    }
}
