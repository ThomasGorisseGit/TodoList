package fr.gorisse.todoApp.TodoListApp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.Set;

@Data
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TodoList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTodoList;

    private String title;
    private String description;

    @ManyToOne
    private User Author;

    @ManyToMany(mappedBy = "listTodoList")
    private Set<User> followers;

    @OneToMany
    private Set<Task> tasks;



    /*
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
        return Objects.equals(user, Author);
    }

    public boolean addTask (Task task){
        return tasks.add(task);
    }

     */
}
