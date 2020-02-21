package com.example.todofullstackproject.services;

import com.example.todofullstackproject.domain.Task;
import com.example.todofullstackproject.repos.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskRepo taskRepo;

    public Task saveOrUpdateTask(Task task){

        return taskRepo.save(task);
    }
}
