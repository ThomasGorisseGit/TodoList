package fr.gorisse.todoApp.TodoListApp.entity.value_objects.converter;

import fr.gorisse.todoApp.TodoListApp.entity.value_objects.V_Enable;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class EnableConverter implements AttributeConverter<V_Enable,String>{
    @Override
    public String convertToDatabaseColumn(V_Enable vEnable) {
        return vEnable.getEnable();
    }

    @Override
    public V_Enable convertToEntityAttribute(String s) {
        return V_Enable.createEnable(s);
    }
}
