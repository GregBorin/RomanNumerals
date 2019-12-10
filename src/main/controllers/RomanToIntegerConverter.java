package main.controllers;

import main.model.RomanNumeral;
import org.junit.platform.commons.util.StringUtils;

import java.util.List;

public class RomanToIntegerConverter {

    public static String romanToInteger(String input) {
        if (!StringUtils.isBlank(input)) {
            try {
                double d = Double.parseDouble(input);
                return input + " is not roman numeral, wrong option try option 1.\n";
            } catch (NumberFormatException e) {
                String romanNumeral = input.toUpperCase();
                Integer integerResponse = 0;

                List<RomanNumeral> romanNumerals = RomanNumeral.getRomanNumeralValuesList();

                int i = 0;

                while ((romanNumeral.length() > 0) && (i < romanNumerals.size())) {
                    RomanNumeral symbol = romanNumerals.get(i);
                    if (romanNumeral.startsWith(symbol.name())) {
                        integerResponse += symbol.getValue();
                        romanNumeral = romanNumeral.substring(symbol.name().length());
                    } else {
                        i++;
                    }
                }

                if (romanNumeral.length() > 0) {
                    return input + " is not a roman Numeral, the characters do not match.";
                }

                return integerResponse.toString();

            }

        } else {
            return "I think you forgot to put value or clicked wrong.\n";
        }
    }

}
