package com.proyetofinalpoo.asistencias.utils;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author victortinoco
 */
@Converter(autoApply = true)
public class LocalDateConverter implements AttributeConverter<LocalDate, String> {

    @Override
    public String convertToDatabaseColumn(LocalDate value) {
        return value.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    @Override
    public LocalDate convertToEntityAttribute(String dbData) {
        return LocalDate.parse(dbData, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
