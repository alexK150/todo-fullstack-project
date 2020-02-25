package com.example.todofullstackproject.controllers;

import com.example.todofullstackproject.domain.Task;
import com.example.todofullstackproject.services.MappedErrorsValidationService;
import com.example.todofullstackproject.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private MappedErrorsValidationService mappedErrorsValidationService;

    @PostMapping("")
    public ResponseEntity<?> createNewTask(@Valid @RequestBody Task task, BindingResult result) {

        ResponseEntity<?> errorMap = mappedErrorsValidationService.MappedErrorsValidationService(result);

        if (errorMap != null) return errorMap;

        Task task1 = taskService.saveOrUpdateTask(task);
        return new ResponseEntity<Task>(task1, HttpStatus.CREATED);
    }
}
