package ua.com.brdo.users.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import ua.com.brdo.users.utils.DateTimeStringConverters;

import java.time.LocalDateTime;

@Converter
public class LocalDateTimeStringConverter implements AttributeConverter<LocalDateTime, String> {
    @Override
    public String convertToDatabaseColumn(LocalDateTime attribute) {
        return DateTimeStringConverters.localDateTimeToString(attribute);
    }

    @Override
    public LocalDateTime convertToEntityAttribute(String dbData) {
        return DateTimeStringConverters.stringToLocalDateTime(dbData);
    }
}
