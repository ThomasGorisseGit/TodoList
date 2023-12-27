package fr.gorisse.todoApp.TodoListApp.Repository;

import fr.gorisse.todoApp.TodoListApp.entity.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task, Integer> {
}
