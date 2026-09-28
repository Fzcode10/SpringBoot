package com.example.Hibernate.model;

import jakarta.persistence.AttributeConverter;

public class BooleanToStringConverter
        implements AttributeConverter<Boolean, String> {

    @Override
    public String convertToDatabaseColumn(Boolean attribute) {

        if(attribute == null) return null;

        return attribute ? "Yes" : "No";
    }

    @Override
    public Boolean convertToEntityAttribute(String dbData) {

        if(dbData == null) return null;

        if(dbData.equals("Yes")){
            return true;
        }else{
            return false;
        }
    }
}
