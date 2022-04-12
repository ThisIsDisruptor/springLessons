package com.example.demo.service;

import com.example.demo.model.Task;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.management.InstanceNotFoundException;
import java.util.List;
import java.util.Optional;

public interface TaskService {

    Task create(Task task);
    Optional<Task> read(long id);
    Task update(long id, Task task) throws InstanceNotFoundException;
    void delete(long id);

    Iterable<Task> readAll();

    void markAsDone(Long id);

}
