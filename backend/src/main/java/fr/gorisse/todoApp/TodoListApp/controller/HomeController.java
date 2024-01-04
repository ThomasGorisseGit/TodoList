package fr.gorisse.todoApp.TodoListApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    public HomeController(){
    }

    @GetMapping("/")
    public String home() {
        return "Hello World!";
    }


}
