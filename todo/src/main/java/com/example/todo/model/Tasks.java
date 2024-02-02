package com.example.todo.model;

//import javax.persistence.*;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="task")
public class Tasks {

    @Id
    @GeneratedValue
    private int id;

    private String title;
    private String description;
    private LocalDateTime createdAt;
    private boolean completed;

}
