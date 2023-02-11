package com.portfoilo.fullstackbackend.Model;
import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "todos")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Nullable
    @Column(name = "user_id", nullable = false)
    private Integer user_id;

    @NotNull
    @NotBlank
    @Column(name = "title")
    private String title;

    @NotNull
    @NotBlank
    @Column(name = "description")
    private String description;

    @NotNull
    @NotBlank
    @Column(name = "due_date")
    private String due_date;

    @Column(name = "priority")
    private Integer priority;

    @Nullable
    @Column(name = "is_completed")
    private Integer is_completed;

    public Todo() {

    }

    public Todo(Integer user_id, String title, String description, String due_date, Integer priority, Integer is_completed) {
        this.user_id = user_id;
        this.title = title;
        this.description = description;
        this.due_date = due_date;
        this.priority = priority;
        this.is_completed = is_completed;
    }
}
