package fr.gorisse.todoApp.TodoListApp.controller;

import fr.gorisse.todoApp.TodoListApp.entity.TodoList;
import fr.gorisse.todoApp.TodoListApp.entity.User;
import fr.gorisse.todoApp.TodoListApp.entity.join_table.UseTable;
import fr.gorisse.todoApp.TodoListApp.services.TodoListService;
import fr.gorisse.todoApp.TodoListApp.services.UseTableService;
import fr.gorisse.todoApp.TodoListApp.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/find/idList")
    public UseTable findUseTableByIdList(
            @RequestParam int idList
    ){
        TodoList todoList = this.todoListService.findTodoListById(idList);
        return this.useTableService.findUseTableByTodoList(todoList);
    }

    @GetMapping("/find/idUser")
    public UseTable findUseTableByFollower(
            @RequestParam int idUser
    ){
        User user = this.userService.findUserById(idUser);
        return this.useTableService.findUseTableByFollower(user);
    }
}
