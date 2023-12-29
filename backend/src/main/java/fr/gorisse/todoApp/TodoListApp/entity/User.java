package fr.gorisse.todoApp.TodoListApp.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import fr.gorisse.todoApp.TodoListApp.entity.value_objects.V_Email;
import fr.gorisse.todoApp.TodoListApp.entity.value_objects.V_Phone;
import fr.gorisse.todoApp.TodoListApp.entity.value_objects.converter.EmailConverter;
import fr.gorisse.todoApp.TodoListApp.entity.value_objects.converter.PhoneConverter;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
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

    private String password; //Todo : Pwd encryption

    @Convert(converter = PhoneConverter.class)
    private V_Phone phone;


    @CreationTimestamp
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate dateCreation;


}
