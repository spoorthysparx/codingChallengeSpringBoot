package com.hexaware.web.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.web.Entity.Task;


@Repository
public interface TaskRepository extends JpaRepository<Task,Integer>{

}
