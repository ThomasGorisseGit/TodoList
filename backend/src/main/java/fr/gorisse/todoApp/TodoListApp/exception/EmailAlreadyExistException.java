package fr.gorisse.todoApp.TodoListApp.exception;

import fr.gorisse.todoApp.TodoListApp.entity.value_objects.V_Email;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class EmailAlreadyExistException extends RuntimeException{
    public EmailAlreadyExistException(V_Email email) {
        super("L'email " + email.getEmail() + " est déjà utilisé");
    }
}
