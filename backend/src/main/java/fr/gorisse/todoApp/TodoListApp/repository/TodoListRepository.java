package fr.gorisse.todoApp.TodoListApp.repository;

import fr.gorisse.todoApp.TodoListApp.entity.TodoList;
import fr.gorisse.todoApp.TodoListApp.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoListRepository extends CrudRepository<TodoList, Integer> {

    @Query("SELECT tl " +
            "FROM TodoList tl " +
            "JOIN UseTable u ON tl.idTodoList = u.useId.todoList " +
            "WHERE u.useId.followers = :idUser and u.isEnable = 'true' ")
    List<TodoList> findTodoListsEnableByIdUser(Integer idUser);

    @Query("SELECT u " +
            "FROM UseTable u " +
            "WHERE u.followers = :user and u.todoList = :todoList")
    boolean LinkBetweenUserAndTodoList(User user, TodoList todoList);
}

