package fr.gorisse.todoApp.TodoListApp.entity.value_objects.converter;

import fr.gorisse.todoApp.TodoListApp.entity.value_objects.V_Phone;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class PhoneConverter implements AttributeConverter<V_Phone,String> {
    @Override
    public String convertToDatabaseColumn(V_Phone vPhone) {
        return vPhone.getPhone();
    }

    @Override
    public V_Phone convertToEntityAttribute(String s) {
        return V_Phone.createPhone(s);
    }
}
