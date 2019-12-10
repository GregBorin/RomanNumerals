package test.controllers;

import main.controllers.RomanToIntegerConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class RomanToIntegerConverterTest {

    @DisplayName("Testing valid input Roman numbers")
    @ParameterizedTest
    @CsvSource({"1 , I", "4 , IV", "5 , V", "7 , VII", "9 , IX", "10 , X", "15 , XV", "19 , XIX", "20 , XX", "40 , XL",
            "45 , XLV", "49 , XLIX", "50 , L", "51 , LI", "59 , LIX", "99 , XCIX", "100 , C", "149 , CXLIX",
            "499 , CDXCIX", "999, CMXCIX", "1499, MCDXCIX", "1994, MCMXCIV", "2599, MMDXCIX", "2999, MMCMXCIX",
            "3000, MMM"})
    public void romanToIntegerTest(String number, String roman) {
        String result = RomanToIntegerConverter.romanToInteger(roman);
        assertEquals(number, result);
    }

    @DisplayName("Testing invalid input Roman numerals")
    @ParameterizedTest
    @ValueSource(strings = {"aa", "B"})
    void romanToIntegerInvalidRomanNumeralsTest(String roman) {
        String message = RomanToIntegerConverter.romanToInteger(roman);
        assertTrue(message.contains(roman + " is not a roman Numeral, the characters do not match."));
    }

    @DisplayName("Testing if input is integer numbers")
    @ParameterizedTest
    @ValueSource(strings = {"-3", "50", "0"})
    void romanToIntegerIsNumbersTest(String roman) {
        String message = RomanToIntegerConverter.romanToInteger(roman);
        assertTrue(message.contains(roman + " is not roman numeral, wrong option try option 1."));
    }

    @DisplayName("Testing if input is blank")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void romanToIntegerIsBlankTest(String roman){
        String message = RomanToIntegerConverter.romanToInteger(roman);
        assertTrue(message.contains("I think you forgot to put value or clicked wrong."));
    }
}