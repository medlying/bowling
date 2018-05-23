package com.sodacar.dojo;

import com.sodacar.dojo.game2048.Game;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Hu bosong
 * @date 2018/5/8
 */
public class GameTest {

    private Game game = new Game();

    @Test
    public void moveOneLeft() {
        game.init(new int[][]{{3, 3}});
        assertEquals(2, game.moveLeft()[3][0]);
        assertEquals(0, game.moveLeft()[3][3]);
    }

    @Test
    public void moveOneLeft1() {
        game.init(new int[][]{{0, 3}});
        int[][] result = game.moveLeft();
        assertNotEquals(2, result[3][0]);
        assertEquals(2, result[0][0]);
    }

    @Test
    public void moveLeftWithCombine() {
        game.place(3, 3, 2, 3, 2, 2);
        int[][] result = game.moveLeft();
        assertEquals(4, result[3][0]);

    }

    @Test
    public void moveRightOne() {
        game.place(3, 0, 2);
        assertEquals(2, game.moveRight()[3][3]);
    }

    @Test
    public void moveRightMorethanOne() {
        game.place(3, 0, 2, 2, 2, 4);
        int[][] result = game.moveRight();
        assertEquals(2, result[3][3]);
        assertEquals(4, result[2][3]);
    }

    @Test
    public void moveUpOne() {
        game.place(3, 0, 2);
        assertEquals(2, game.moveUp()[0][0]);
    }

    @Test
    public void moveUpMorethanOne() {
        game.place(3, 0, 2, 3, 1, 4, 3, 2, 4, 3, 3, 4);
        int[][] result = game.moveUp();
        assertEquals(2, result[0][0]);
        assertEquals(4, result[0][1]);
        assertEquals(4, result[0][2]);
        assertEquals(4, result[0][3]);
    }

    @Test
    public void moveUpMorethanOne1() {
        game.place(3, 0, 2, 2, 0, 4, 1, 0, 4, 0, 0, 4);
        int[][] result = game.moveLeft();
        assertEquals(4, result[0][0]);
        assertEquals(4, result[1][0]);
        assertEquals(4, result[2][0]);
        assertEquals(2, result[3][0]);
    }

    @Test
    public void moveDownOne() {
        game.place(0, 0, 2);
        assertEquals(2, game.moveDown()[3][0]);
    }

    @Test
    public void moveDownMorethanOne() {
        game.place(0, 0, 2, 0, 1, 4, 0, 2, 4, 0, 3, 4);
        int[][] result = game.moveDown();
        assertEquals(2, result[3][0]);
        assertEquals(4, result[3][1]);
        assertEquals(4, result[3][2]);
        assertEquals(4, result[3][3]);
    }


    @Test
    public void moveLeftWithTwoWithoutCombine() {
        game.place(0, 0, 2, 0, 1, 4);
        int[][] result = game.moveLeft();
        assertEquals(2, result[0][0]);
        assertEquals(4, result[0][1]);
    }

    @Test
    public void moveLeftWithTwoWithCombine() {
        game.place(0, 0, 2, 0, 1, 2);
        int[][] result = game.moveLeft();
        assertEquals(4, result[0][0]);
        assertEquals(0, result[0][1]);
    }

    @Test
    public void moveLeftWithTwoWithCombineWithoutSequence() {
        game.place(0, 0, 2, 0, 3, 2);
        int[][] result = game.moveLeft();
        assertEquals(4, result[0][0]);
        assertEquals(0, result[0][1]);
        assertEquals(0, result[0][2]);
        assertEquals(0, result[0][3]);
    }

    @Test
    public void moveRightWithFourWithCombine() {
        game.place(0, 0, 2, 0, 1, 2, 0, 2, 2, 0, 3, 2);
        int[][] result = game.moveRight();
        assertEquals(0, result[0][0]);
        assertEquals(0, result[0][1]);
        assertEquals(4, result[0][2]);
        assertEquals(4, result[0][3]);
    }

