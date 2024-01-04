package fr.gorisse.todoApp.TodoListApp.exception;

public class StateAlreadyExistException extends  RuntimeException{
    public StateAlreadyExistException(Integer idTask, Integer idUser) {
        super("State already exist for task " + idTask + " and user " + idUser);
    }
}
