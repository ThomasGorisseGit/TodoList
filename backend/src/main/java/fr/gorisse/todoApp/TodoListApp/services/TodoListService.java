package fr.gorisse.todoApp.TodoListApp.services;

import fr.gorisse.todoApp.TodoListApp.entity.TodoList;
import fr.gorisse.todoApp.TodoListApp.entity.User;
import fr.gorisse.todoApp.TodoListApp.entity.join_table.UseTable;
import fr.gorisse.todoApp.TodoListApp.entity.value_objects.V_Enable;
import fr.gorisse.todoApp.TodoListApp.exception.TodoListIntrouvableException;
import fr.gorisse.todoApp.TodoListApp.repository.TodoListRepository;
import fr.gorisse.todoApp.TodoListApp.repository.UseTableRepository;
import fr.gorisse.todoApp.TodoListApp.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service

public class TodoListService {

    TodoListRepository todoListRepository;
    UserRepository userRepository;
    UseTableRepository useTableRepository;

    public TodoList findTodoListById(Integer id) {
        Optional<TodoList> todoList = todoListRepository.findById(id);
        if (todoList.isPresent()) {
            return todoList.get();
        }
        else
            throw new TodoListIntrouvableException(id);
    }

    public TodoListService(TodoListRepository todoListRepository, UserRepository userRepository, UseTableRepository useTableRepository) {

        this.todoListRepository = todoListRepository;
        this.userRepository = userRepository;
        this.useTableRepository = useTableRepository;
    }
    public List<TodoList> findListEnableFromUser(Integer id) {
        return todoListRepository.findTodoListsEnableByIdUser(id);
    }





    public TodoList addTodoList(TodoList todoList){
        //addLinkBetweenUserAndTodoList(todoList.getAuthor(),todoList);
        return this.todoListRepository.save(todoList);
    }

    public boolean checkLinkUserTodoList(User user, TodoList todoList){
        return this.todoListRepository.LinkBetweenUserAndTodoList(user, todoList).isPresent();
    }
}
