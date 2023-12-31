package fr.gorisse.todoApp.TodoListApp.services;

import fr.gorisse.todoApp.TodoListApp.entity.TodoList;
import fr.gorisse.todoApp.TodoListApp.entity.User;
import fr.gorisse.todoApp.TodoListApp.entity.join_table.UseTable;
import fr.gorisse.todoApp.TodoListApp.entity.value_objects.V_Enable;
import fr.gorisse.todoApp.TodoListApp.repository.TodoListRepository;
import fr.gorisse.todoApp.TodoListApp.repository.UseTableRepository;
import fr.gorisse.todoApp.TodoListApp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class UseTableService {
    UseTableRepository useTableRepository;

    UserRepository userRepository;

    TodoListRepository todoListRepository;

    public UseTableService(UseTableRepository useTableRepository, UserRepository userRepository, TodoListRepository todoListRepository) {
        this.useTableRepository = useTableRepository;
        this.userRepository = userRepository;
        this.todoListRepository = todoListRepository;
    }

    public UseTable findUseTableByTodoList(TodoList todoList) {
        return useTableRepository.findUseTableByTodoList(todoList).get(0);
    }

    public UseTable findUseTableByFollower(User user) {
        return useTableRepository.findUseTableByFollower(user).get(0);
    }

    public boolean isLinkUserAndTodoList(User user, TodoList todoList){
        return !this.useTableRepository.LinkBetweenUserAndTodoList(user, todoList).isEmpty() ;
    }

    public Optional<UseTable> addLinkUserTodoList(User user, TodoList todoList)  {
        //récupération des objets
        Optional<User> trueUser = userRepository.findByIdUser(user.getIdUser());
        Optional<TodoList> trueTodoList = todoListRepository.findByIdTodoList(todoList.getIdTodoList());

        //vérification de l'existence des objets
        if (trueUser.isEmpty() || trueTodoList.isEmpty()) {
            return Optional.empty();
            }

        //création de l'objet UseTable
        UseTable useTable = new UseTable();
        useTable.createUseId(trueUser.get().getIdUser(), trueTodoList.get().getIdTodoList());
        useTable.setFollowers(trueUser.get());
        useTable.setTodoList(trueTodoList.get());
        useTable.setIsEnable(V_Enable.createEnable("true"));

        this.useTableRepository.save(useTable);
        return Optional.of(useTable);

    }


}
