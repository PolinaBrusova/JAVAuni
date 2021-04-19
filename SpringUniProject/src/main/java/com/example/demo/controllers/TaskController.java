package com.example.demo.controllers;

import com.example.demo.models.Task;
import com.example.demo.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("trello")
public class TaskController {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping(value = "/AllTasks")
    private ResponseEntity<List<Task>> getAll(){
        final List<Task> tasks = taskRepository.findAll();
        if (!tasks.isEmpty()){
            return new ResponseEntity<>(tasks, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/task/id={id}")
    public ResponseEntity<Task> getTask(@PathVariable Long id) {
        final Task found = taskRepository.findTaskByRowId(id);
        if (found != null){
            return new ResponseEntity<>(found, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value="AddTask")
    private ResponseEntity<?> create(@RequestBody Task task){
        Task newTask = taskRepository.save(task);
        return new ResponseEntity<>(newTask, HttpStatus.CREATED);
    }

    @PutMapping(value = "PutTask")
    public ResponseEntity<?> put(@RequestBody Task task) {
        return new ResponseEntity<>(taskRepository.save(task),HttpStatus.OK);
    }

    @DeleteMapping(value = "task/id={id}")
    public ResponseEntity<Task> delete(@PathVariable long id) {
        taskRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
