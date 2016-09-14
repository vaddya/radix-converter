package ru.vaddya;

import java.util.ArrayList;

public class RadixConverter {

    public static void main(String[] args) {
        if (args.length == 3) {
            RadixConverter translator = new RadixConverter();
            int baseRadix = Integer.parseInt(args[1]);
            int finalRadix = Integer.parseInt(args[2]);

            System.out.println(translator.translate(args[0], baseRadix, finalRadix));
        } else {
            System.out.println("Use 3 arguments: number, base radix and final radix!");
        }
    }

    Parser parser = new Parser();
    Composer composer = new Composer();

    public String translate(String number, int baseRadix, int finalRadix) {
        parser.parse(number);
        System.out.println(parser.getIntegerPart());
        System.out.println(parser.getFractionalPart());

        System.out.println(convertIntegerPart(number, baseRadix, finalRadix));

//        double numberInDecimal = 0;
//        int powerOfBaseRadix = 1;
//        for (int value : parser.getIntegerPart()) {
//            numberInDecimal += value * powerOfBaseRadix;
//            powerOfBaseRadix *= baseRadix;
//        }
//
//        powerOfBaseRadix = baseRadix;
//        for (int value : parser.getFractionalPart()) {
//            numberInDecimal += (double)value / powerOfBaseRadix;
//            powerOfBaseRadix *= baseRadix;
//        }
//
//        StringBuilder numberInFinalRadix = new StringBuilder();
//        while ()
//
//        return String.valueOf(numberInDecimal);


//        int result = Integer.parseInt(number, baseRadix);
//        return Integer.toString(result, finalRadix);
        return null;
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
            numberInDecimal += (double)value / powerOfBaseRadix;
            powerOfBaseRadix *= baseRadix;
        }

        ArrayList<Integer> fractionalPart = new ArrayList<>();
        int accuracy = 8;
        while (accuracy > 0) {
            numberInDecimal *= finalRaix;
            fractionalPart.add((int)(numberInDecimal));
            accuracy--;
        }

        return fractionalPart
    }
}
