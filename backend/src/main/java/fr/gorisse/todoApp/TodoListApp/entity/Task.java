package fr.gorisse.todoApp.TodoListApp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTask;

    private String title;
    private String description;

    @OneToOne
    private TodoList ListtodoList;

    @OneToMany
    private Set<User> followers;
}
