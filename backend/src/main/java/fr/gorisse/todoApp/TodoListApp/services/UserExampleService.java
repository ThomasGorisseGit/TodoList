package fr.gorisse.todoApp.TodoListApp.services;


import fr.gorisse.todoApp.TodoListApp.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserExampleService {


    public User addUser(User user) {
        // Vérifier que l'utilisateur n'existe pas déjà dans la bdd
        // Si l'utilisateur existe déjà, on ne l'ajoute pas throw new Exception("User already exist");
        // Sinon on l'ajoute
        //Ajout de l'utilisateur dans la bdd : this.repository.save(user);
        return null;
    }

}
