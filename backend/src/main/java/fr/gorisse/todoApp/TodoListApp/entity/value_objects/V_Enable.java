package fr.gorisse.todoApp.TodoListApp.entity.value_objects;

import lombok.Value;

@Value
public class V_Enable {
    String enable;

    private V_Enable(String enable) {
        this.enable = enable;
    }

    public static V_Enable createEnable(String enable) {
        if(enable.matches("^(true|false)$")){
            return new V_Enable(enable);
        }
        throw new RuntimeException("Enable invalide");
    }

    public String getEnable() {
        return enable;
    }
}
