package fr.gorisse.todoApp.TodoListApp.services;

import fr.gorisse.todoApp.TodoListApp.entity.Task;
import fr.gorisse.todoApp.TodoListApp.entity.TodoList;
import fr.gorisse.todoApp.TodoListApp.exception.TaskIntrouvableException;
import fr.gorisse.todoApp.TodoListApp.repository.TaskRepository;
import fr.gorisse.todoApp.TodoListApp.services.interfaces.IDeletion;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class TaskService implements IDeletion {
    TaskRepository taskRepository;
    TodoListService todoListService;

    public TaskService(TaskRepository taskRepository,TodoListService todoListService) {
        this.taskRepository = taskRepository;
        this.todoListService = todoListService;
    }

    public Task findTaskById(Integer id) {
        Optional<Task> task = taskRepository.findTaskByIdTask(id);
        if (task.isPresent()) {
            return task.get();
        }
        else
            throw new TaskIntrouvableException(id);
    }
    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    public boolean existTask(Integer id) {
        return taskRepository.existsById(id);
    }



    @Override
    public void delete(int idCurrentEntity) {
        Task toDelete = this.findTaskById(idCurrentEntity);
        this.taskRepository.delete(toDelete);
    }


    @Override
    public void deleteAll(int idParentEntity) {

        // Fetch the todolist
        TodoList list = this.todoListService.findTodoListById(idParentEntity);
        List <Task> toDelete = new ArrayList<>(list.getTasks());
        list.getTasks().clear();
        this.taskRepository.deleteAll(toDelete);

    }





}
