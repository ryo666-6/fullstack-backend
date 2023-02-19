package com.portfoilo.fullstackbackend.Service;

import com.portfoilo.fullstackbackend.Model.Todo;
import com.portfoilo.fullstackbackend.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    TodoRepository todoRepository;

    public List<Todo> searchAll() {
        return todoRepository.findAll();
    }

    public void addTodo(Todo todo) {
        todoRepository.save(todo);
    }

    public Todo findById(Integer id) {
        Optional<Todo> todo = todoRepository.findById(id);
        return todo.get();
    }

    public List<Todo> orderByDate(Todo todo) {
        return todoRepository.findAll(Sort.by(Sort.Direction.ASC, "dueDate"));
    }
}
