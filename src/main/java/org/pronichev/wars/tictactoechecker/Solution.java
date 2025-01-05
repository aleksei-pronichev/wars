package org.pronichev.wars.tictactoechecker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {

    public static int isSolved(int[][] board) {
        int win = board.length;
        AtomicInteger empty = new AtomicInteger(0);
        int d1 = 0, d2 = 0;
        int[] horizontal = new int[win];
        int[] line = new int[win];

        for (int i = 0; i < win; i++) {
            for (int j = 0; j < win; j++) {
                int current = board[i][j];
                if (current == 0) {
                    empty.incrementAndGet();
                } else if (current == 1) {
                    line[i]++;
                    horizontal[j]++;
                    if (i == j) {
                        d1++;
                    }
                    if (i + j == win - 1) {
                        d2++;
                    }
                } else if (current == 2) {
                    line[i]--;
                    horizontal[j]--;
                    if (i == j) {
                        d1--;
                    }
                    if (i + j == win - 1) {
                        d2--;
                    }
                }
            }
        }

        var checkValues = new ArrayList<Integer>();
        checkValues.add(d1);
        checkValues.add(d2);
        checkValues.addAll(Arrays.stream(horizontal).boxed().toList());
        checkValues.addAll(Arrays.stream(line).boxed().toList());

        return checkValues.stream()
                .filter(value -> Math.abs(value) == win)
                .findFirst()
                .map(value -> {
                    if (value > 0) {
                        return 1;
                    } else {
                        return 2;
                    }
                })
                .or(() -> {
                    if (empty.get() > 0) {
                        return Optional.of(-1);
                    }
                    return Optional.empty();
                })
                .orElse(0);
    }

}
