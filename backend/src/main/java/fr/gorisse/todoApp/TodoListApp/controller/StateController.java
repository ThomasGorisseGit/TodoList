package fr.gorisse.todoApp.TodoListApp.controller;

import fr.gorisse.todoApp.TodoListApp.entity.join_table.State;
import fr.gorisse.todoApp.TodoListApp.services.StateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/state")
public class StateController {

    private final StateService stateService;


    public StateController(StateService stateService) {
        this.stateService = stateService;
    }

    @GetMapping("/find/idUser")
    public List<State> findStateByIdUser(
            @RequestParam int idUser
    ){
        return this.stateService.findStateByUser(idUser);
    }

    @GetMapping("/find/idTask")
    public List<State> findStateByIdTask(
            @RequestParam int idTask
    ){
        return this.stateService.findStateByTaskId(idTask);
    }

}
