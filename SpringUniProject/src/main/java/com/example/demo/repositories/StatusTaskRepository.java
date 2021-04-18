package com.example.demo.repositories;

import com.example.demo.models.StatusTask;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StatusTaskRepository extends JpaRepository<StatusTask, Long> {
    List<StatusTask> findAll();
    StatusTask findStatusTaskByRowId(long id);
}
