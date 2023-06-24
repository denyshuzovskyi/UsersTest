package ua.com.brdo.users.utils;

public class StringUtils {
    public static String trimAndCapitalizeString(String originalString) {
        StringBuilder stringBuilder = new StringBuilder(originalString.trim());
        stringBuilder.setCharAt(0, Character.toUpperCase(stringBuilder.charAt(0)));

        return stringBuilder.toString();
    }
}
