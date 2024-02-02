package com.example.todo.repository;

import com.example.todo.model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TodoRepository extends JpaRepository<Tasks,Integer> {

    @Query(value="select * from task where title=?1 limit 1",nativeQuery = true)
    Tasks findByTitle(String title);

    @Query(value = "select id from task where title=?1 limit 1",nativeQuery = true)
    int findIdByTitle(String title);
}
