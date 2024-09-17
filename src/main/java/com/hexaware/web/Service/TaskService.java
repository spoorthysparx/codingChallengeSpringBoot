package com.hexaware.web.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.web.Dao.TaskRepository;
import com.hexaware.web.Entity.Task;

import jakarta.validation.Valid;

@Service
public class TaskService {
	
	@Autowired
	TaskRepository taskRepository;

	public Task addtask(@Valid Task t) {
		int id = t.getTaskId();
		Task task = taskRepository.findById(id).orElse(null);
		if(task==null) {
			taskRepository.save(t);
			return t;
		}
		else {
			return null;
		}
		
	}

	public Task getTask(int taskId) {
		Task t= taskRepository.findById(taskId).orElse(null);
		if (t!=null) {
			return t;
		}
		else {
		
		return null;}
	}

	public String updateTask(int taskId, Task task) {
		
		Task t= taskRepository.findById(taskId).orElse(null);
		if(t!=null) {
		if (task.getTitle()!= null) {
	        t.setTitle(task.getTitle());
	    }
	    if (task.getDescription() != null) {
	        t.setDescription(task.getDescription());
	    }
	    if (task.getDueDate() != null) {
	    	t.setDueDate(task.getDueDate());
	    }
	    if(task.getPriority()!=null) {
	    	t.setPriority(task.getPriority());
	    }
	    if(task.getStatus()!=null) {
	    	t.setStatus(task.getStatus());
	    }

	    taskRepository.save(t);
	    return "Task updated";}
	else {
		return "task not found";
	}
		
	       
	}

	public String deleteTask(int taskId) {
		Task t= taskRepository.findById(taskId).orElse(null);
		
		if(t!=null) {
			taskRepository.deleteById(taskId);
			return "task deleted successfully";
		}
		else {
			return "task not found";
		}
	}

	public List<Task> getAllTasks() {
		
		List<Task> t = taskRepository.findAll();
		
		return t;
	}
	
	
	
	

}
