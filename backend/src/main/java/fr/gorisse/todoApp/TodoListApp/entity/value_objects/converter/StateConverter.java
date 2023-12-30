package fr.gorisse.todoApp.TodoListApp.entity.value_objects.converter;

import fr.gorisse.todoApp.TodoListApp.entity.value_objects.V_State;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.Converter;

@Converter
public class StateConverter implements AttributeConverter<V_State,String> {
    @Override
    public String convertToDatabaseColumn(V_State vState) {
        return vState.getState();
    }

    @Override
    public V_State convertToEntityAttribute(String s) {
        return V_State.createState(s);
    }
}
