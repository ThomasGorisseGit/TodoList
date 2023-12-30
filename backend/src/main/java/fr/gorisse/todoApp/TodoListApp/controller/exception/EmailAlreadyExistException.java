package fr.gorisse.todoApp.TodoListApp.controller.exception;

import fr.gorisse.todoApp.TodoListApp.entity.value_objects.V_Email;
public class EmailAlreadyExistException extends RuntimeException{
    public EmailAlreadyExistException(V_Email email) {
        super("L'email " + email.toString() + " est déjà utilisé");
    }
}
