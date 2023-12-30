package fr.gorisse.todoApp.TodoListApp.controller.exception;

public class UsernameAlreadyExistException extends RuntimeException{
    public UsernameAlreadyExistException(String username) {
        super("Le nom d'utilisateur " + username + " est déjà utilisé");
    }
}
