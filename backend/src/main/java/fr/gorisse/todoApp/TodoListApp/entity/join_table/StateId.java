package fr.gorisse.todoApp.TodoListApp.entity.join_table;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class StateId implements Serializable {

    @Column(name = "task_id")
    private Integer task;

    @Column(name = "user_id")
    private Integer user;

}
