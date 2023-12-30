package fr.gorisse.todoApp.TodoListApp.entity.value_objects.converter;

import fr.gorisse.todoApp.TodoListApp.entity.value_objects.V_Email;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;


@Converter
public class EmailConverter implements AttributeConverter<V_Email,String> {
    @Override
    public String convertToDatabaseColumn(V_Email v_email) {
        return v_email.getEmail();
    }
    @Override
    public V_Email convertToEntityAttribute(String s) {
        return V_Email.createEmail(s);
    }
}
