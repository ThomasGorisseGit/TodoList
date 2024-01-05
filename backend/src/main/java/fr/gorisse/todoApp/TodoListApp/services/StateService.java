package fr.gorisse.todoApp.TodoListApp.services;

import fr.gorisse.todoApp.TodoListApp.entity.Task;
import fr.gorisse.todoApp.TodoListApp.entity.User;
import fr.gorisse.todoApp.TodoListApp.entity.join_table.State;
import fr.gorisse.todoApp.TodoListApp.exception.StateAlreadyExistException;
import fr.gorisse.todoApp.TodoListApp.exception.StateIntrouvableException;
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

    public boolean existState(Integer idTask, Integer idUser) {
        Task task = taskService.findTaskById(idTask);
        User user = userService.findUserById(idUser);

        return stateRepository.existsStateByTaskAndUser(task, user);
    }

    public State findStateUnique(Integer idTask, Integer idUser) {
        Task task = taskService.findTaskById(idTask);
        User user = userService.findUserById(idUser);

        Optional<State> state = stateRepository.findStateByTaskAndUser(task, user);
        if (state.isPresent()) {
            return state.get();
        }
        else {
            String idTastString = Integer.toString(idTask);
            String idUserString = Integer.toString(idUser);
            String resultatStr = idTastString + "000" + idUserString;
            int result = Integer.parseInt(resultatStr);
            throw new StateIntrouvableException(result, "State" );
        }
    }
    public State addState(State state) {
        if (!existState(state.getStateId().getTask(), state.getStateId().getUser())) {
            State newState = new State();
            newState.setTask(taskService.findTaskById(state.getStateId().getTask()));
            newState.setUser(userService.findUserById(state.getStateId().getUser()));
            newState.setState(state.getState());
            newState.createStateId(state.getStateId().getTask(), state.getStateId().getUser());
            return stateRepository.save(newState);
        }
        else
            throw new StateAlreadyExistException(state.getStateId().getTask(), state.getStateId().getUser());
    }

    public State updateState(State state) {
        State newState = findStateUnique(state.getStateId().getTask(), state.getStateId().getUser());
        newState.setState(state.getState());
        return stateRepository.save(newState);
    }

    public boolean deleteState(State state) {
        if(existState(state.getStateId().getTask(), state.getStateId().getUser()))
        {
            stateRepository.delete(state);
            return true;
        }
        else
            return false;

    }
    public boolean deleteStateById(Integer idTask, Integer idUser) {
        if(existState(idTask, idUser))
        {
            State state = findStateUnique(idTask, idUser);
            stateRepository.delete(state);
            return true;
        }
        else
            return false;

    }

    public boolean deleteStateByIdTask(Integer idTask) {
            if (taskService.existTask(idTask))
            {
                List<State> states = findStateByTaskId(idTask);
                stateRepository.deleteAll(states);
                return true;
            }
            else
                return false;


    }

    public boolean deleteStateByIdUser(Integer idUser) {
        if(userService.existUser(idUser))
        {
            List<State> states = findStateByUser(idUser);
            stateRepository.deleteAll(states);
            return true;
        }
        else
            return false;

    }




}
