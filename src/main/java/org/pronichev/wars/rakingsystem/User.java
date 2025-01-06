package org.pronichev.wars.rakingsystem;

import java.util.List;

public class User {

    private static final List<Integer> scale = List.of(-8, -7, -6, -5, -4, -3, -2, -1, 1, 2, 3, 4, 5, 6, 7, 8);

    public int rank = scale.get(0);
    public int progress = 0;

    public void incProgress(int taskRank) {
        var taskScale = scale.indexOf(taskRank);
        if (taskScale == -1) {
            throw new IllegalArgumentException("Invalid rank");
        }
        var currentScale = scale.indexOf(rank);
        if (isMax(currentScale)) {
            return;
        }
        int points = countProgress(taskScale, currentScale);
        incProgress(points, currentScale);
    }

    private int countProgress(int taskScale, int currentScale) {
        var diff = taskScale - currentScale;
        if (diff < -1) return 0;
        if (diff == -1) return 1;
        if (diff == 0) return 3;
        return 10 * diff * diff;
    }

    private void incProgress(int inc, int currentScale) {
        progress += inc;
        if (progress < 100) {
            return;
        }
        int levelUp = Math.min(currentScale + progress / 100, scale.size() - 1);
        progress %= 100;
        rank = scale.get(levelUp);
        if (isMax(levelUp)) {
            progress = 0;
        }
    }

    private boolean isMax(int i) {
        return i == scale.size() - 1;
    }
}
