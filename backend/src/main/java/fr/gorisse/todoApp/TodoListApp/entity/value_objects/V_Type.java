package fr.gorisse.todoApp.TodoListApp.entity.value_objects;

import lombok.Value;

import java.util.Arrays;

@Value
public class V_Type {
    String type;
    String[] tab = {"Publique", "Partagée", "Privée"};

    private V_Type(String type) {
        this.type = type;
    }

    //check si le type est compris dans le tableau de type
    public static V_Type createType(String type) {
        if (Arrays.asList(new String[]{"Publique", "Partagée", "Privée"}).contains(type)) {
            return new V_Type(type);
        }
        throw new RuntimeException("Type invalide");
    }


}
