package net.dityotech.student_management_system.controller;

import lombok.RequiredArgsConstructor;
import net.dityotech.student_management_system.dto.UserDTO;
import net.dityotech.student_management_system.entity.User;
import net.dityotech.student_management_system.model.Product;
import net.dityotech.student_management_system.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Profile({"qa", "prod"})
@RequiredArgsConstructor
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;
    private final Product product;

    @Value("${env}")
    private String environment;

    @GetMapping("/value")
    public ResponseEntity<String> getDynamicValue(){
        return ResponseEntity.ok(environment);
    }

    @GetMapping("/bean")
    public ResponseEntity<Product> getBean(){
        LOGGER.info("Inside bean api endpoint");
        LOGGER.error("Test error log");
        return ResponseEntity.ok(product);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getUsers() {
        //return ResponseEntity.ok(userService.getUsers());
        HttpHeaders headers = new HttpHeaders();
        headers.add("Nepal", "Kathmandu");
        headers.add("Test", "Test23");
        return ResponseEntity.ok().headers(headers).body(userService.getUsers());
    }
}
