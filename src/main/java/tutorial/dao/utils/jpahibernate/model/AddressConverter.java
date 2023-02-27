package tutorial.dao.utils.jpahibernate.model;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class AddressConverter implements AttributeConverter<String,String> {
    @Override
    public String convertToDatabaseColumn(String s) {
        if(s==null){
            return  null;
        }
        if(s.isBlank()){
            return "";
        }
        return s.toUpperCase();

    }

    @Override
    public String convertToEntityAttribute(String s) {
        return s.toLowerCase();
    }
}
