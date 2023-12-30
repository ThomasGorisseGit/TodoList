package fr.gorisse.todoApp.TodoListApp.entity.join_table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import fr.gorisse.todoApp.TodoListApp.entity.Task;
import fr.gorisse.todoApp.TodoListApp.entity.User;
import fr.gorisse.todoApp.TodoListApp.entity.value_objects.V_State;
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
public class State {

    @EmbeddedId
    StateId stateId;

    @ManyToOne
    @MapsId("task")
    @JoinColumn(referencedColumnName = "id_task")
    @JsonBackReference
    private Task task;

    @ManyToOne
    @MapsId("user")
    @JoinColumn(referencedColumnName = "idUser")
    @JsonBackReference
    private User user;


    @Convert(converter = StateConverter.class)
    private V_State state;

}
