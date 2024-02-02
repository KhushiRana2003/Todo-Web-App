package com.example.todo.service;

import com.example.todo.model.Tasks;
import com.example.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public List<Tasks> findAllTasks(){
        return todoRepository.findAll();
    }

    public Tasks findTaskByTitle(String title){
        return todoRepository.findByTitle(title);
    }

    public String deleteTask(String title){
        int id = todoRepository.findIdByTitle(title);
        todoRepository.deleteById(id);
        return "task deleted";
    }

    public Tasks updateTask(Tasks tasks){
        Tasks existingTask = todoRepository.findById(tasks.getId()).orElse(null);
        existingTask.setTitle(tasks.getTitle());
        existingTask.setDescription(tasks.getDescription());
        existingTask.setCreatedAt(tasks.getCreatedAt());
        existingTask.setCompleted(tasks.isCompleted());
        return todoRepository.save(existingTask);
    }

    public Tasks addTask(Tasks task) {
        return todoRepository.save(task);
    }
}
