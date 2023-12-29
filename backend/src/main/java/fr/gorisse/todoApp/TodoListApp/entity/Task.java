package fr.gorisse.todoApp.TodoListApp.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Task {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_task")
    private Integer idTask;

    private String title;
    private String description;


    @ManyToOne
    @JsonBackReference
    private TodoList referenceTodoList;

    @JsonValue
    public String getTaskTitle() {
        return title;
    }

}
