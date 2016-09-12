package ru.vaddya;

/**
 * Created by Vadim on 9/12/2016.
 */
public class RadixTranslator {

    public static void main(String[] args) {
        if (args.length == 3) {

            RadixTranslator translator = new RadixTranslator();
            int baseRadix = Integer.parseInt(args[1]);
            int finalRadix = Integer.parseInt(args[2]);

            System.out.println(translator.translate(args[0], baseRadix, finalRadix));

        } else {
            System.out.println("Use 3 arguments: number, base radix and final radix!");
        }
    }

    public String translate(String number, int baseRadix, int finalRadix) {
        int result = Integer.parseInt(number, baseRadix);
        return Integer.toString(result, finalRadix);
    }
}
