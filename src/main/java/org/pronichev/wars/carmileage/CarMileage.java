package org.pronichev.wars.carmileage;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class CarMileage {

    public static int isInteresting(int number, int[] awesomePhrases) {
        if (isReallyInteresting(number, awesomePhrases)) {
            return 2;
        } else if (isReallyInteresting(number + 1, awesomePhrases)) {
            return 1;
        } else if (isReallyInteresting(number + 2, awesomePhrases)) {
            return 1;
        } else {
            return 0;
        }
    }

    private static boolean isReallyInteresting(int number, final int[] awesomePhrases) {
        if (number < 100) {
            return false;
        }
        var str = Integer.toString(number);
        return Stream.<Predicate<String>>of(
                s -> s.matches("\\d0+"),
                s -> new StringBuilder(s).reverse().toString().equals(s),
                s -> "1234567890".contains(s),
                s -> "9876543210".contains(s),
                s -> Arrays.stream(awesomePhrases).anyMatch(n -> Integer.parseInt(s) == n)
        ).anyMatch(p -> p.test(str));
    }
}