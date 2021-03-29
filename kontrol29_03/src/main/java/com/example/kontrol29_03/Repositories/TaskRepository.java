package com.example.kontrol29_03.Repositories;

import com.example.kontrol29_03.Models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
@Service
public interface TaskRepository extends JpaRepository<Task, Integer> {
    public List<Task> findAll();

    public Task findTasksById(Long id);
}
