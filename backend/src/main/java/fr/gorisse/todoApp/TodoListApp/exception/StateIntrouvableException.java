package fr.gorisse.todoApp.TodoListApp.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = org.springframework.http.HttpStatus.CONFLICT)
public class StateIntrouvableException extends RuntimeException{

    public StateIntrouvableException(Integer id,String type) {
        super("Pas d'état avec cet id"+ type+"  : " + id);
    }
}
