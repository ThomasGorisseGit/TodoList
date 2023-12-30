package fr.gorisse.todoApp.TodoListApp.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class PasswordException extends RuntimeException{
    public PasswordException() {
        super("Le mot de passe doit contenir au moins 4 caractères dont une majuscule, une minuscule, un chiffre et un caractère spécial");
    }
}
