package com.hexaware.web.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private int taskId;

    @NotBlank(message = "Title is required")
    @Size(max = 100, message = "Title cannot exceed 100 characters")
    @Column(name = "title", nullable = false)
    private String title;

    @Size(max = 500, message = "Description cannot exceed 500 characters")
    @Column(name = "description")
    private String description;

    @Column(name = "due_date")
    private LocalDate dueDate;

    @NotBlank(message = "Priority is required")
    @Pattern(regexp = "low|medium|high", message = "Priority must be one of the following: LOW, MEDIUM, HIGH")
    @Column(name = "priority", nullable = false)
    private String priority;

    @NotBlank(message = "Status is required")
    @Pattern(regexp = "pending|in progress|completed", message = "Status must be one of the following: PENDING, IN_PROGRESS, COMPLETED")
    @Column(name = "status", nullable = false)
    private String status;


    public Task() {}

    public Task(String title, String description, LocalDate dueDate, String priority, String status) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.status = status;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    @Override
    public String toString() {
        return "Task [taskId=" + taskId + ", title=" + title + ", description=" + description +
                ", dueDate=" + dueDate + ", priority=" + priority + ", status=" + status + "]";
    }
}