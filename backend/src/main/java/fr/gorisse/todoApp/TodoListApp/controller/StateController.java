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


    // ? Get / find

    // ? Récupère tous les états dont un utilisateur est concerné (depuis son id)
    @GetMapping("/find/idUser")
    public List<State> findStateByIdUser(
            @RequestParam int idUser
    ){
        return this.stateService.findStateByUser(idUser);
    }

    // ? Récupère tous les états d'une tâche (depuis l'id de la tâche)
    @GetMapping("/find/idTask")
    public List<State> findStateByIdTask(
            @RequestParam int idTask
    ){
        return this.stateService.findStateByTaskId(idTask);
    }

    // ? Récupère un état unique (depuis l'id de la tâche et l'id de l'utilisateur) unique normalement
    @GetMapping("/find")
    public State findStateUnique(
            @RequestParam int idTask,
            @RequestParam int idUser
    ){
        return this.stateService.findStateUnique(idTask, idUser);
    }

    // * Add

    // * Lie un utilisateur à une tâche et lui attribue un état
    @PostMapping("/add")
    public State addState(@RequestBody State state) {
        return stateService.addState(state);
    }

    // * Modifie un état d'un lien
    @PostMapping("/update")
    public State updateState(@RequestBody State state) {
        return stateService.updateState(state);
    }


    // ! Delete

    // ! Supprime un état depuis l'état
    @PostMapping("/delete")
    public boolean deleteState(@RequestBody State state) {
        return stateService.deleteState(state);
    }


    // ! Supprimer un état depuis l'id de la tâche et l'id de l'utilisateur (uniuqe normalement)
    //Todo : j'ai un doute sur le & dans le lien
    @PostMapping("/delete/idTask&idUser")
    public boolean deleteState(@RequestParam int idTask, @RequestParam int idUser) {
        return stateService.deleteStateById(idTask, idUser);
    }

    // ! Supprimer tous les états d'une tâche (depuis l'id de la tâche)
    @PostMapping("/delete/idTask")
    public boolean deleteStateByIdTask(@RequestParam int idTask) {
        return stateService.deleteStateByIdTask(idTask);
    }

    // ! Supprimer tous les états d'un utilisateur (depuis l'id de l'utilisateur)
    @PostMapping("/delete/idUser")
    public boolean deleteStateByIdUser(@RequestParam int idUser) {
        return stateService.deleteStateByIdUser(idUser);
    }

}
