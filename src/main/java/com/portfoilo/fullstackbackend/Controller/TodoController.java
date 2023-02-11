package com.portfoilo.fullstackbackend.Controller;

import com.portfoilo.fullstackbackend.Model.Todo;
import com.portfoilo.fullstackbackend.Model.User;
import com.portfoilo.fullstackbackend.Repository.TodoRepository;
import com.portfoilo.fullstackbackend.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TodoController {

    @Autowired
    TodoRepository todoRepository;

    @Autowired
    TodoService todoService;

    @GetMapping("/todo/{id}")
    public String home(@PathVariable("id")Integer id, Model model, User user, Todo todo) {
        Integer userId = user.getId();
        //if文で、今のユーザーidとurlのユーザーを比較して、違ったらログインページへリダイレクト
        List<Todo> list = todoRepository.find(userId);
        model.addAttribute("list", list);
        model.addAttribute("todo", new Todo(user.getId(), todo.getTitle(), todo.getDescription(), todo.getDue_date(), todo.getPriority(), todo.getIs_completed()));
        return "home";
    }

    @PostMapping("/todo/{id}")
    public String createTodo(@Validated Todo todo, @PathVariable("id")Integer id , BindingResult result, User user) {
        if(result.hasErrors()){
            return "home";
        }

        Todo userTodo = new Todo(user.getId(), todo.getTitle(), todo.getDescription(), todo.getDue_date(), todo.getPriority(), todo.getIs_completed());
        todoService.addTodo(userTodo);
        return "redirect:/todo/{id}";
    }

    @RequestMapping("/todo/edit/{id}")
    public String editTodo(Todo todo, User user, @PathVariable("id")Integer id) {
        return "redirect:/todo/{id}";

    }
}
