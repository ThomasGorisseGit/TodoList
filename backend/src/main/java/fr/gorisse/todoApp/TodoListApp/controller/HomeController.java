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
    public User home() {
        return new User(1,"","","", V_Email.createEmail("thomas.gorisse08@gmail.com"),"", V_Phone.createPhone("1234567890"),null);
    }
    @GetMapping("/api/followersList/{idList}")
    public List<User> getUserFromList(@PathVariable("idList")int id){
        return this.userService.findUserFromList(id);
    }

    @GetMapping("/api/homePageList/{idUser}")
    public List<TodoList> getTodoListFromIdUser(@PathVariable("idUser")int id){
        return this.todoListService.getTodoListEnableByIdUser(id);
    }
    @GetMapping("/api/followersList")
    public List<User> getUserFromListWithRequestParam(@RequestParam int id){
        return this.userService.findUserFromList(id);
    }
    @PostMapping("/addUser")
    public User addUser(
            @RequestBody User user
    ){
        return userService.addUser(user);
    }

    @PostMapping("/addStringUser")
    public User addStringUser(
            @RequestParam String lastName,
            @RequestParam String firstName,
            @RequestParam String username,
            @RequestParam V_Email email,
            @RequestParam String password,
            @RequestParam V_Phone phone
    ){
        return this.userService.addStringUser(lastName, firstName, username, email, password, phone);
    }

    @PostMapping("/UserPage/modifyUsername")
    public User modifyUsername(
            @RequestParam String username,
            @RequestParam Integer idUser
    ){
        return this.userService.modifyUsername(username, idUser);
    }

    @PostMapping("/addTodoList")
    public TodoList addTodoList(
            @RequestBody TodoList todoList
    ){

        return this.todoListService.addTodoList(todoList);
    }

    @PostMapping("/api/addLinkBetweenUserAndTodoList")
    public boolean addLinkBetweenUserAndTodoList(
            @RequestBody LinkRequest linkRequest
            ){
        User user = linkRequest.user();
        TodoList todoList = linkRequest.todoList();
        return this.todoListService.addLinkBetweenUserAndTodoList(user, todoList);
    }



    /*
    @GetMapping("/secured")
    public String secured() {
        return "Hello World Secured";
    }

   */
}
