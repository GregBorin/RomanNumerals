package main.view;

import main.controllers.IntegerToRomanConverter;
import main.controllers.RomanToIntegerConverter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Converter {

    public static void main(String[] args) throws IOException {

        var input = new BufferedReader(new InputStreamReader(System.in));
        int op;
        do {
            op = 0;
            System.out.println("Hi, I'm Roman Bot!");
            System.out.println("I Can convert integer numbers to Roman numerals, and Roman numerals to integer numbers.");
            System.out.println("If you want my help just tell me what you need.");
            System.out.println("1 to convert Integers.");
            System.out.println("2 to convert Roman Numerals.");
            System.out.println("3 I'll leave.");

            try {
                op = Integer.parseInt(input.readLine().strip());
            } catch (NumberFormatException e) {
                System.out.println("This is not an option, keep calm and try again.\n");
            }
            switch (op) {
                case 1:

                    System.out.println("What Roman numeral would you like to know?");

                    try {
                        int number = Integer.parseInt(input.readLine().strip());
                        System.out.println(IntegerToRomanConverter.integerToRoman(number));

                    } catch (NumberFormatException e) {
                        System.out.println("Don't do this to me, I only know integer numbers.\n");
                    }

                    break;

                case 2:

                    System.out.println("I can see if the Roman numeral you know is right, just tell me!");
                    String roman = input.readLine();
                    System.out.println(RomanToIntegerConverter.romanToInteger(roman));

                    break;

                case 3:
                    System.out.println("Bey, see you later.");
                    break;

                default:
                    System.out.println("This is not an option, keep calm and try again.\n");
            }

        } while (op != 3);

    }
}
