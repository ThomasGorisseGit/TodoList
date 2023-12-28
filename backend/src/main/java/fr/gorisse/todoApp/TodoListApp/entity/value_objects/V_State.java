package fr.gorisse.todoApp.TodoListApp.entity.value_objects;

import ch.qos.logback.core.helpers.CyclicBuffer;
import lombok.Value;

import java.util.ArrayList;
import java.util.Arrays;

@Value
public class V_State {

    String state;
    String[] tab = {"A faire", "En cours", "Terminé"};

    private V_State(String state) {
        this.state = state;
    }

    //check si l'état est compris dans le tableau d'état
    public static V_State createState(String state) {
        if (Arrays.asList(new String[]{"A faire", "En cours", "Terminé"}).contains(state)) {
            return new V_State(state);
        }
        throw new RuntimeException("State invalide");
    }


}
