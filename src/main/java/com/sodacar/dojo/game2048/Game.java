package com.sodacar.dojo.game2048;

/**
 * @author Hu bosong
 * @date 2018/5/8
 */
public class Game {

    private int[][] checkerboard = new int[4][4];

    public void init(int[][] points) {
        checkerboard[points[0][0]][points[0][1]] = 2;
    }

    public void place(int... numbers) {
        for (int i = 0; i < numbers.length - 2; i = i + 3) {
            checkerboard[numbers[i]][numbers[i + 1]] = numbers[i + 2];
        }
    }

    public int[][] moveLeft() {
        for (int i = 0; i < checkerboard.length; i++) {
            int[] copy = new int[4];
            int index = 0;
            for (int j = 0; j < checkerboard[i].length; j++) {
                if (checkerboard[i][j] != 0) {
                    copy[index++] = checkerboard[i][j];
                }
            }
            for (int j = 0; j < copy.length - 1; j++) {
                if (copy[j] == copy[j + 1] && copy[j] > 0) {
                    copy[j] = copy[j] + copy[j + 1];
                    copy[j + 1] = 0;
                }
            }
            int[] result = new int[4];
            int resultIndex = 0;
            for (int j = 0; j < copy.length; j++) {
                if(copy[j] > 0)
                    result[resultIndex++] = copy[j];
            }
            for (int j = 0; j < result.length; j++) {
                checkerboard[i][j] = result[j];
            }
        }
        return checkerboard;
    }

    public int[][] moveRight() {
        for (int i = 0; i < checkerboard.length; i++) {
            int[] copy = new int[4];
            int index = 3;
            for (int j = checkerboard[i].length - 1; j >= 0; j--) {
                if (checkerboard[i][j] > 0) {
                    copy[index--] = checkerboard[i][j];
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
                if(copy[j] > 0)
                    result[resultIndex--] = copy[j];
            }
            for (int j = checkerboard[i].length - 1; j >= 0; j--) {
                checkerboard[i][j] = result[j];
            }
        }
        return checkerboard;
    }

    public int[][] moveUp() {
        for (int i = 0; i < checkerboard.length; i++) {
            int[] copy = new int[4];
            int index = 0;
            for (int j = 0; j < checkerboard[i].length; j++) {
                if (checkerboard[j][i] > 0) {
                    copy[index++] = checkerboard[j][i];
                }
            }
            for (int j = 0; j < copy.length - 1; j++) {
                if (copy[j] == copy[j + 1] && copy[j] > 0) {
                    copy[j] = copy[j] + copy[j + 1];
                    copy[j + 1] = 0;
                }
            }
            int[] result = new int[4];
            int resultIndex = 0;
            for (int j = 0; j < copy.length; j++) {
                if(copy[j] > 0)
                    result[resultIndex++] = copy[j];
            }
            for (int j = 0; j < copy.length; j++) {
                checkerboard[j][i] = result[j];
            }
        }
        return checkerboard;
    }

    public int[][] moveDown() {
        for (int i = 0; i < checkerboard.length; i++) {
            int[] copy = new int[4];
            int index = 3;
            for (int j = checkerboard[i].length - 1; j >= 0; j--) {
                if (checkerboard[j][i] > 0) {
                    copy[index--] = checkerboard[j][i];
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
                if(copy[j] > 0)
                    result[resultIndex--] = copy[j];
            }
            for (int j = copy.length - 1; j >= 0; j--) {
                checkerboard[j][i] = result[j];
            }
        }
        return checkerboard;
    }
}
