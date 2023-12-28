package fr.gorisse.todoApp.TodoListApp.services;

import fr.gorisse.todoApp.TodoListApp.entity.User;
import fr.gorisse.todoApp.TodoListApp.entity.value_objects.V_Email;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import fr.gorisse.todoApp.TodoListApp.repository.UserRepository;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByEmail(V_Email email) {
        return userRepository.findByEmail(email);
    }
    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    public boolean alreadyExistUserById(Integer id) {
        return userRepository.existsById(id);
    }
    public User createUser(User user) {
        if (user.getIdUser() != null && alreadyExistUserById(user.getIdUser())) {
            throw new RuntimeException("User already exist");
        }
        return userRepository.save(user);
    }



}
