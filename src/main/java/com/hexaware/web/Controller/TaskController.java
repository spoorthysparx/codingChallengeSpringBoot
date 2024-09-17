package com.hexaware.web.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.web.Entity.Task;
import com.hexaware.web.Service.TaskService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user") 
public class TaskController {
    
    @Autowired
    TaskService taskService;

    @PostMapping("/addTask")
    public ResponseEntity<Task> addTask(@Valid @RequestBody Task t) {
        Task b2 = taskService.addtask(t);
        if (b2 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);    
        } else {
            return new ResponseEntity<>(b2, HttpStatus.CREATED);
        } 
    }

    @GetMapping("/getTaskById/{taskId}")
    public ResponseEntity<Task> getTaskById(@PathVariable int taskId) {
        Task b2 = taskService.getTask(taskId);
        if (b2 == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);    
        } else {
            return new ResponseEntity<>(b2, HttpStatus.OK);
        } 
    }

    @PutMapping("/updateTask/{taskId}")
    public ResponseEntity<String> updateTask(@PathVariable int taskId, @RequestBody Task task) {
        String s = taskService.updateTask(taskId, task);
        if (s == null) {
            return new ResponseEntity<>(s, HttpStatus.NOT_FOUND);    
        } else {
            return new ResponseEntity<>(s, HttpStatus.OK);
        } 
    }

    @DeleteMapping("/removeTask/{taskId}")
    public ResponseEntity<String> deleteTask(@PathVariable int taskId) {
        String s = taskService.deleteTask(taskId);
        if (s == null) {
            return new ResponseEntity<>(s, HttpStatus.NOT_FOUND);    
        } else {
            return new ResponseEntity<>(s, HttpStatus.OK);
        } 
    }

    @GetMapping("/getAllTasks")
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> t = taskService.getAllTasks();
        
        if (t.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);    
        } else {
            return new ResponseEntity<>(t, HttpStatus.OK);
        } 
    }
}
