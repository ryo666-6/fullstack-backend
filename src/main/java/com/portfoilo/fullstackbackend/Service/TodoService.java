package com.portfoilo.fullstackbackend.Service;

import com.portfoilo.fullstackbackend.Model.Todo;
import com.portfoilo.fullstackbackend.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    TodoRepository todoRepository;

    public void addTodo(Todo todo) {
        todoRepository.save(todo);
    }

    public Todo findById(Integer id) {
        Optional<Todo> todo = todoRepository.findById(id);
        return todo.get();
    }
}
