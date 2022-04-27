package com.example.demo.controller;

import com.example.demo.model.Task;
import com.example.demo.model.User;
import com.example.demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @PostMapping(value = "/users", consumes =  MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ModelAndView create(User user) {
        userService.create(user);
        return new ModelAndView("redirect:/login");
    }

    @GetMapping("/users/me")
    public User getCurrentUser() {
        return userService.getCurrentUser();
    }
}
