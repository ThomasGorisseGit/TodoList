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

    @GetMapping("/find/idTask")
    public Task findTaskById(
            @RequestParam int idTask
    ){
        return this.taskService.findTaskById(idTask);
    }

    @PostMapping("/add")
    public Task addTask(@RequestBody Task task) {
        return taskService.addTask(task);
    }

    @DeleteMapping("/delete")
    public void deleteTask(@RequestParam int idTask) {
        taskService.delete(idTask);
    }

    @DeleteMapping("/delete/all")
    public void deleteAllTask(@RequestParam int idList) {
        taskService.deleteAll(idList);
    }
}
