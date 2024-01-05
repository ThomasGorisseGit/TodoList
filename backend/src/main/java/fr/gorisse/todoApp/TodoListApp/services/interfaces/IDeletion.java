package fr.gorisse.todoApp.TodoListApp.services.interfaces;

public interface IDeletion {
    void delete(int idCurrentEntity);
    void deleteAll(int idParentEntity);
}
