package fr.gorisse.todoApp.TodoListApp.services.interfaces;

import fr.gorisse.todoApp.TodoListApp.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface IUserService {


    User findUserByUsername(String username);



}
