package com.example.demo.controller.task;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TaskController {

    @GetMapping("/tasks/myTasks")
    public String getMyTasks() {
        return "html/tasks/myTasks";
    }

    @GetMapping("/tasks/createTask")
    public String createTask() {
        return "html/tasks/createTask";
    }
}
