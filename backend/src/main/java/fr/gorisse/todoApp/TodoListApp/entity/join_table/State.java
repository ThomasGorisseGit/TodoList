package fr.gorisse.todoApp.TodoListApp.entity.join_table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private Task task;

    @ManyToOne
    @MapsId("user")
    @JoinColumn(referencedColumnName = "idUser")
    @JsonIgnore
    private User user;


    @Convert(converter = StateConverter.class)
    private V_State state;

    public void createStateId(Integer idTask, Integer idUser){
        this.stateId = new StateId();
        this.stateId.setTask(idTask);
        this.stateId.setUser(idUser);
    }

    public void setStateId(Integer idTask, Integer idUser) {
        this.stateId.setUser(idTask);
        this.stateId.setTask(idUser);
    }

}
