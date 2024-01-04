package fr.gorisse.todoApp.TodoListApp.controller;

import fr.gorisse.todoApp.TodoListApp.exception.EmailAlreadyExistException;
import fr.gorisse.todoApp.TodoListApp.exception.UsernameAlreadyExistException;
import fr.gorisse.todoApp.TodoListApp.entity.TodoList;
import fr.gorisse.todoApp.TodoListApp.entity.User;
import fr.gorisse.todoApp.TodoListApp.services.TodoListService;
import fr.gorisse.todoApp.TodoListApp.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    // ? Get / find

    // ? Récupère un utilisateur par id
    @GetMapping("/find/idUser")
    public User findUserById(
            @RequestParam int idUser
    ){
        return this.userService.findUserById(idUser);
    }

    // ? Récupère la liste des TodoList d'un utilisateur (qu'il suit)
    @GetMapping("/find/list")
    public List<TodoList> findListFromUser(@RequestParam int idUser){
        return this.todoListService.findListEnableFromUser(idUser);
    }


    // * Add

    // * Ajoute un utilisateur
    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);

    }



    // * Modifie les informations d'un utilisateur
    @PostMapping("/edit/informations")
    public User editUserInformations(
            @RequestBody User user
    ){
        return this.userService.addUser(user);
    }

    // ! Delete


}
