package com.example.demo.controller.task;

import com.example.demo.model.Task;
import com.example.demo.service.impl.TaskServiceImpl;
import com.example.demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.management.InstanceNotFoundException;
import java.util.List;

@RestController
public class TaskRestController {

    @Autowired
    private TaskServiceImpl taskService;

    @Autowired
    private UserServiceImpl userService;

    @PostMapping(value = "/tasks", consumes =  MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ModelAndView create(Task task) {
        taskService.create(task);
        return new ModelAndView("redirect:/tasks/myTasks");
    }

    @GetMapping("/tasks")
    public Iterable<Task> readAll() {
        return taskService.readAll();
    }

    @GetMapping("/tasks/{id}")
    public Task read(@PathVariable("id") long id) {
        return taskService.read(id).orElse(null);
    }

    @PutMapping("/tasks/{id}")
    public Task update(@PathVariable("id") long id, @RequestBody Task task) throws InstanceNotFoundException {
        return taskService.update(id, task);
    }

    @DeleteMapping("/tasks/{id}")
    public void delete(@PathVariable("id") long id) {
        taskService.delete(id);
    }

    @PatchMapping("/tasks/{id}")
    public void patchMethod(@PathVariable("id") Long id, @RequestBody Task task) {
        if (task.isDone()) {
            taskService.markAsDone(id);
        }
    }

    @PatchMapping("/tasks/{id}:mark-as-done")
    public void patchMethod(@PathVariable("id") Long id) {
        taskService.markAsDone(id);
    }

    @GetMapping("/tasks/me")
    public List<Task> getCurrentUserTasks() {
        return userService.getCurrentUserTasks();
    }


}
