package fr.gorisse.todoApp.TodoListApp.controller;

import fr.gorisse.todoApp.TodoListApp.entity.User;
import fr.gorisse.todoApp.TodoListApp.entity.value_objects.V_Email;
import fr.gorisse.todoApp.TodoListApp.entity.value_objects.V_Phone;
import fr.gorisse.todoApp.TodoListApp.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HomeController {

    private final UserService userService;

    public HomeController(UserService userService){
        this.userService = userService;
    }


    @GetMapping("/")
    public User home() {
        return new User(1,"","","", V_Email.createEmail("thomas.gorisse08@gmail.com"),"", V_Phone.createPhone("0786910105"),null);
    }
    @GetMapping("/api/findUserFromList/{id}")
    public List<User> getUserFromList(@PathVariable("id")int id){
        return this.userService.findUserFromList(id);
    }
    @GetMapping("/api/findUserFromList")
    public List<User> getUserFromListwithrequestParam(@RequestParam int id){
        return this.userService.findUserFromList(id);
    }
    @PostMapping("/addUser")
    public User addUser(
            @RequestBody User user
    ){
        return user;
    }

    /*
    @GetMapping("/secured")
    public String secured() {
        return "Hello World Secured";
    }

   */
}
