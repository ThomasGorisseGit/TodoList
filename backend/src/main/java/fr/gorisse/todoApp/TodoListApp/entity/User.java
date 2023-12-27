package fr.gorisse.todoApp.TodoListApp.entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class User{
    private String nom;
    private String prenom;
    private String username;
    private String password;
    private String email;
    private LocalDate dateCreation;

    @ManyToMany
    @JoinTable(
            name = "follower_todo_list",
            joinColumns = @JoinColumn(name = "follower_id"),
            inverseJoinColumns = @JoinColumn(name = "todo_list_id"))
    private Set<TodoList>  listTodoList;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUser;

    public User(String nom, String prenom, String username, String password, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.password = password;
        this.email = email;
        this.dateCreation = LocalDate.now();
    }

    public void follow (User user, TodoList todoList){
        todoList.addFollowers(user);
    }

    public TodoList createTodoList (String title, String description) {
        return new TodoList(title, description, this);
    }
    public void deleateTodoList (TodoList todoList){
        this.listTodoList.remove(todoList);
    }

    public void setId(Integer id) {
        this.idUser = id;
    }

    public Integer getId() {
        return this.idUser;
    }
}
