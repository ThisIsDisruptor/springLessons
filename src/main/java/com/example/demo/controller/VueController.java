package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/vue")
public class VueController {
    @GetMapping("/vueMessage")
    public String getDataForVueSample() {
        return "This is data from Server for vue!";
    }
}
