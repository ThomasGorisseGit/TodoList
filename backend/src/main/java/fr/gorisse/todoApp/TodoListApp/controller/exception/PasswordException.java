package fr.gorisse.todoApp.TodoListApp.controller.exception;

public class PasswordException extends RuntimeException{
    public PasswordException() {
        super("Le mot de passe doit contenir au moins 4 caractères dont une majuscule, une minuscule, un chiffre et un caractère spécial");
    }
}
