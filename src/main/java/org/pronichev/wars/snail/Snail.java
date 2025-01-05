package org.pronichev.wars.snail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Snail {

    public static int[] snail(int[][] array) {
        var result = new ArrayList<Integer>(array.length * array.length);
        while (array.length > 0) {
            array = popTop(array, result);
            if (array.length == 0) {
                break;
            }
            array = popLast(array, result);
            array = popBottom(array, result);
            if (array.length == 0) {
                break;
            }
            array = popFirst(array, result);
        }
        return result.stream()
                .mapToInt(i -> i).toArray();
    }


    private static int[][] popTop(int[][] array, Collection<Integer> result) {
        var newLength = array.length - 1;
        int[][] newArray = new int[newLength][array.length];
        System.arraycopy(array, 1, newArray, 0, newLength);

        Arrays.stream(array[0])
                .forEach(result::add);
        return newArray;
    }

    private static int[][] popLast(int[][] array, Collection<Integer> result) {
        var newLength = array[0].length - 1;
        int[][] newArray = new int[array.length][newLength];
        for (int i = 0; i < array.length; i++) {
            System.arraycopy(array[i], 0, newArray[i], 0, newLength);
            result.add(array[i][array[i].length - 1]);
        }
        return newArray;
    }

    private static int[][] popBottom(int[][] array, Collection<Integer> result) {
        var newLength = array.length - 1;
        int[][] newArray = new int[newLength][array.length];
        System.arraycopy(array, 0, newArray, 0, newLength);

        for (int i = array.length - 1; i >= 0; i--) {
            result.add(array[array.length - 1][i]);
        }
        return newArray;
    }

    private static int[][] popFirst(int[][] array, Collection<Integer> result) {
        var newLength = array[0].length - 1;
        int[][] newArray = new int[array.length][newLength];
        for (int i = array.length - 1; i >= 0; i--) {
            System.arraycopy(array[i], 1, newArray[i], 0, newLength);
            result.add(array[i][0]);
        }
        return newArray;
    }
}