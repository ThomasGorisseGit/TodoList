package fr.gorisse.todoApp.TodoListApp.entity;


import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.ToString;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@ToString

public class User{
    private String nom;
    private String prenom;

    public User(String nom) {
        this.nom = nom;
    }

}
