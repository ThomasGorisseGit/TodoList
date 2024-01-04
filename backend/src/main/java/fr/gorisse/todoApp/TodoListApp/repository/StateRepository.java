package fr.gorisse.todoApp.TodoListApp.repository;

import fr.gorisse.todoApp.TodoListApp.entity.Task;
import fr.gorisse.todoApp.TodoListApp.entity.User;
import fr.gorisse.todoApp.TodoListApp.entity.join_table.State;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StateRepository extends CrudRepository<State, Integer> {

    Optional<List<State>> findStateByUser(User user);

    Optional<List<State>> findStateByTask(Task task);

    Optional<State> findStateByTaskAndUser(Task task, User user);

    boolean existsStateByTaskAndUser(Task task, User user);

}
