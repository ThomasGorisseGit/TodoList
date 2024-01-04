package fr.gorisse.todoApp.TodoListApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class UserIntrouvableException extends RuntimeException{

    public UserIntrouvableException(Integer id) {
        super("Pas d'utilisateur avec l'id : " + id);
    }
}
