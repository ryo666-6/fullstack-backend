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
    private Integer userId;

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
    private String dueDate;

    @Column(name = "priority")
    private Integer priority;

    @Nullable
    @Column(name = "is_completed")
    private Integer isCompleted;

    public Todo() {

    }

    public Todo(Integer userId, String title, String description, String dueDate, Integer priority, Integer isCompleted) {
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.isCompleted = isCompleted;
    }
}
