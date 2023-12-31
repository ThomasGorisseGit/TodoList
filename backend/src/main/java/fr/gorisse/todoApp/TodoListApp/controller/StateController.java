package fr.gorisse.todoApp.TodoListApp.controller;

import fr.gorisse.todoApp.TodoListApp.entity.join_table.State;
import fr.gorisse.todoApp.TodoListApp.services.StateService;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/find")
    public State findStateUnique(
            @RequestParam int idTask,
            @RequestParam int idUser
    ){
        return this.stateService.findStateUnique(idTask, idUser);
    }

    @PostMapping("/add")
    public State addState(@RequestBody State state) {
        return stateService.addState(state);
    }

    @PostMapping("/update")
    public State updateState(@RequestBody State state) {
        return stateService.updateState(state);
    }

    @PostMapping("/delete")
    public boolean deleteState(@RequestBody State state) {
        return stateService.deleteState(state);
    }

    //Todo : j'ai un doute sur le & dans le lien
    @PostMapping("/delete/idTask&idUser")
    public boolean deleteState(@RequestParam int idTask, @RequestParam int idUser) {
        return stateService.deleteStateById(idTask, idUser);
    }

    @PostMapping("/delete/idTask")
    public boolean deleteStateByIdTask(@RequestParam int idTask) {
        return stateService.deleteStateByIdTask(idTask);
    }

    @PostMapping("/delete/idUser")
    public boolean deleteStateByIdUser(@RequestParam int idUser) {
        return stateService.deleteStateByIdUser(idUser);
    }

}
