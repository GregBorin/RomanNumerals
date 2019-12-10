package test.controllers;

import main.controllers.IntegerToRomanConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class IntegerToRomanConverterTest {

    @DisplayName("Testing valid input numbers")
    @ParameterizedTest
    @CsvSource({"1 , I", "4 , IV", "5 , V", "7 , VII", "9 , IX", "10 , X", "15 , XV", "19 , XIX", "20 , XX", "40 , XL",
            "45 , XLV", "49 , XLIX", "50 , L", "51 , LI", "59 , LIX", "99 , XCIX", "100 , C", "149 , CXLIX",
            "499 , CDXCIX", "999, CMXCIX", "1499, MCDXCIX", "1994, MCMXCIV", "2599, MMDXCIX", "2999, MMCMXCIX",
            "3000, MMM"})
    void integerToRomanTest(int number, String roman) {
        String result = IntegerToRomanConverter.integerToRoman(number);
        assertEquals(roman, result);
    }

    @DisplayName("Testing invalid numbers, out of range 0, 3000")
    @ParameterizedTest
    @ValueSource(ints = {0, 3001, -3})
    void integerToRomanOutOfRangeTest(int number) {
        String message = IntegerToRomanConverter.integerToRoman(number);
        assertTrue(message.contains(number + " is not between 1 and 3000!"));
    }

}