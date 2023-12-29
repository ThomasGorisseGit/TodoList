package fr.gorisse.todoApp.TodoListApp.repository;

import fr.gorisse.todoApp.TodoListApp.entity.TodoList;
import fr.gorisse.todoApp.TodoListApp.entity.User;
import fr.gorisse.todoApp.TodoListApp.entity.join_table.UseTable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UseTableRepository extends CrudRepository<UseTable, Integer> {

    @Query("SELECT u.followers " +
            "FROM UseTable u " +
            "WHERE u.todoList = :todolist")
    List<User> findByTodoList(TodoList todolist);

    @Query("SELECT u.todoList " +
            "FROM UseTable u " +
            "WHERE u.followers = :user")
    List<TodoList> findUseTableByUser (User user);

    @Query("SELECT u " +
            "FROM UseTable u " +
            "WHERE u.followers = :user")
    List<UseTable> findUseTableByFollower(User user);
    @Query("SELECT u " +
            "FROM UseTable u " +
            "WHERE u.todoList = :todoList")
    List<UseTable> findUseTableByTodoList (TodoList todoList);


}
