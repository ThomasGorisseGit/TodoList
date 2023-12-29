package fr.gorisse.todoApp.TodoListApp.entity.value_objects;


import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Value;

import java.util.regex.Pattern;
@Value
public class V_Email {

    String email;

    private V_Email(String email) {
        this.email = email;
    }

    public static V_Email createEmail(String email) {
        if(Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$").matcher(email).matches()){
            return new V_Email(email);
        }
        throw new RuntimeException("Email invalide");
    }
    @JsonValue
    public String getEmail() {
        return email;
    }
}