package com.portfoilo.fullstackbackend.Model;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@Table(name = "todos")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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

//    @ManyToOne
//    @JoinColumn(name = "user_id", insertable=false, updatable=false)
//    private User user;
}
