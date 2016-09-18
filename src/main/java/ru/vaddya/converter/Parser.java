package ru.vaddya.converter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Parser {

    private static final Map<Character, Integer> CHARACTER_MAP;

    static {
        CHARACTER_MAP = new HashMap<>(16);
        Character[] chars = {'0', '1', '2', '3', '4', '5', '6', '7',
                '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

        for (int i = 0; i < 16; i++) {
            CHARACTER_MAP.put(chars[i], i);
        }
    }

    private ArrayList<Integer> intPart = new ArrayList<>();

    private ArrayList<Integer> fracPart = new ArrayList<>();

    public Parser(String number, char delimiter) {
        int indexOfDel = number.indexOf(delimiter);
        if (indexOfDel == -1) {
            indexOfDel = number.length();
        }
        for (int i = 0; i < indexOfDel; i++) {
            intPart.add(0, CHARACTER_MAP.get(number.charAt(i)));
        }
        for (int i = indexOfDel + 1; i < number.length(); i++) {
            fracPart.add(CHARACTER_MAP.get(number.charAt(i)));
        }
    }

    public ArrayList<Integer> getIntPart() {
        return intPart;
    }

    public ArrayList<Integer> getFracPart() {
        return fracPart;
    }
}
