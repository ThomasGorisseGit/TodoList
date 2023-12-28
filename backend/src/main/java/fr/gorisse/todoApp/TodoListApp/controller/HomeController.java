package fr.gorisse.todoApp.TodoListApp.controller;

import fr.gorisse.todoApp.TodoListApp.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HomeController {


    @GetMapping("/")
    public String home() {
        return "Hello World";
    }

    @GetMapping("/secured")
    public String secured() {
        return "Hello World Secured";
    }
}
