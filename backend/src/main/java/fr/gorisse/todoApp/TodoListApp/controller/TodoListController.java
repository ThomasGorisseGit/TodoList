package fr.gorisse.todoApp.TodoListApp.controller;

import fr.gorisse.todoApp.TodoListApp.entity.TodoList;
import fr.gorisse.todoApp.TodoListApp.entity.User;
import fr.gorisse.todoApp.TodoListApp.entity.join_table.UseTable;
import fr.gorisse.todoApp.TodoListApp.entity.record.LinkRequest;
import fr.gorisse.todoApp.TodoListApp.services.TodoListService;
import fr.gorisse.todoApp.TodoListApp.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/todolist")
public class TodoListController {
    private final UserService userService;
    private final TodoListService todoListService;

    public TodoListController(UserService userService, TodoListService todoListService){
        this.userService = userService;
        this.todoListService = todoListService;
    }

    // ? Get / find

    // ? Récupère un TodoList depuis son id
    @GetMapping("/find/idList")
    public TodoList findTodoListById(
            @RequestParam int idList
    ){
        return this.todoListService.findTodoListById(idList);
    }

    // ? Récupère la liste des Utilisateurs qui suivent une TodoList (depuis l'id de la TodoList)
    @GetMapping("/find/followers")
    public List<User> findFollowersFromList(
            @RequestParam int idTodolist
    ){
        return this.userService.findFollowersFromList(idTodolist);
    }

    // * Add

    // * Ajoute une TodoList
    @PostMapping("/add")
    public TodoList addTodoList(
            @RequestBody TodoList todoList
    ){

        return this.todoListService.addTodoList(todoList);
    }


    // ! Delete
    @DeleteMapping("/delete")
    public void deleteTodoList(
            @RequestParam int idList
    ){
        this.todoListService.delete(idList);
    }

}
