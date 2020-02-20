package com.example.todofullstackproject.repos;

import com.example.todofullstackproject.domain.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepo extends CrudRepository<Task, Long> {
}
