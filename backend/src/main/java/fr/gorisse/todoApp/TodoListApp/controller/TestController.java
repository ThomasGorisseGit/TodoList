package fr.gorisse.todoApp.TodoListApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/")
    public String home() {
        return "Hello World";
    }

    @GetMapping("/secured")
    public String secured() {
        return "Hello World Secured";
    }
}
