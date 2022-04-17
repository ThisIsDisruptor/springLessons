package com.example.demo.service.impl;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.management.InstanceNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserServiceImpl userService;

    public Task create(Task task) {
        task.setUser(userService.getCurrentUser());
        return taskRepository.save(task);
    }

    public Iterable<Task> readAll() {
        return taskRepository.findAll();
    }

    public Optional<Task> read(long id) {
        return taskRepository.findById(id);
    }

    public Task update(long id, Task task) throws InstanceNotFoundException {
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

    public void delete(long id) {
        taskRepository.deleteById(id);
    }

    public void markAsDone(Long id) {
            taskRepository.markAsDone(id);
    }

}
