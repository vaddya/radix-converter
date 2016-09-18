package ru.vaddya.converter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Composer {

    private static final Map<Integer, Character> INTEGER_MAP;

    static {
        INTEGER_MAP = new HashMap<>(16);
        Character[] chars = {'0', '1', '2', '3', '4', '5', '6', '7',
                '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

        for (int i = 0; i < 16; i++) {
            INTEGER_MAP.put(i, chars[i]);
        }
    }

    public static String compose(ArrayList<Integer> integerPart, ArrayList<Integer> fractionalPart, char delimiter) {
        StringBuilder sb = new StringBuilder();
        if (integerPart.isEmpty()) {
            sb.append('0');
        }
        for (int value : integerPart) {
            sb.append(INTEGER_MAP.get(value));
        }
        if (!fractionalPart.isEmpty()) {
            sb.append(delimiter);
            for (int value : fractionalPart) {
                sb.append(INTEGER_MAP.get(value));
            }
        }
        return sb.toString();
    }
}
