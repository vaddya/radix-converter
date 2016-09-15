package ru.vaddya.converter;

import java.util.*;

class Parser {
    private static final char DELIMITER = ',';
    private static final Map<Character, Integer> CHARACTER_MAP;
    static {
        CHARACTER_MAP = new HashMap<>(16);
        Character[] chars = { '0', '1', '2', '3', '4', '5', '6', '7',
                '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

        for (int i = 0; i < 16; i++) {
            CHARACTER_MAP.put(chars[i], i);
        }
    }

    Parser() {
        integerPart = new ArrayList<>();
        fractionalPart = new ArrayList<>();
    }

    private ArrayList<Integer> integerPart;
    private ArrayList<Integer> fractionalPart;

    void parse(String number) {
        int indexOfDel = number.indexOf(DELIMITER);
        if (indexOfDel == -1) {
            indexOfDel = number.length();
        }

        for (int i = 0; i < indexOfDel; i++) {
            integerPart.add(0, CHARACTER_MAP.get(number.charAt(i)));
        }
        for (int i = indexOfDel + 1; i < number.length(); i++) {
            fractionalPart.add(CHARACTER_MAP.get(number.charAt(i)));
        }
    }

    public List<Integer> getIntegerPart() {
        return integerPart;
    }

    public List<Integer> getFractionalPart() {
        return fractionalPart;
    }
}
