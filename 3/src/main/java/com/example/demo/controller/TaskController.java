package com.example.demo.controller;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @PostMapping("/tasks")
    public Task create(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    @GetMapping(value = {"/tasks", "/tasks/{id}"})
    public List<Task> getTasks(@PathVariable(required = false) Long id){
        if (id != null) {
            List<Task> tasks = new ArrayList<>();
            tasks.add(taskRepository.findById(id).orElse(null));
            return tasks;
        }
        return (List<Task>) taskRepository.findAll();
    }

    @PutMapping(value = "/tasks/{id}")
    public Task changeTask(@RequestBody Task task, @PathVariable Long id){
        if (taskRepository.findById(id).orElse(null) != null) {
            task.setId(id);
            return taskRepository.save(task);
        }
        return null;
    }

    @DeleteMapping("/tasks/{id}")
    public void deleteTask(@PathVariable Long id) {
        if (taskRepository.findById(id).orElse(null) != null) {
            taskRepository.deleteById(id);
        }
    }

    @PatchMapping("/tasks/{id}")
    public void patchMethod(@PathVariable Long id, @RequestBody Task task){
        if (task.isDone())
            taskRepository.markAsDone(id);
    }

    @PatchMapping("/tasks/{id}:mark-as-done")
    public void patchMethod(@PathVariable Long id){
        taskRepository.markAsDone(id);
    }

}