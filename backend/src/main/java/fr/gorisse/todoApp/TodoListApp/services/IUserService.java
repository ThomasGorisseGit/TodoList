package fr.gorisse.todoApp.TodoListApp.services;

import fr.gorisse.todoApp.TodoListApp.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface IUserService {
    User getUserByLogin(String login);
    UserDetails loadUserByUsername(String username);

}
