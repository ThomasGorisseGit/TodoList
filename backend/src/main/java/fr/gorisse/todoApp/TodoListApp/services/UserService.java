package fr.gorisse.todoApp.TodoListApp.services;

import fr.gorisse.todoApp.TodoListApp.entity.User;
import fr.gorisse.todoApp.TodoListApp.entity.value_objects.V_Email;
import fr.gorisse.todoApp.TodoListApp.entity.value_objects.V_Phone;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import fr.gorisse.todoApp.TodoListApp.repository.UserRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserService {

    UserRepository userRepository;
    private final LocalDate localdate = LocalDate.now();

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


    public List<User> findUserFromList(int idList){
        return this.userRepository.findUsersByTodoListId(idList);
    }

    public User addUser(User user){
        if (user.getDateCreation() == null)
            user.setDateCreation(localdate);
        return this.userRepository.save(user);
    }

    public User addStringUser(String lastName, String firstName, String username, V_Email email, String password, V_Phone phone){
        User user = new User();
        user.setLastName(lastName);
        user.setFirstName(firstName);
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhone(phone);
        user.setDateCreation(localdate);


        return this.userRepository.save(user);
    }

}
