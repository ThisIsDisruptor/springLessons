package com.example.demo.controller;

import com.example.demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

import java.util.Map;

@Controller
public class HelloController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/hello")
    public String sayHello(){
        String login = userService.getCurrentUser().getLogin();
        return "Hello, " + login + "!";
    }

    @GetMapping("/helloPage")
    public String helloPage(){
        ResourceUrlProvider resourceUrlProvider = new ResourceUrlProvider();

        return "html/hello";
    }
}
