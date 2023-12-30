package fr.gorisse.todoApp.TodoListApp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import fr.gorisse.todoApp.TodoListApp.entity.value_objects.V_Type;
import fr.gorisse.todoApp.TodoListApp.entity.value_objects.V_Visibility;
import fr.gorisse.todoApp.TodoListApp.entity.value_objects.converter.TypeConverter;
import fr.gorisse.todoApp.TodoListApp.entity.value_objects.converter.VisibilityConverter;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


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


    @Convert(converter = TypeConverter.class)
    private V_Type type; //publique privé ou partagé

    @Convert(converter = VisibilityConverter.class)
    private V_Visibility taskVisibility; //commun ou solo

    @JsonIgnore
    @ManyToOne
    @JsonManagedReference
    private User author;



    @OneToMany(mappedBy = "referenceTodoList", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Task> tasks;



}
