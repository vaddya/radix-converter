package ru.vaddya;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Vadim on 9/12/2016.
 */
public class RadixTranslatorTest {

    @Test
    public void test2to10() {
        RadixTranslator translator = new RadixTranslator();
        int baseRadix = 2;
        int finalRadix = 10;
        String number = "1110010";

        assertEquals("114", translator.translate(number, baseRadix, finalRadix));
    }

    @Test
    public void test10to2() {
        RadixTranslator translator = new RadixTranslator();
        int baseRadix = 10;
        int finalRadix = 2;
        String number = "114";

        assertEquals("1110010", translator.translate(number, baseRadix, finalRadix));
    }

    @Test
    public void test16to10() {
        RadixTranslator translator = new RadixTranslator();
        int baseRadix = 16;
        int finalRadix = 10;
        String number = "ae";

        assertEquals("174", translator.translate(number, baseRadix, finalRadix));
    }

    @Test
    public void test10to16() {
        RadixTranslator translator = new RadixTranslator();
        int baseRadix = 10;
        int finalRadix = 16;
        String number = "174";

        assertEquals("ae", translator.translate(number, baseRadix, finalRadix));
    }

    @Test
    public void test() {
        Parser parser = new Parser();
        int baseRadix = 2;
        int finalRadix = 10;
        String number = "1110010";

        assertEquals(174, parser.parse(number, baseRadix));
    }
}
