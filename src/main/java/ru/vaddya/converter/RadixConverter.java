package ru.vaddya.converter;

import java.util.ArrayList;

public class RadixConverter {
    public static void main(String[] args) {
        if (args.length == 3) {
            RadixConverter translator = new RadixConverter();
            int baseRadix = Integer.parseInt(args[1]);
            int finalRadix = Integer.parseInt(args[2]);
            System.out.println(translator.translate(args[0], baseRadix, finalRadix));
        } else {
            System.out.println("Use 3 arguments: <number>, <base radix> and <final radix>!");
        }
    }

    private static final int ACCURACY = 8;
    private Parser parser = new Parser();
    private Composer composer = new Composer();

    public String translate(String number, int baseRadix, int finalRadix) {
        parser.parse(number);

        return composer.compose(convertIntegerPart(number, baseRadix, finalRadix),
                convertFractionalPart(number, baseRadix, finalRadix));
    }

    private ArrayList<Integer> convertIntegerPart(String number, int baseRadix, int finalRadix) {
        int numberInDecimal = 0;
        int powerOfBaseRadix = 1;
        for (int value : parser.getIntegerPart()) {
            numberInDecimal += value * powerOfBaseRadix;
            powerOfBaseRadix *= baseRadix;
        }

        ArrayList<Integer> integerPart = new ArrayList<>();
        while (numberInDecimal != 0) {
            integerPart.add(0, numberInDecimal % finalRadix);
            numberInDecimal /= finalRadix;
        }

        return integerPart;
    }

    private ArrayList<Integer> convertFractionalPart(String number, int baseRadix, int finalRaix) {
        double numberInDecimal = 0.0;
        int powerOfBaseRadix = baseRadix;
        for (int value : parser.getFractionalPart()) {
            numberInDecimal += (double) value / powerOfBaseRadix;
            powerOfBaseRadix *= baseRadix;
        }

        ArrayList<Integer> fractionalPart = new ArrayList<>();
        int accuracy = ACCURACY;
        while (accuracy > 0 && numberInDecimal != 0) {
            numberInDecimal *= finalRaix;
            int diff = (int) (numberInDecimal);
            fractionalPart.add(diff);
            numberInDecimal -= diff;
            accuracy--;
        }

        return fractionalPart;
    }
}
