package com.example.todofullstackproject.controllers;

import com.example.todofullstackproject.domain.Task;
import com.example.todofullstackproject.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("")
    public ResponseEntity<Task> createNewTask(@RequestBody Task task){
        Task task1 = taskService.saveOrUpdateTask(task);
        return new ResponseEntity<Task>(task, HttpStatus.CREATED);
    }
}
