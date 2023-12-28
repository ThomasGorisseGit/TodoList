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



    // TODO Value Object
    private String type;
    private String taskVisibility;

    @ManyToOne
    private User author;

    @ManyToMany(mappedBy = "listTodoList")
    private Set<User> followers;

    @OneToMany
    private Set<Task> tasks;



}
