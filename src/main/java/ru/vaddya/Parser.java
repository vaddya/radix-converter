package ru.vaddya;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Parser {
    private static final char DELIMITER = ',';
    private static final Map<Character, Integer> table;
    static {
        table = new HashMap<>(16);
        Character[] chars = { '0', '1', '2', '3', '4', '5', '6', '7',
                '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

        for (int i = 0; i < 16; i++) {
            table.put(chars[i], i);
        }
    }

    Parser() {
        integerPart = new LinkedList<>();
        fractionalPart = new LinkedList<>();
    }

    private List<Integer> integerPart;
    private List<Integer> fractionalPart;

    void parse(String number) {
        int indexOfDel = number.indexOf(DELIMITER);
        if (indexOfDel == -1) {
            indexOfDel = number.length();
        }

        for (int i = 0; i < indexOfDel; i++) {
            integerPart.add(table.get(number.charAt(i)));
        }
        for (int i = indexOfDel + 1; i < number.length() - 1; i++) {
            fractionalPart.add(table.get(number.charAt(i)));
        }
    }

    public List<Integer> getIntegerPart() {
        return integerPart;
    }

    public List<Integer> getFractionalPart() {
        return fractionalPart;
    }
}
