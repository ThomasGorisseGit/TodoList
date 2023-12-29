package fr.gorisse.todoApp.TodoListApp.repository;

import fr.gorisse.todoApp.TodoListApp.entity.TodoList;
import fr.gorisse.todoApp.TodoListApp.entity.User;

import fr.gorisse.todoApp.TodoListApp.entity.value_objects.V_Email;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    User findByEmail(V_Email email);
    User findByUsername(String username);

    @Query("SELECT u FROM User u JOIN UseTable ut ON u.idUser = ut.useId.followers WHERE ut.useId.todoList = :idTodoList")
    List<User> findUsersByTodoListId(@Param("idTodoList") Integer idTodoList);
}


