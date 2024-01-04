package fr.gorisse.todoApp.TodoListApp.controller;

import fr.gorisse.todoApp.TodoListApp.entity.TodoList;
import fr.gorisse.todoApp.TodoListApp.entity.User;
import fr.gorisse.todoApp.TodoListApp.entity.join_table.UseTable;
import fr.gorisse.todoApp.TodoListApp.entity.record.LinkRequest;
import fr.gorisse.todoApp.TodoListApp.services.TodoListService;
import fr.gorisse.todoApp.TodoListApp.services.UseTableService;
import fr.gorisse.todoApp.TodoListApp.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/useTable")
public class UseTableControler {
    private final UseTableService useTableService;
    private final TodoListService todoListService;

    private final UserService userService;

    public UseTableControler(UseTableService useTableService, TodoListService todoListService, UserService userService) {
        this.useTableService = useTableService;
        this.todoListService = todoListService;
        this.userService = userService;
    }

    // ? Get / find

    // ? Récupère une UseTable l'id de la TodoList
    @GetMapping("/find/idList")
    public UseTable findUseTableByIdList(
            @RequestParam int idList
    ){
        TodoList todoList = this.todoListService.findTodoListById(idList);
        return this.useTableService.findUseTableByTodoList(todoList);
    }

    // ? Récupère une UseTable l'id de l'utilisateur
    @GetMapping("/find/idUser")
    public List<UseTable> findUseTableByFollower(
            @RequestParam int idUser
    ){
        User user = this.userService.findUserById(idUser);
        return this.useTableService.findUseTableByFollower(user);
    }
    // ? Dit si il existe un lien etre un utilisateur et une TodoList
    // ? Si l'utilisateur suit la TodoList
    @GetMapping("/link/is")
    public boolean isLinkBetweenUserAndTodoList(
            @RequestParam int idUser,
            @RequestParam int idTodoList
    ){
        User user = this.userService.findUserById(idUser);
        TodoList todoList = this.todoListService.findTodoListById(idTodoList);
        return this.useTableService.isLinkUserAndTodoList(user, todoList);
    }

    // * Add

    // * Ajoute un lien entre un utilisateur et une TodoList
    // TODO : Doit ajouter des liens entre toutes les taches de la TodoList et l'utilisateur (en fontion du type de la TodoList)
    @PostMapping("/link/add")
    public UseTable addLinkBetweenUserAndTodoList(
            @RequestBody LinkRequest linkRequest
    )  {
        User user = linkRequest.user();
        TodoList todoList = linkRequest.todoList();

        Optional<UseTable> resTable = this.useTableService.addLinkUserTodoList(user, todoList);

        return resTable.orElseThrow(
                () -> new EntityNotFoundException("Impossible de créer le lien entre l'utilisateur et la liste")
        );
    }

    // ! Delete
    //Todo  : supprimer le lien entre un utilisateur et une TodoList
}
