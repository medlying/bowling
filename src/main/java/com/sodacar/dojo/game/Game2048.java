package com.sodacar.dojo.game;

/**
 * @author Hu bosong
 * @date 2018/5/4
 */
public class Game2048 {
    private int[][] checkerboard = new int[4][4];

    public void init(int[][] points) {
        checkerboard[points[0][0]][points[0][1]] = 2;
        checkerboard[points[1][0]][points[1][1]] = 2;
    }

    public int[][] moveLeft() {
        for (int i = 0; i < checkerboard.length; i++) {
            int[] row = checkerboard[i];
            int[] copy = new int[4];
            int index = 0;
            for (int j = 0; j < row.length; j++) {
                if (row[j] > 0) {
                    copy[index++] = row[j];
                }
            }
            for (int j = 0; j < copy.length - 1; j++) {
                if (copy[j] == copy[j + 1] && copy[j] > 0) {
                    copy[j] += copy[j + 1];
                    copy[j + 1] = 0;
                }
            }
            int[] result = new int[4];
            int resultIndex = 0;
            for (int j = 0; j < copy.length; j++) {
                if (copy[j] > 0) {
                    result[resultIndex++] = copy[j];
                }
            }
            for (int m = 0; m < checkerboard[i].length; m++) {
                checkerboard[i][m] = result[m];
            }
        }
        return checkerboard;
    }

    public int[][] moveRight() {
        for (int i = 0; i < checkerboard.length; i++) {
            int[] row = checkerboard[i];
            int[] copy = new int[4];
            int index = 3;
            for (int j = row.length - 1; j >= 0; j--) {
                if (row[j] > 0) {
                    copy[index--] = row[j];
                }
            }
            for (int j = copy.length - 1; j > 0; j--) {
                if (copy[j] == copy[j - 1] && copy[j] > 0) {
                    copy[j] += copy[j - 1];
                    copy[j - 1] = 0;
                }
            }
            int[] result = new int[4];
            int resultIndex = 3;
            for (int j = copy.length - 1; j >= 0; j--) {
                if (copy[j] > 0) {
                    result[resultIndex--] = copy[j];
                }
            }
            for (int m = checkerboard[i].length - 1; m >= 0; m--) {
                checkerboard[i][m] = result[m];
            }
        }
        return checkerboard;
    }

    public int[][] moveUp() {
        for (int i = 0; i < 4; i++) {
            int[] copy = new int[4];
            int index = 0;
            for (int j = 0; j < checkerboard.length; j++) {
                if (checkerboard[j][i] > 0) {
                    copy[index++] = checkerboard[j][i];
                }
            }
            for (int j = 0; j < copy.length - 1; j++) {
                if (copy[j] == copy[j + 1] && copy[j] > 0) {
                    copy[j] += copy[j + 1];
                    copy[j + 1] = 0;
                }
            }
            int[] result = new int[4];
            int resultIndex = 0;
            for (int j = 0; j < copy.length; j++) {
                if (copy[j] > 0) {
                    result[resultIndex++] = copy[j];
                }
            }
            for (int m = 0; m < checkerboard.length; m++) {
                checkerboard[m][i] = result[m];
            }
        }
        return checkerboard;
    }

    public int[][] moveDown() {
        for (int i = 0; i < 4; i++) {
            int[] copy = new int[4];
            int index = 0;
            for (int j = checkerboard.length - 1; j >= 0; j--) {
                if (checkerboard[j][i] > 0) {
                    copy[index++] = checkerboard[j][i];
                }
            }
            for (int j = 0; j < copy.length - 1; j++) {
                if (copy[j] == copy[j + 1] && copy[j] > 0) {
                    copy[j] += copy[j + 1];
                    copy[j + 1] = 0;
                }
            }
            int[] result = new int[4];
            int resultIndex = 0;
            for (int j = 0; j < copy.length; j++) {
                if (copy[j] > 0) {
                    result[resultIndex++] = copy[j];
                }
            }
            for (int m = checkerboard.length - 1; m >= 0; m--) {
                checkerboard[m][i] = result[m];
            }
        }
        return checkerboard;
    }

    public void random(int[][] points, int number) {
        checkerboard[points[0][0]][points[0][1]] = number;
    }

    public void random() {
        int[] point;
        do {
            point = randomValue();
        } while (checkerboard[point[0]][point[1]] == 0);
        checkerboard[point[0]][point[1]] = 2;
    }

    public int[] randomValue() {
        return new int[]{(int) Math.random() * 4, (int) Math.random() * 4};
    }

    public int getMax() {
        int max = 0;
        for (int i = 0; i < checkerboard.length; i++) {
            int[] row = checkerboard[i];
            for (int j = 0; j < row.length; j++) {
                if (checkerboard[i][j] > max)
                    max = checkerboard[i][j];
            }
        }
        return max;
    }
}
