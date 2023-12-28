package fr.gorisse.todoApp.TodoListApp.repository;

import fr.gorisse.todoApp.TodoListApp.entity.User;

import fr.gorisse.todoApp.TodoListApp.entity.value_objects.V_Email;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    User findByEmail(V_Email email);
    User findByUsername(String username);
}
