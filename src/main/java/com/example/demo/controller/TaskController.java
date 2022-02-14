package com.example.demo.controller;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.management.InstanceNotFoundException;

@RestController
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    @PostMapping("/tasks")
    public Task create(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    @GetMapping("/tasks")
    public Iterable<Task> readAll() {
        return taskRepository.findAll();
    }

    @GetMapping("/tasks/{id}")
    public Task read(@PathVariable("id") long id) {
        return taskRepository.findById(id).orElse(null);
    }

    @PutMapping("/tasks/{id}")
    public Task update(@PathVariable("id") long id, @RequestBody Task task) throws InstanceNotFoundException {
        if(!taskRepository.existsById(id)) {
            throw new InstanceNotFoundException();
        }

        Task updatedTask = new Task();
        updatedTask.setId(id);
        updatedTask.setDate(task.getDate());
        updatedTask.setDescription(task.getDescription());
        updatedTask.setDone(task.isDone());
        return taskRepository.save(updatedTask);
    }

    @DeleteMapping("/tasks/{id}")
    public void delete(@PathVariable("id") long id) {
        taskRepository.deleteById(id);
    }

    @PatchMapping("/tasks/{id}")
    public void patchMethod(@PathVariable("id") Long id, @RequestBody Task task) {
        if (task.isDone()) {
            taskRepository.markAsDone(id);
        }
    }

    @PatchMapping("/tasks/{id}:mark-as-done")
    public void patchMethod(@PathVariable("id") Long id) {
        taskRepository.markAsDone(id);
    }
}
