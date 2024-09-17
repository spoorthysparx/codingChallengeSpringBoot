package com.hexaware.web;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.web.Dao.TaskRepository;
import com.hexaware.web.Entity.Task;

@SpringBootTest
class ApplicationTests {
	
	@Autowired
	TaskRepository taskRepository;

	@Test
	void addTask() {
		Task task = new Task();
		task.setTitle("games");
		task.setDescription("buy games");
		task.setDueDate(LocalDate.parse("2023-11-08"));
		task.setPriority("high");
		task.setStatus("completed");
		
		taskRepository.save(task);
	}
	
	@Test
	void deleteTask() {
		taskRepository.deleteById(1);
	}
	
	@Test
	void updateTask() {
		Task actualTask = taskRepository.findById(3).orElse(null);
		
		actualTask.setTitle("laptop");
		
		taskRepository.save(actualTask);
		
		assertEquals(actualTask.getTitle(), "laptop", "");
	}
	
	@Test
	void getTaskById() {
		Task actualTask = taskRepository.findById(3).orElse(null);
		
		
		Task expectedTask = new Task();
		expectedTask.setTitle("laptop");
		
		assertEquals(actualTask.getTitle(), expectedTask.getTitle(), "");
	}
	
	@Test 
	void getAllHotels() {
		List<Task> actualTaskList = taskRepository.findAll();
		int listSize = actualTaskList.size();
		
		assertEquals(4, listSize);
	}


}
