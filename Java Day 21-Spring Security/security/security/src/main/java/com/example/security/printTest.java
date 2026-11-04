package com.example.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class printTest {
    @GetMapping("/hi")
    public String hi(){
        return "Hi Anish";
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello Anish";
    }

    @GetMapping("/hallo")
    public String hallo() {
        return "Hallo, wie gehts?";
    }
}