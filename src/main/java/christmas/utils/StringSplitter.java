package christmas.utils;

import java.util.Arrays;
import java.util.List;

public class StringSplitter {

    private static final String COMMA_DELIMITER = ",";
    private static final String DASH_DELIMITER = "-";
    private static final int DEFAULT_LIMIT = -1;

    public static List<String> splitComma(String string) {
        return Arrays.stream(string.split(COMMA_DELIMITER, DEFAULT_LIMIT))
                .map(String::strip)
                .toList();
    }

    public static List<String> splitDash(String string) {
        return Arrays.stream(string.split(DASH_DELIMITER, DEFAULT_LIMIT))
                .map(String::strip)
                .toList();
    }
}
