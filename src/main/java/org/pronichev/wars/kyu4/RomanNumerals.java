package org.pronichev.wars.kyu4;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RomanNumerals {

    private static final List<RomanPeriod> symbols = List.of(
            new RomanPeriod("I", "V"),
            new RomanPeriod("X", "L"),
            new RomanPeriod("C", "D"),
            new RomanPeriod("M", null)
    );
    private static final Map<Character, Integer> values = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
    );

    public static String toRoman(int n) {
        var roman = new LinkedList<String>();
        int next = n;
        int romanIndex = 0;
        do {
            var i = next % 10;

            String val = "";
            if (i == 9) {
                val = symbols.get(romanIndex).getOne() + symbols.get(romanIndex + 1).getOne();
            } else if (i == 4) {
                val = symbols.get(romanIndex).getOne() + symbols.get(romanIndex).getFive();
            } else if (i == 5) {
                val = symbols.get(romanIndex).getFive();
            } else if (i > 5) {
                val = symbols.get(romanIndex).getFive() + symbols.get(romanIndex).getOne().repeat(i - 5);
            } else {
                val = symbols.get(romanIndex).getOne().repeat(i);
            }
            roman.addFirst(val);
            next = next / 10;
            romanIndex++;
        } while (next > 0);

        return roman.stream()
                .reduce(String::concat)
                .orElse("");
    }

    public static int fromRoman(String romanNumeral) {
        int result = 0;
        int lastValue = 0;
        for (int i = romanNumeral.length() - 1; i >= 0; i--) {
            char c = romanNumeral.charAt(i);
            int value = values.get(c);
            if (value < lastValue) {
                result -= value;
            } else {
                result += value;
            }
            lastValue = value;
        }
        return result;
    }

    private static class RomanPeriod {
        private final String one;
        private final String five;

        public RomanPeriod(String one, String five) {
            this.one = one;
            this.five = five;
        }

        public String getOne() {
            return one;
        }

        public String getFive() {
            return five;
        }
    }
}
