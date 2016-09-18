package ru.vaddya.converter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RadixConverterTest {

    @Test
    public void test2to8() {
        RadixConverter converter = new RadixConverter();
        int baseRadix = 2;
        int finalRadix = 8;
        String number = "1110011,1011";

        assertEquals("163,54", converter.convert(number, baseRadix, finalRadix));
    }

    @Test
    public void test2to10() {
        RadixConverter converter = new RadixConverter();
        int baseRadix = 2;
        int finalRadix = 10;
        String number = "1110010,101";

        assertEquals("114,625", converter.convert(number, baseRadix, finalRadix));
    }

    @Test
    public void test2to16() {
        RadixConverter converter = new RadixConverter();
        int baseRadix = 2;
        int finalRadix = 16;
        String number = "11110011,100101";

        assertEquals("F3,94", converter.convert(number, baseRadix, finalRadix));
    }

    @Test
    public void test8to10() {
        RadixConverter converter = new RadixConverter();
        int baseRadix = 8;
        int finalRadix = 10;
        String number = "407,7";

        assertEquals("263,875", converter.convert(number, baseRadix, finalRadix));
    }

    @Test
    public void test10to2() {
        RadixConverter converter = new RadixConverter();
        int baseRadix = 10;
        int finalRadix = 2;
        String number = "114";

        assertEquals("1110010", converter.convert(number, baseRadix, finalRadix));
    }

    @Test
    public void test10to16() {
        RadixConverter converter = new RadixConverter();
        int baseRadix = 10;
        int finalRadix = 16;
        String number = "174,5";

        assertEquals("AE,8", converter.convert(number, baseRadix, finalRadix));
    }

    @Test
    public void test16to2() {
        RadixConverter converter = new RadixConverter();
        int baseRadix = 16;
        int finalRadix = 2;
        String number = "1E,2F";

        assertEquals("11110,00101111", converter.convert(number, baseRadix, finalRadix));
    }

    @Test
    public void test16to10() {
        RadixConverter converter = new RadixConverter();
        int baseRadix = 16;
        int finalRadix = 10;
        String number = "AE";

        assertEquals("174", converter.convert(number, baseRadix, finalRadix));
    }
}
