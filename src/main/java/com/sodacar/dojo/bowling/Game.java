package com.sodacar.dojo.bowling;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author Hu bosong
 * @date 2018/4/26
 */
public class Game {

    private int score = 0;

    private int[] rolls = new int[21];

    private int current = 0;

    public void roll(int pins) {
        rolls[current++] = pins;
    }

    public int score() {
        int rollIndex = 0;
        for (int frame = 0; frame < 10; frame++, rollIndex += 2) {
            if (isStrike(rolls[rollIndex])) {
                score += 10 + rolls[rollIndex + 1] + rolls[rollIndex + 2];
                rollIndex--;
            } else if (isSpare(rollIndex)) {
                score += 10 + rolls[rollIndex + 2];
            } else {
                score += scoreInFrame(rollIndex);
            }
        }
        return score;
    }

    private boolean isStrike(int roll) {
        return roll == 10;
    }

    private int scoreInFrame(int rollIndex) {
        return rolls[rollIndex] + rolls[rollIndex + 1];
    }

    private boolean isSpare(int rollIndex) {
        return rolls[rollIndex] + rolls[rollIndex + 1] == 10;
    }

}
