package fr.gorisse.todoApp.TodoListApp.entity.join_table;

import fr.gorisse.todoApp.TodoListApp.entity.TodoList;
import fr.gorisse.todoApp.TodoListApp.entity.User;
import fr.gorisse.todoApp.TodoListApp.entity.value_objects.V_Enable;
import fr.gorisse.todoApp.TodoListApp.entity.value_objects.converter.EnableConverter;
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
public class UseTable {
    @EmbeddedId
    UseId useId ;

    @ManyToOne
    @MapsId("followers")
    @JoinColumn(name="id_user",referencedColumnName = "idUser")
    private User followers;

    @ManyToOne
    @MapsId("todoList")
    @JoinColumn(name="id_todolist",referencedColumnName = "idTodoList")
    private TodoList todoList;

    //@Column(name = "enable")
    @Convert(converter = EnableConverter.class)
    private V_Enable isEnable; //true or false
}
