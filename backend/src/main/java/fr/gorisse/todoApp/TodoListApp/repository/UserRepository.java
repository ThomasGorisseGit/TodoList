package fr.gorisse.todoApp.TodoListApp.repository;

import fr.gorisse.todoApp.TodoListApp.entity.TodoList;
import fr.gorisse.todoApp.TodoListApp.entity.User;

import fr.gorisse.todoApp.TodoListApp.entity.value_objects.V_Email;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findByEmail(V_Email email);
    Optional<User> findByUsername(String username);

    Optional<User> findByIdUser(Integer idUser);

    @Query("SELECT u FROM User u JOIN UseTable ut ON u.idUser = ut.useId.followers WHERE ut.useId.todoList = :idTodoList")
    List<User> findUsersByTodoListId(@Param("idTodoList") Integer idTodoList);
}


