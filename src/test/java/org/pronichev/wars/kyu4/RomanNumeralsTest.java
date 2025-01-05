package org.pronichev.wars.kyu4;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RomanNumeralsTest {

    @ParameterizedTest
    @CsvSource(value = {
            "1, I",
            "2, II",
            "2000, MM",
            "1666, MDCLXVI",
            "86, LXXXVI",
    })
    public void testToRoman(int value, String expectedRoman) {

        var converted = RomanNumerals.toRoman(value);
        assertThat(converted)
                .as("Conversion of %d to roman", value)
                .isEqualTo(expectedRoman);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "I, 1",
            "II, 2",
            "MM, 2000",
            "MDCLXVI, 1666",
            "LXXXVI, 86",
    })
    public void testFromRoman(String roman, int expectedValue) {
        var converted = RomanNumerals.fromRoman(roman);
        assertThat(converted)
                .as("Conversion of %s to value", roman)
                .isEqualTo(expectedValue);
    }
}