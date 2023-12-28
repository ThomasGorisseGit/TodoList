package fr.gorisse.todoApp.TodoListApp.entity.join_table;

import fr.gorisse.todoApp.TodoListApp.entity.Task;
import fr.gorisse.todoApp.TodoListApp.entity.TodoList;
import fr.gorisse.todoApp.TodoListApp.entity.User;
import fr.gorisse.todoApp.TodoListApp.entity.value_objects.V_Enable;
import fr.gorisse.todoApp.TodoListApp.entity.value_objects.V_State;
import fr.gorisse.todoApp.TodoListApp.entity.value_objects.converter.EnableConverter;
import fr.gorisse.todoApp.TodoListApp.entity.value_objects.converter.StateConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table
public class Use {
    @EmbeddedId
    UseId UseId ;

    @ManyToOne
    @MapsId("followers")
    @JoinColumn(name = "followers", referencedColumnName = "idUser")
    private User followers;

    @ManyToOne
    @MapsId("TodoList")
    @JoinColumn(name = "idTodoList",referencedColumnName = "idTodoList")
    private TodoList TodoList;

    //@Column(name = "enable")
    @Convert(converter = EnableConverter.class)
    private V_Enable enable; //true or false
}
