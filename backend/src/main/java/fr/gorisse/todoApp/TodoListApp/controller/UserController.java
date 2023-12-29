package fr.gorisse.todoApp.TodoListApp.controller;

import fr.gorisse.todoApp.TodoListApp.entity.TodoList;
import fr.gorisse.todoApp.TodoListApp.entity.User;
import fr.gorisse.todoApp.TodoListApp.services.TodoListService;
import fr.gorisse.todoApp.TodoListApp.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Is a Bean -> Injection de dépendance
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    private final TodoListService todoListService;

    public UserController(UserService userService, TodoListService todoListService) {
        this.userService = userService;
        this.todoListService = todoListService;
    }




    // api/user/add
    @PostMapping("/add")
    public User addUser(
            @RequestBody User user
    ){
        return userService.addUser(user);
    }

    // api/user/find/list?idUser=1
    @GetMapping("/find/list")
    public List<TodoList> findListFromUser(@RequestParam int idUser){
        return this.todoListService.findListFromUser(idUser);
    }


    @PostMapping("/edit/informations")
    public User editUserInformations(
            @RequestBody User user
    ){
        return this.userService.addUser(user);
    }



}
