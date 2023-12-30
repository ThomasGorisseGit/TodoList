package fr.gorisse.todoApp.TodoListApp.controller;

import fr.gorisse.todoApp.TodoListApp.controller.exception.EmailAlreadyExistException;
import fr.gorisse.todoApp.TodoListApp.controller.exception.UsernameAlreadyExistException;
import fr.gorisse.todoApp.TodoListApp.entity.TodoList;
import fr.gorisse.todoApp.TodoListApp.entity.User;
import fr.gorisse.todoApp.TodoListApp.services.TodoListService;
import fr.gorisse.todoApp.TodoListApp.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // Is a Bean -> Injection de dépendance
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    private final TodoListService todoListService;

    public UserController(UserService userService, TodoListService todoListService) {
        this.userService = userService;
        this.todoListService = todoListService;
    }

    @GetMapping("/find/idUser")
    public User findUserById(
            @RequestParam int idUser
    ){
        return this.userService.findUserById(idUser).orElseThrow(
                () -> new EntityNotFoundException("Pas d'utilisateur avec l'id : " + idUser)
        );
    }

    // api/user/add
//    @PostMapping("/add")
//    public User addUser(
//            @RequestBody User user
//    ){
//        return userService.addUser(user);
//    }

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        try {
            userService.addUser(user);
            return new ResponseEntity<>("Utilisateur ajouté avec succès", HttpStatus.OK);
        } catch (EmailAlreadyExistException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (UsernameAlreadyExistException e) {
            System.out.println("NULLL");
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            // Gérez d'autres exceptions ici
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // api/user/find/list?idUser=1
    @GetMapping("/find/list")
    public List<TodoList> findListFromUser(@RequestParam int idUser){
        return this.todoListService.findListEnableFromUser(idUser);
    }


    @PostMapping("/edit/informations")
    public User editUserInformations(
            @RequestBody User user
    ){
        return this.userService.addUser(user);
    }



}
