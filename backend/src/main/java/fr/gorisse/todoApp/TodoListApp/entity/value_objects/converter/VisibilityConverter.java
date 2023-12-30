package fr.gorisse.todoApp.TodoListApp.entity.value_objects.converter;

import fr.gorisse.todoApp.TodoListApp.entity.value_objects.V_Visibility;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class VisibilityConverter implements AttributeConverter<V_Visibility,String> {
    @Override
    public String convertToDatabaseColumn(V_Visibility vVisibility) {
        return vVisibility.getVisibility();
    }

    @Override
    public V_Visibility convertToEntityAttribute(String s) {
        return V_Visibility.createVisibility(s);
    }
}
