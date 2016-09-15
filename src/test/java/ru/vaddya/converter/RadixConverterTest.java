package ru.vaddya.converter;

import org.junit.Test;
import ru.vaddya.converter.RadixConverter;

import static org.junit.Assert.assertEquals;

public class RadixConverterTest {

    @Test
    public void test2to10() {
        RadixConverter translator = new RadixConverter();
        int baseRadix = 2;
        int finalRadix = 10;
        String number = "1110010";

        assertEquals("114", translator.translate(number, baseRadix, finalRadix));
    }

    @Test
    public void test2to8() {
        RadixConverter translator = new RadixConverter();
        int baseRadix = 2;
        int finalRadix = 8;
        String number = "1110011";

        assertEquals("163", translator.translate(number, baseRadix, finalRadix));
    }

    @Test
    public void test10to2() {
        RadixConverter translator = new RadixConverter();
        int baseRadix = 10;
        int finalRadix = 2;
        String number = "114";

        assertEquals("1110010", translator.translate(number, baseRadix, finalRadix));
    }

    @Test
    public void test16to10() {
        RadixConverter translator = new RadixConverter();
        int baseRadix = 16;
        int finalRadix = 10;
        String number = "AE";

        assertEquals("174", translator.translate(number, baseRadix, finalRadix));
    }

    @Test
    public void test10to16() {
        RadixConverter translator = new RadixConverter();
        int baseRadix = 10;
        int finalRadix = 16;
        String number = "174";

        assertEquals("AE", translator.translate(number, baseRadix, finalRadix));
    }
}
