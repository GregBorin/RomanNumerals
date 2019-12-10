package main.controllers;

import main.model.RomanNumeral;

import java.util.List;

public class IntegerToRomanConverter {

    public static String integerToRoman(int number) {

        if ((number <= 0) || (number > 3000)) {
            return number + " is not between 1 and 3000!\n";
        }

        List<RomanNumeral> romanNumerals = RomanNumeral.getRomanNumeralValuesList();

        int i = 0;
        var romanNumeralsResponse = new StringBuilder();

        while ((number > 0) && (i < romanNumerals.size())) {
            RomanNumeral currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= number) {
                romanNumeralsResponse.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }
        return romanNumeralsResponse.toString();
    }

}
