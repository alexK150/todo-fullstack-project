package com.example.todofullstackproject.controllers;

import com.example.todofullstackproject.domain.Task;
import com.example.todofullstackproject.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("")
    public ResponseEntity<?> createNewTask(@Valid @RequestBody Task task, BindingResult result){

        Map<String, String> mappedErrors = new HashMap<>();

        for (FieldError error: result.getFieldErrors()){
            mappedErrors.put(error.getField(), error.getDefaultMessage());
        }

        if (result.hasErrors()){
            return new ResponseEntity<Map<String, String>>(mappedErrors, HttpStatus.BAD_REQUEST);
        }

        Task task1 = taskService.saveOrUpdateTask(task);
        return new ResponseEntity<Task>(task1, HttpStatus.CREATED);
    }
}
