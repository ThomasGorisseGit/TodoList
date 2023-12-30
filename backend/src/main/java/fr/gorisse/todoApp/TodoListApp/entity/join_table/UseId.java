package fr.gorisse.todoApp.TodoListApp.entity.join_table;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class UseId implements Serializable {
    @Column(name = "followers_id")
    private Integer followers;

    @Column(name = "todo_list_id")
    private Integer todoList;

}
