package fr.gorisse.todoApp.TodoListApp.controller;

import fr.gorisse.todoApp.TodoListApp.entity.User;
import fr.gorisse.todoApp.TodoListApp.entity.value_objects.V_Email;
import fr.gorisse.todoApp.TodoListApp.entity.value_objects.V_Phone;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HomeController {


    @GetMapping("/")
    public User home() {
        return new User(1,"","","", V_Email.createEmail("thomas.gorisse08@gmail.com"),"", V_Phone.createPhone("0786910105"),null);
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
