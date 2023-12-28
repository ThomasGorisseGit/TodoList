package fr.gorisse.todoApp.TodoListApp.entity.value_objects.converter;

import fr.gorisse.todoApp.TodoListApp.entity.value_objects.V_Type;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.Converter;

import javax.print.attribute.Attribute;
@Converter
public class TypeConverter implements AttributeConverter<V_Type, String> {
    @Override
    public String convertToDatabaseColumn(V_Type vType) {
        return vType.getType();
    }

    @Override
    public V_Type convertToEntityAttribute(String s) {
        return V_Type.createType(s);
    }
}
