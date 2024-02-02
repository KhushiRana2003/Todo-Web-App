package com.example.todo.controller;

import com.example.todo.model.Tasks;
import com.example.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/allTasks")
    public List<Tasks> findAllTasks(){
        return todoService.findAllTasks();
    }

    @PostMapping("/addTask")
    public Tasks addTask(@RequestBody Tasks task){
        return todoService.addTask(task);
    }

    @GetMapping("/tasks/{title}")
    public Tasks findByTitle(@PathVariable String title){
        return todoService.findTaskByTitle(title);
    }

    @PutMapping("/update")
    public Tasks updateTask(@RequestBody Tasks task){
        return todoService.updateTask(task);
    }

    @DeleteMapping("/delete/{title}")
    public String deleteTask(@PathVariable String title){
        return todoService.deleteTask(title);
    }
}
