package fr.gorisse.todoApp.TodoListApp.services;

import fr.gorisse.todoApp.TodoListApp.exception.EmailAlreadyExistException;
import fr.gorisse.todoApp.TodoListApp.exception.UsernameAlreadyExistException;
import fr.gorisse.todoApp.TodoListApp.entity.User;
import fr.gorisse.todoApp.TodoListApp.entity.value_objects.V_Email;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import fr.gorisse.todoApp.TodoListApp.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService, UserDetailsService {

    UserRepository userRepository;



    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    private PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    private boolean doEmailAlreadyExist(User user) {
        return this.findUserByEmail(user.getEmail()) != null;
    }
    private boolean doUsernameAlreadyExist(User user) {
        return userRepository.existsByUsername(user.getUsername());
    }

    public User findUserByEmail(V_Email email) {
        return userRepository.findByEmail(email).orElse(null);
    }
    public Optional<User> findUserById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    public List<User> findFollowersFromList(int idList){
        return this.userRepository.findUsersByTodoListId(idList);
    }

    //TODO : bug ici
    public User addUser(User user){
        // SI l'utilisateur modifie son adresse email ou alors est nouveau :
        // On vérifie que l'adresse email n'est pas déjà utilisée
        if(this.doEmailAlreadyExist(user)){
            throw new EmailAlreadyExistException(user.getEmail());
        }
        if(this.doUsernameAlreadyExist(user)){
            throw new UsernameAlreadyExistException(user.getUsername());
        }
        user.setPassword(this.passwordEncoder().encode(user.getPassword()));
        return this.userRepository.save(user);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.findUserByUsername(username);
    }
}
