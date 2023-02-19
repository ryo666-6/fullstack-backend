package com.portfoilo.fullstackbackend.Controller;

import com.portfoilo.fullstackbackend.Model.Todo;
import com.portfoilo.fullstackbackend.Model.User;
import com.portfoilo.fullstackbackend.Repository.TodoRepository;
import com.portfoilo.fullstackbackend.Service.TodoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TodoController {

    @Autowired
    TodoRepository todoRepository;

    @Autowired
    TodoService todoService;

    @GetMapping("/todo/{id}")
    public String home(Model model, User user, Todo todo, @PathVariable("id")Integer id) {

        Integer userId = user.getId();
        if(userId == null) {
            return "redirect:/todo/{id}";
        }
        //if文で、今のユーザーidとurlのユーザーを比較して、違ったらログインページへリダイレクト
        //null回避する
        List<Todo> list = todoRepository.find(userId);
        model.addAttribute("list", list);
        model.addAttribute("todo", new Todo(todo.getId(),user.getId(), todo.getTitle(), todo.getDescription(), todo.getDueDate(), todo.getPriority(), todo.getIsCompleted()));
        return "home";
    }

    @PostMapping("/todo/{id}")
    public String createTodo(@Validated Todo todo,BindingResult result, User user) {
        if(result.hasErrors()){
            return "redirect:/todo/{id}";
        }
        Todo userTodo = new Todo(todo.getId() ,user.getId(), todo.getTitle(), todo.getDescription(), todo.getDueDate(), todo.getPriority(), todo.getIsCompleted());
        todoService.addTodo(userTodo);
        System.out.println(userTodo);
        return "redirect:/todo/{id}";
    }

    @PostMapping("/todo/update/{id}")
    public String doneTodo(@RequestParam(name = "todoId",required = false)Integer todoId) {
        System.out.println(todoId);
        Todo updateTodo = todoService.findById(todoId);
        updateTodo.setIsCompleted(true);
        todoService.addTodo(updateTodo);
        return "redirect:/todo/{id}";
    }

    @PostMapping("/todo/edit/{id}")
    public String editTodo(@RequestParam(name = "editId",required = false)Integer todoId, Todo todo, User user ,Model model) {
        System.out.println("edit");
        System.out.println(todoId);
        Todo editTodo = todoService.findById(todoId);
        Integer userId = user.getId();
        Todo nextTodo = new Todo(editTodo.getId(),user.getId(),todo.getTitle(),todo.getDescription(), todo.getDueDate(),todo.getPriority(),todo.getIsCompleted());
        todoService.addTodo(nextTodo);
        model.addAttribute("nextTodo", nextTodo);
        System.out.println(nextTodo);
        return "redirect:/todo/{id}";
    }

    @PostMapping("/todo/delete/{id}")
    public String deleteTodo() {
        System.out.println("delete");
        todoService.deleteAllTodo();
        return "redirect:/todo/{id}";
    }
}
