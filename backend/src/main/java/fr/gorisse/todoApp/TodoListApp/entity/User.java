package fr.gorisse.todoApp.TodoListApp.entity;


import fr.gorisse.todoApp.TodoListApp.entity.value_objects.V_Email;
import fr.gorisse.todoApp.TodoListApp.entity.value_objects.converter.EmailConverter;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.lang.NonNullFields;

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


    @Convert(converter = EmailConverter.class)
    private V_Email email;

    // Todo : convert as value object
    private String password;

    private String phone;


    @CreatedDate
    private LocalDate dateCreation;

    @ManyToMany
    private Set<TodoList>  listTodoList;

}
