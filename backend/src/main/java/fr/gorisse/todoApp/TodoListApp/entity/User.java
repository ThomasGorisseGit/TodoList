package fr.gorisse.todoApp.TodoListApp.entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import java.time.LocalDate;
import java.util.Set;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUser;


    private String lastName;
    private String firstName;
    private String username;

    // Todo : convert as value object
    private String password;
    private String email;


    @CreatedDate
    private LocalDate dateCreation;

    @ManyToMany
    private Set<TodoList>  listTodoList;

}
