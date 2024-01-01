package fr.gorisse.todoApp.TodoListApp.services;

import fr.gorisse.todoApp.TodoListApp.entity.Task;
import fr.gorisse.todoApp.TodoListApp.exception.TaskIntrouvableException;
import fr.gorisse.todoApp.TodoListApp.repository.TaskRepository;
import fr.gorisse.todoApp.TodoListApp.services.interfaces.IDeletion;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class TaskService implements IDeletion {
    TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
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



    // TODO Implement methods :
    @Override
    public void delete(int idCurrentEntity) {

    }
    // TODO Implement methods :
    @Override
    public void deleteAll(int idParentEntity) {

    }



}
