package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(){
        return "html/home";
    }

    @GetMapping("/")
    public String blankHome(){
        return "html/home.html";
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }
}