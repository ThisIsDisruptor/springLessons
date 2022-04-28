package com.example.demo.service;

import com.example.demo.model.Task;
import com.example.demo.model.User;

import javax.validation.Valid;
import java.util.List;

public interface UserService {
    User create(@Valid User user);

    User getCurrentUser();

    List<Task> getCurrentUserTasks();
}
