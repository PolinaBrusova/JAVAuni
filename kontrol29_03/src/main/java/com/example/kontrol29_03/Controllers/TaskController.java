package com.example.kontrol29_03.Controllers;

import com.example.kontrol29_03.Models.Task;
import com.example.kontrol29_03.Repositories.TaskRepository;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Kr29")
public class TaskController {
    private final TaskRepository taskRepository;


    public TaskController(TaskRepository taskRepository) {
        this.taskRepository=taskRepository;
    }

    @PostMapping("/addTask")
    Task createTask(@RequestBody Task task) {
        return this.taskRepository.save(task);
    }

    @GetMapping("/getTask={id}")
    Task getTask(@PathVariable Long id) {
        return this.taskRepository.findTasksById(id);
    }

    @GetMapping("/AllTasks")
    List<Task> getTasks() {
        return this.taskRepository.findAll();
    }
}
