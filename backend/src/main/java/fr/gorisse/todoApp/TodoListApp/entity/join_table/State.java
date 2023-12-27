package fr.gorisse.todoApp.TodoListApp.entity.join_table;

import fr.gorisse.todoApp.TodoListApp.entity.Task;
import fr.gorisse.todoApp.TodoListApp.entity.User;
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
    @JoinColumn(referencedColumnName = "idTask")
    private Task task;

    @ManyToOne
    @MapsId("user")
    @JoinColumn(referencedColumnName = "idUser")
    private User user;


    //TODO Value object :
    private String state;

}
