package ru.vaddya.converter;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Composer {
    private static final char DELIMITER = ',';
    private static final Map<Integer, Character> INTEGER_MAP;

    static {
        INTEGER_MAP = new HashMap<>(16);
        Character[] chars = {'0', '1', '2', '3', '4', '5', '6', '7',
                '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

        for (int i = 0; i < 16; i++) {
            INTEGER_MAP.put(i, chars[i]);
        }
    }

    public String compose(List<Integer> integerPart, List<Integer> fractionalPart) {
        StringBuilder builder = new StringBuilder();
        if (integerPart.isEmpty()) {
            builder.append('0');
        }
        for (int value : integerPart) {
            builder.append(INTEGER_MAP.get(value));
        }
        if (!fractionalPart.isEmpty()) {
            builder.append(DELIMITER);
            for (int value : fractionalPart) {
                builder.append(INTEGER_MAP.get(value));
            }
        }
        return builder.toString();
    }
}
