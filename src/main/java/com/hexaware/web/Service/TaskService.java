package com.hexaware.web.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.web.Dao.TaskRepository;
import com.hexaware.web.Entity.Task;
import com.hexaware.web.Exception.IdNotFoundException;

import jakarta.validation.Valid;

@Service
public class TaskService {
    
    @Autowired
    TaskRepository taskRepository;

    public Task addtask(@Valid Task t) {
        int id = t.getTaskId();
        Task task = taskRepository.findById(id).orElse(null);
        if(task == null) {
            taskRepository.save(t);
            return t;
        } else {
            throw new IdNotFoundException("Task with ID " + id + " already exists.");
        }
    }

    public Task getTask(int taskId) {
        return taskRepository.findById(taskId)
                .orElseThrow(() -> new IdNotFoundException("Task with ID " + taskId + " not found."));
    }

    public String updateTask(int taskId, Task task) {
        Task t = taskRepository.findById(taskId)
                .orElseThrow(() -> new IdNotFoundException("Task with ID " + taskId + " not found."));
        
        if (task.getTitle() != null) {
            t.setTitle(task.getTitle());
        }
        if (task.getDescription() != null) {
            t.setDescription(task.getDescription());
        }
        if (task.getDueDate() != null) {
            t.setDueDate(task.getDueDate());
        }
        if (task.getPriority() != null) {
            t.setPriority(task.getPriority());
        }
        if (task.getStatus() != null) {
            t.setStatus(task.getStatus());
        }

        taskRepository.save(t);
        return "Task updated successfully";
    }

    public String deleteTask(int taskId) {
        Task t = taskRepository.findById(taskId)
                .orElseThrow(() -> new IdNotFoundException("Task with ID " + taskId + " not found."));
        
        taskRepository.deleteById(taskId);
        return "Task deleted successfully";
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
}