package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

@Controller
public class RegistrationController {
    @GetMapping("/registration")
    public String registration(){
        ResourceUrlProvider resourceUrlProvider = new ResourceUrlProvider();

        return "html/login/registration";
    }
}
