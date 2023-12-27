package fr.gorisse.todoApp.TodoListApp.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data // Getters and Setters
@ToString // Méthode qui renvoie tous les attributs de la classe sous forme de String
@AllArgsConstructor
@NoArgsConstructor
@Entity // User est une table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String lastName;
    private String firstName;

    // TODO : Modifier en Value Object
    private String email;
    private String password;




}
