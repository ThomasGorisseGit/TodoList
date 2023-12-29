package fr.gorisse.todoApp.TodoListApp.services;

import fr.gorisse.todoApp.TodoListApp.entity.TodoList;
import fr.gorisse.todoApp.TodoListApp.entity.User;
import fr.gorisse.todoApp.TodoListApp.entity.join_table.UseTable;
import fr.gorisse.todoApp.TodoListApp.repository.UseTableRepository;
import org.springframework.stereotype.Service;

@Service

public class UseTableService {
    UseTableRepository useTableRepository;

    public UseTableService(UseTableRepository useTableRepository) {
        this.useTableRepository = useTableRepository;
    }

        public UseTable findUseTableByTodoList(TodoList todoList) {
        return useTableRepository.findUseTableByTodoList(todoList).get(0);
    }

    public UseTable findUseTableByFollower(User user) {
        return useTableRepository.findUseTableByFollower(user).get(0);
    }


}
