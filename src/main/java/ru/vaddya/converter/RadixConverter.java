package ru.vaddya.converter;

import java.util.ArrayList;
import java.util.Scanner;

public class RadixConverter {

    public static void main(String[] args) {
        RadixConverter converter = new RadixConverter();
        if (args.length == 3) {
            int baseRadix = Integer.parseInt(args[1]);
            int finalRadix = Integer.parseInt(args[2]);

            String res = converter.convert(args[0], baseRadix, finalRadix);
            System.out.format("%s (%d) = %s (%d)\n", args[0], baseRadix, res, finalRadix);
        } else {
            Scanner scan = new Scanner(System.in);
            System.out.print("Input the number: ");
            String number = scan.next();

            System.out.print("Input the base radix: ");
            int baseRadix = scan.nextInt();

            System.out.print("Input the final radix: ");
            int finalRadix = scan.nextInt();

            String res = converter.convert(number, baseRadix, finalRadix);
            System.out.format("%s (%d) = %s (%d)\n", number, baseRadix, res, finalRadix);
        }
    }

    private static final int ACCURACY = 8;

    private static final char DELIMITER = ',';

    public String convert(String number, int baseRadix, int finalRadix) {
        Parser parser = new Parser();
        Composer composer = new Composer();

        parser.parse(number, DELIMITER);
        return composer.compose(
                convertIntPart(parser.getIntPart(), baseRadix, finalRadix),
                convertFracPart(parser.getFracPart(), baseRadix, finalRadix),
                DELIMITER
        );
    }

    private ArrayList<Integer> convertIntPart(ArrayList<Integer> intPart, int baseRadix, int finalRadix) {
        int numberInDecimal = 0;
        int powerOfBaseRadix = 1;
        for (int value : intPart) {
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

    private ArrayList<Integer> convertFracPart(ArrayList<Integer> fracList, int baseRadix, int finalRadix) {
        double numberInDecimal = 0.0;
        int powerOfBaseRadix = baseRadix;
        for (int value : fracList) {
            numberInDecimal += (double) value / powerOfBaseRadix;
            powerOfBaseRadix *= baseRadix;
        }

        ArrayList<Integer> fractionalPart = new ArrayList<>();
        int accuracy = ACCURACY;
        while (accuracy > 0 && numberInDecimal != 0) {
            numberInDecimal *= finalRadix;
            int diff = (int) numberInDecimal;
            fractionalPart.add(diff);
            numberInDecimal -= diff;
            accuracy--;
        }

        return fractionalPart;
    }
}
