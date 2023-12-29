package fr.gorisse.todoApp.TodoListApp.services;

import fr.gorisse.todoApp.TodoListApp.entity.TodoList;
import fr.gorisse.todoApp.TodoListApp.entity.User;
import fr.gorisse.todoApp.TodoListApp.entity.join_table.UseTable;
import fr.gorisse.todoApp.TodoListApp.entity.value_objects.V_Enable;
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

    public TodoListService(TodoListRepository todoListRepository, UserRepository userRepository, UseTableRepository useTableRepository) {

        this.todoListRepository = todoListRepository;
        this.userRepository = userRepository;
        this.useTableRepository = useTableRepository;
    }
    public List<TodoList> findListEnableFromUser(Integer id) {
        return todoListRepository.findTodoListsEnableByIdUser(id);
    }



    public Optional<UseTable> addLinkBetweenUserAndTodoList(User user, TodoList todoList) {
//        Optional<User> trueUser = userRepository.findByIdUser(user.getIdUser());
////        Optional<TodoList> trueTodoList = todoListRepository.findByIdTodoList(todoList.getIdTodoList());
////        if (trueUser.isEmpty() || trueTodoList.isEmpty()) {
////            return Optional.empty();
////        }
////
////        UseTable useTable = new UseTable();
////        System.out.println(trueUser);
////        //System.out.println(trueTodoList);
////
////        useTable.setFollowers(trueUser.get());
////        useTable.setTodoList(trueTodoList.get());
////        useTable.setIsEnable(V_Enable.createEnable("true"));
////
////        System.out.println("bug6");
////        System.out.println(useTable);
////
////        this.useTableRepository.save(useTable);
////        System.out.println("bug7");
////        return Optional.of(useTable);
        return null;
    }

    public TodoList addTodoList(TodoList todoList){
        addLinkBetweenUserAndTodoList(todoList.getAuthor(),todoList);
        return this.todoListRepository.save(todoList);
    }

    public boolean checkLinkUserTodoList(User user, TodoList todoList){
        return this.todoListRepository.LinkBetweenUserAndTodoList(user, todoList).isPresent();
    }
}
