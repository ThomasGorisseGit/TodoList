package fr.gorisse.todoApp.TodoListApp.services;

import fr.gorisse.todoApp.TodoListApp.entity.TodoList;
import fr.gorisse.todoApp.TodoListApp.entity.User;
import fr.gorisse.todoApp.TodoListApp.entity.join_table.UseTable;
import fr.gorisse.todoApp.TodoListApp.entity.value_objects.V_Enable;
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



    public boolean addLinkBetweenUserAndTodoList(User user, TodoList todoList){
        UseTable useTable = new UseTable();
        useTable.setFollowers(user);
        useTable.setTodoList(todoList);
        useTable.setIsEnable(V_Enable.createEnable("true"));

        return this.todoListRepository.LinkBetweenUserAndTodoList(user, todoList);
    }

    public TodoList addTodoList(TodoList todoList){
        addLinkBetweenUserAndTodoList(todoList.getAuthor(),todoList);
        return this.todoListRepository.save(todoList);
    }
}
