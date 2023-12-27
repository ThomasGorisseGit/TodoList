package fr.gorisse.todoApp.TodoListApp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;

@Data
@ToString
@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TodoList {

    private String title;
    private String description;

    @ManyToOne
    private User Autor;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTodoList;

    @ManyToMany(mappedBy = "todoList")
    private Set<User> followers;

    @OneToMany
    private Set<Task> tasks;

    public TodoList(String title, String description, User Auteur) {
        this.title = title;
        this.description = description;
        this.Autor = Autor;

        //de base le créateur suit sa propre liste
        this.followers.add(Autor);
    }


    public boolean follow (User user){
        return followers.add(user);
    }

    public void addFollowers (User user){
        followers.add(user);
    }


    public boolean unFollow (User user){
        return followers.remove(user);
    }

    //comparaison de 2 objets au lieu de compérer les id
    public boolean isAuteur (User user){
        return Objects.equals(user, Autor);
    }

    public boolean addTask (Task task){
        return tasks.add(task);
    }
}
