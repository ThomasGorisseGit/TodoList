package fr.gorisse.todoApp.TodoListApp.controller;


import fr.gorisse.todoApp.TodoListApp.entity.User;
import fr.gorisse.todoApp.TodoListApp.services.UserExampleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @Bean
@RequestMapping("/api/user")
public class UserExampleController {

    private final UserExampleService userService;

    public UserExampleController(UserExampleService userService) {
        this.userService = userService;
    }
    
    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        return this.userService.addUser(user);
    }

}
