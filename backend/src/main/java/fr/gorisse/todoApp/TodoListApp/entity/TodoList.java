package fr.gorisse.todoApp.TodoListApp.entity;

import fr.gorisse.todoApp.TodoListApp.entity.value_objects.V_Phone;
import fr.gorisse.todoApp.TodoListApp.entity.value_objects.V_Type;
import fr.gorisse.todoApp.TodoListApp.entity.value_objects.V_Visibility;
import fr.gorisse.todoApp.TodoListApp.entity.value_objects.converter.TypeConverter;
import fr.gorisse.todoApp.TodoListApp.entity.value_objects.converter.VisibilityConverter;
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
    @Convert(converter = TypeConverter.class)
    private V_Type type; //publique privé ou partagé

    @Convert(converter = VisibilityConverter.class)
    private V_Visibility taskVisibility; //commun ou solo

    @ManyToOne
    private User author;

    @ManyToMany(mappedBy = "listTodoList")
    private Set<User> followers;

    @OneToMany
    private Set<Task> tasks;



}
