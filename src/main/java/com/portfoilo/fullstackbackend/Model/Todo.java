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
    @NotBlank(message = "タイトルを入力してください")
    @Column(name = "title")
    private String title;

    @NotNull
    @NotBlank(message = "詳細を入力してください")
    @Column(name = "description")
    private String description;

    @NotNull
    @NotBlank(message = "日付を入力してください")
    @Column(name = "due_date")
    private String dueDate;

    @Column(name = "priority")
    private Integer priority = 2;

    @NotNull
    @Column(name = "is_completed")
    private Boolean isCompleted = false;

    @NotNull
    @Column(name = "is_deleted")
    private Boolean isDeleted = false;

    public Todo() {

    }

    public Todo(Integer id, Integer userId, String title, String description, String dueDate, Integer priority, Boolean isCompleted, Boolean isDeleted) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.isCompleted = isCompleted;
        this.isDeleted = isDeleted;
    }
}
