package fr.gorisse.todoApp.TodoListApp.entity.record;

import fr.gorisse.todoApp.TodoListApp.entity.TodoList;
import fr.gorisse.todoApp.TodoListApp.entity.User;
import lombok.Getter;


public record LinkRequest(User user, TodoList todoList) {
}
