package com.portfoilo.fullstackbackend.Service;

import com.portfoilo.fullstackbackend.Model.Todo;
import com.portfoilo.fullstackbackend.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        Optional<Todo> updateTodo = todoRepository.findById(id);
        return updateTodo.get();
    }

    public void deleteAllTodo() {
        List<Todo> allTodo = todoRepository.findAll();
        List<Todo> doneList = new ArrayList<>();
        for (Todo todo : allTodo) {
            if (todo.getIsCompleted()) {
                doneList.add(todo);
            }
        }
        todoRepository.deleteAll(doneList);
    }
}
