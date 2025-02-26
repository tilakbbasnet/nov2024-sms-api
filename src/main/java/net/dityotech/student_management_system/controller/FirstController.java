package net.dityotech.student_management_system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first")
public class FirstController {

    // URL: http://localhost:8080/first
    @GetMapping()
    public String hiStudent() {
        return "Hi Priyanka";
    }

    @GetMapping("/hi/{firstName}/{lastName}")
    public String sayHello(@PathVariable("firstName") String fname,
                           @PathVariable("lastName") String lname) {
        return "Hi "+fname + " " + lname;
    }

    // URL: http://localhost:8080/first/bye
    @GetMapping("/bye")
    public String sayBye(){
        return "Bye bye students!";
    }
}
