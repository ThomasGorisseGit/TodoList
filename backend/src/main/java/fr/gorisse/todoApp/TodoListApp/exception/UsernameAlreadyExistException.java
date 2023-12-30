package fr.gorisse.todoApp.TodoListApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class UsernameAlreadyExistException extends RuntimeException{

    public UsernameAlreadyExistException(String username) {
        super("Le nom d'utilisateur " + username + " est déjà utilisé");
    }
}
