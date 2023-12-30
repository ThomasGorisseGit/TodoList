package fr.gorisse.todoApp.TodoListApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class TaskIntrouvableException extends RuntimeException {
    public TaskIntrouvableException(Integer id) {
        super("Pas de tâche avec l'id : " + id);
    }
}
