package fr.gorisse.todoApp.TodoListApp.Repository;

import fr.gorisse.todoApp.TodoListApp.entity.TodoList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoListRepository extends CrudRepository<TodoList, Integer> {
}