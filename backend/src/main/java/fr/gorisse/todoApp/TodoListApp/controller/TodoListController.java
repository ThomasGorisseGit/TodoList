package fr.gorisse.todoApp.TodoListApp.controller;

import fr.gorisse.todoApp.TodoListApp.entity.TodoList;
import fr.gorisse.todoApp.TodoListApp.entity.User;
import fr.gorisse.todoApp.TodoListApp.entity.join_table.UseTable;
import fr.gorisse.todoApp.TodoListApp.entity.record.LinkRequest;
import fr.gorisse.todoApp.TodoListApp.services.TodoListService;
import fr.gorisse.todoApp.TodoListApp.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/todolist")
public class TodoListController {
    private final UserService userService;
    private final TodoListService todoListService;

    public TodoListController(UserService userService, TodoListService todoListService){
        this.userService = userService;
        this.todoListService = todoListService;
    }

    @PostMapping("/addTodoList")
    public TodoList addTodoList(
            @RequestBody TodoList todoList
    ){

        return this.todoListService.addTodoList(todoList);
    }

    @PostMapping("/addLinkBetweenUserAndTodoList")
    public Optional<UseTable> addLinkBetweenUserAndTodoList(
            @RequestBody LinkRequest linkRequest
    ){
        User user = linkRequest.user();
        TodoList todoList = linkRequest.todoList();
        return this.todoListService.addLinkBetweenUserAndTodoList(user, todoList);
    }


}
