package fr.gorisse.todoApp.TodoListApp.services;

import fr.gorisse.todoApp.TodoListApp.entity.TodoList;
import fr.gorisse.todoApp.TodoListApp.repository.TodoListRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class TodoListService {

    TodoListRepository todoListRepository;

    public TodoListService(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }
    public List<TodoList> getTodoListEnableByIdUser(Integer id) {
        return todoListRepository.findTodoListsEnableByIdUser(id);
    }

    public TodoList addTodoList(TodoList todoList){
        return this.todoListRepository.save(todoList);
    }
}
