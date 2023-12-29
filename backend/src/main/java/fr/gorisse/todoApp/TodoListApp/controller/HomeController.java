package fr.gorisse.todoApp.TodoListApp.controller;

import fr.gorisse.todoApp.TodoListApp.entity.TodoList;
import fr.gorisse.todoApp.TodoListApp.entity.User;
import fr.gorisse.todoApp.TodoListApp.entity.record.LinkRequest;
import fr.gorisse.todoApp.TodoListApp.entity.value_objects.V_Email;
import fr.gorisse.todoApp.TodoListApp.entity.value_objects.V_Phone;
import fr.gorisse.todoApp.TodoListApp.services.TodoListService;
import fr.gorisse.todoApp.TodoListApp.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeController {

    private final UserService userService;
    private final TodoListService todoListService;

    public HomeController(UserService userService, TodoListService todoListService){
        this.userService = userService;
        this.todoListService = todoListService;
    }

    @GetMapping("/")
    public String home() {
        return "Hello World!";
    }
    //@PathVariable  =>  api/user/find/followers/1
    //@RequestParam => api/user/find/followers?idTodolist=1
    //todo : todolist RestController
    @GetMapping("/find/followers")
    public List<User> findFollowersFromList(
            @RequestParam int idTodolist // idTodolist OU id_todolist
    ){
        return this.userService.findFollowersFromList(idTodolist);
    }


    //todo : todolist RestController
    @PostMapping("/addTodoList")
    public TodoList addTodoList(
            @RequestBody TodoList todoList
    ){

        return this.todoListService.addTodoList(todoList);
    }
    //Todo : on verra plus tard comment on fait / où on le met.
    @PostMapping("/api/addLinkBetweenUserAndTodoList")
    public boolean addLinkBetweenUserAndTodoList(
            @RequestBody LinkRequest linkRequest
            ){
        User user = linkRequest.user();
        TodoList todoList = linkRequest.todoList();
        return this.todoListService.addLinkBetweenUserAndTodoList(user, todoList);
    }

}
