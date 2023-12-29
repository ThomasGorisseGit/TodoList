package fr.gorisse.todoApp.TodoListApp.services;

import fr.gorisse.todoApp.TodoListApp.entity.User;
import fr.gorisse.todoApp.TodoListApp.entity.value_objects.V_Email;
import org.springframework.stereotype.Service;
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

    public User findUserByEmail(V_Email email) {
        return userRepository.findByEmail(email).orElse(null);
    }
    public User findUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }


    private boolean doEmailAlreadyExist(User user) {
        return this.findUserByEmail(user.getEmail()) != null;
    }


    public List<User> findFollowersFromList(int idList){
        return this.userRepository.findUsersByTodoListId(idList);
    }

    public User addUser(User user){
        // SI l'utilisateur modifie son adresse email ou alors est nouveau :
        // On vérifie que l'adresse email n'est pas déjà utilisée
        if(this.doEmailAlreadyExist(user)){
            throw new IllegalArgumentException("L'email est déjà utilisé");
        }

        return this.userRepository.save(user);
    }


}
