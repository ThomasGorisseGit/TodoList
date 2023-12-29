package fr.gorisse.todoApp.TodoListApp.entity.value_objects;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Value;

@Value
public class V_Phone {

    String phone;

    private V_Phone(String phone) {
        this.phone = phone;
    }

    public static V_Phone createPhone(String phone) {
        if(phone.matches("^\\d{10}$")){
            return new V_Phone(phone);
        }
        throw new RuntimeException("Phone invalide");
    }

    @JsonValue
    public String getPhone() {
        return phone;
    }
}
