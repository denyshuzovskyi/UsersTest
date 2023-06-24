package ua.com.brdo.users.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeStringConverters {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public static String localDateTimeToString(LocalDateTime localDateTime) {
        return localDateTime.format(DATE_TIME_FORMATTER);
    }

    public static LocalDateTime stringToLocalDateTime(String dateTimeString) {
        return LocalDateTime.parse(dateTimeString, DATE_TIME_FORMATTER);
    }
}
