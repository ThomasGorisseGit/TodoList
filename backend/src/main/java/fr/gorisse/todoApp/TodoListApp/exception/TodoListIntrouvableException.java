package fr.gorisse.todoApp.TodoListApp.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = org.springframework.http.HttpStatus.CONFLICT)
public class TodoListIntrouvableException extends RuntimeException{
    public TodoListIntrouvableException(Integer id) {
        super("Pas de liste avec l'id : " + id);
    }
}
