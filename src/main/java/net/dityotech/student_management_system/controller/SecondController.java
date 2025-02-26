package net.dityotech.student_management_system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/second")
public class SecondController {

    // URL: http://localhost:8080/second/hi
    @GetMapping("/hi")
    public String sayHello() {
        return "Hi Everyone!";
    }
}
