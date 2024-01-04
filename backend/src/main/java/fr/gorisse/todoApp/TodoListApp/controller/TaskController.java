package fr.gorisse.todoApp.TodoListApp.controller;


import fr.gorisse.todoApp.TodoListApp.entity.Task;
import fr.gorisse.todoApp.TodoListApp.services.TaskService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/task")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // ? Get / find

    // ? Récupère une tâche depuis son id
    @GetMapping("/find/idTask")
    public Task findTaskById(
            @RequestParam int idTask
    ){
        return this.taskService.findTaskById(idTask);
    }

    // * Add

    // * Ajoute une tâche
    @PostMapping("/add")
    public Task addTask(@RequestBody Task task) {
        return taskService.addTask(task);
    }


    // ! Delete

    // ! Supprime une tâche (depuis son id)
    @DeleteMapping("/delete")
    public void deleteTask(@RequestParam int idTask) {
        taskService.delete(idTask);
    }


    // ! Supprime toutes les tâches d'une liste (depuis l'id de la TodoList)
    @DeleteMapping("/delete/all")
    public void deleteAllTask(@RequestParam int idList) {
        taskService.deleteAll(idList);
    }
}
