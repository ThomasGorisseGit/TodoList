package fr.gorisse.todoApp.TodoListApp.services;

import fr.gorisse.todoApp.TodoListApp.entity.User;
import fr.gorisse.todoApp.TodoListApp.entity.value_objects.V_Email;
import fr.gorisse.todoApp.TodoListApp.exception.EmailAlreadyExistException;
import fr.gorisse.todoApp.TodoListApp.exception.UserIntrouvableException;
import fr.gorisse.todoApp.TodoListApp.exception.UsernameAlreadyExistException;
import fr.gorisse.todoApp.TodoListApp.repository.UserRepository;
import fr.gorisse.todoApp.TodoListApp.services.interfaces.IUserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class UserService implements IUserService, UserDetailsService {

    UserRepository userRepository;
    MailService mailService;


    public UserService(UserRepository userRepository,MailService mailService) {
        this.userRepository = userRepository;
        this.mailService = mailService;
    }
    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private boolean doEmailAlreadyExist(User user) {
        return this.findUserByEmail(user.getEmail()) != null;
    }

    private boolean doUsernameAlreadyExist(User user) {
        return userRepository.existsByUsername(user.getUsername());
    }

    public boolean existUser(Integer id) {
        return userRepository.existsById(id);
    }
    public User findUserByEmail(V_Email email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    public User findUserById(Integer id) {
        Optional<User> user =  userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        else {
            throw new UserIntrouvableException(id);
        }
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    public List<User> findFollowersFromList(int idList) {
        return this.userRepository.findUsersByTodoListId(idList);
    }

    public User addUser(User user) {
        // SI l'utilisateur modifie son adresse email ou alors est nouveau :
        // On vérifie que l'adresse email n'est pas déjà utilisée
        if (this.doEmailAlreadyExist(user)) {
            throw new EmailAlreadyExistException(user.getEmail());
        }
        if (this.doUsernameAlreadyExist(user)) {
            throw new UsernameAlreadyExistException(user.getUsername());
        }
        user.setPassword(this.passwordEncoder().encode(user.getPassword()));
        user.setActived(false);
        Random random = new Random();
        user.setActivationCode(String.valueOf(random.nextInt(999999)));

        this.mailService.sendActivationCode(user);

        return user;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.findUserByUsername(username);
    }

    public boolean activate(User user, String code){
        if(user.getActivationCode().equals(code)){
            user.setActived(true);
            this.userRepository.save(user);
            return true;
        }
        return false;


    }
}
