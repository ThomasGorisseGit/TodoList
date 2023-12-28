package fr.gorisse.todoApp.TodoListApp.entity.value_objects;

import lombok.Value;

@Value
public class V_Visibility {

    String visibility;

    private V_Visibility(String visibility) {
        this.visibility = visibility;
    }

    public static V_Visibility createVisibility(String visibility) {
        if(visibility.matches("^(Commune|Solo)$")){
            return new V_Visibility(visibility);
        }
        throw new RuntimeException("Visibility invalide");
    }

    public String getVisibility() {
        return visibility;
    }
}
