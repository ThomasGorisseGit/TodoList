package fr.gorisse.todoApp.TodoListApp.Repository;

import fr.gorisse.todoApp.TodoListApp.entity.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
