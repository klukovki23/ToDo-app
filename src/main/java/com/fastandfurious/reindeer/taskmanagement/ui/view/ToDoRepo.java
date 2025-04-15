package com.fastandfurious.reindeer.taskmanagement.ui.view;

import org.springframework.data.jpa.repository.JpaRepository;



public interface ToDoRepo  extends JpaRepository<ToDo, Long>{
    
}