    @Test
    public void moveRightWithTwoWithoutCombine() {
        game.place(0, 0, 2, 0, 1, 4);
        int[][] result = game.moveRight();
        assertEquals(4, result[0][3]);
        assertEquals(2, result[0][2]);
    }

    @Test
    public void moveRightWithTwoWithCombine() {
        game.place(0, 0, 2, 0, 1, 2);
        int[][] result = game.moveRight();
        assertEquals(4, result[0][3]);
        assertEquals(0, result[0][1]);
    }

    @Test
    public void moveRightWithTwoWithCombineWithoutSequence() {
        game.place(0, 0, 2, 0, 3, 2);
        int[][] result = game.moveRight();
        assertEquals(4, result[0][3]);
        assertEquals(0, result[0][1]);
        assertEquals(0, result[0][2]);
        assertEquals(0, result[0][0]);
    }

    @Test
    public void moveLeftWithFourWithCombine() {
        game.place(0, 0, 2, 0, 1, 2, 0, 2, 2, 0, 3, 2);
        int[][] result = game.moveRight();
        assertEquals(4, result[0][3]);
        assertEquals(4, result[0][2]);
        assertEquals(0, result[0][1]);
        assertEquals(0, result[0][0]);
    }

    @Test
    public void moveLeftWithFourWithCombineX() {
        game.place(0, 1, 2, 0, 2, 2, 0, 3, 2);
        int[][] result = game.moveRight();
        assertEquals(4, result[0][3]);
        assertEquals(2, result[0][2]);
        assertEquals(0, result[0][1]);
        assertEquals(0, result[0][0]);
    }

    @Test
    public void moveUpWithFourWithCombine() {
        game.place(0, 0, 2, 1, 0, 2, 2, 0, 2, 3, 0, 2);
        int[][] result = game.moveUp();
        assertEquals(4, result[0][0]);
        assertEquals(4, result[1][0]);
        assertEquals(0, result[2][0]);
        assertEquals(0, result[3][0]);
    }

    @Test
    public void moveUpWithTwoWithoutCombine() {
        game.place(0, 0, 2, 0, 1, 4);
        int[][] result = game.moveUp();
        assertEquals(2, result[0][0]);
        assertEquals(4, result[0][1]);
    }

    @Test
    public void moveUpWithTwoWithCombine() {
        game.place(0, 0, 2, 1, 0, 2);
        int[][] result = game.moveUp();
        assertEquals(4, result[0][0]);
        assertEquals(0, result[1][0]);
    }

    @Test
    public void moveUpWithTwoWithCombineWithoutSequence() {
        game.place(0, 0, 2, 3, 0, 2);
        int[][] result = game.moveUp();
        assertEquals(4, result[0][0]);
        assertEquals(0, result[0][1]);
        assertEquals(0, result[0][2]);
        assertEquals(0, result[1][0]);
    }




    @Test
    public void moveDownWithFourWithCombine() {
        game.place(0, 0, 2, 1, 0, 2, 2, 0, 2, 3, 0, 2);
        int[][] result = game.moveDown();
        assertEquals(4, result[3][0]);
        assertEquals(4, result[2][0]);
        assertEquals(0, result[1][0]);
        assertEquals(0, result[0][0]);
    }

    @Test
    public void moveDownWithTwoWithoutCombine() {
        game.place(0, 0, 2, 0, 1, 4);
        int[][] result = game.moveDown();
        assertEquals(2, result[3][0]);
        assertEquals(4, result[3][1]);
    }

    @Test
    public void moveDownWithTwoWithCombine() {
        game.place(0, 0, 2, 1, 0, 2);
        int[][] result = game.moveDown();
        assertEquals(4, result[3][0]);
        assertEquals(0, result[1][0]);
    }

    @Test
    public void moveDownWithTwoWithCombineWithoutSequence() {
        game.place(0, 0, 2, 3, 0, 2);
        int[][] result = game.moveDown();
        assertEquals(4, result[3][0]);
        assertEquals(0, result[0][1]);
        assertEquals(0, result[0][2]);
        assertEquals(0, result[1][0]);
    }

}
