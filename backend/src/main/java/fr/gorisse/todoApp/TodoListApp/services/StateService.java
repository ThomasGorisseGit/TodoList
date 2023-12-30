package fr.gorisse.todoApp.TodoListApp.services;

import fr.gorisse.todoApp.TodoListApp.entity.Task;
import fr.gorisse.todoApp.TodoListApp.entity.TodoList;
import fr.gorisse.todoApp.TodoListApp.entity.User;
import fr.gorisse.todoApp.TodoListApp.entity.join_table.State;
import fr.gorisse.todoApp.TodoListApp.exception.StateIntrouvableException;
import fr.gorisse.todoApp.TodoListApp.exception.UserIntrouvableException;
import fr.gorisse.todoApp.TodoListApp.repository.StateRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StateService {

    StateRepository stateRepository;

    UserService userService;

    TodoListService todoListService;

    TaskService taskService;

    public StateService(StateRepository stateRepository, UserService userService, TodoListService todoListService, TaskService taskService) {
        this.stateRepository = stateRepository;
        this.userService = userService;
        this.todoListService = todoListService;
        this.taskService = taskService;
    }

    public List<State> findStateByUser(Integer id) {
        User user = userService.findUserById(id);

            Optional<List<State>> state = stateRepository.findStateByUser(user);
            if (state.isPresent() && !state.get().isEmpty()) {
                return state.get();
            }
            else {
                throw new StateIntrouvableException(id,"User");
            }

    }

    public List<State> findStateByTaskId(Integer id) {
        Task task = taskService.findTaskById(id);
            Optional<List<State>> state = stateRepository.findStateByTask(task);
            if (state.isPresent() && !state.get().isEmpty()) {
                return state.get();
            }
            else {
                throw new StateIntrouvableException(id,"Task");
            }

    }
}
