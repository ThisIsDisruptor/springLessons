package com.example.demo.controller;

import com.example.demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/hello")
    public String SayHello(){
        String login = userService.getCurrentUser().getLogin();
        return "Hello, " + login + "!";
    }
}
