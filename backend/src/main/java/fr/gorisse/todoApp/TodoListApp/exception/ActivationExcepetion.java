package fr.gorisse.todoApp.TodoListApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class ActivationExcepetion extends RuntimeException{
    public ActivationExcepetion() {
        super("Erreur lors de l'activation du compte. Le code d'activation est incorrect");

    }
}
