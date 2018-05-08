package com.sodacar.dojo;

import com.sodacar.dojo.game.Game2048;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Hu bosong
 * @date 2018/5/4
 */
public class Game2048Test {

    private Game2048 game = new Game2048();

    @Test
    public void init() {
        game.init(new int[][]{{1, 1}, {2, 1}});
        assertEquals(2, game.getMax());
    }

    @Test
    public void testMoveLeft() {
        game.init(new int[][]{{1, 1}, {2, 1}});
        game.moveLeft();
        assertEquals(2, game.getMax());
    }

    @Test
    public void testMoveLeftWithHandle() {
        game.init(new int[][]{{1, 1}, {1, 2}});
        game.moveLeft();
        game.random(new int[][]{{1, 3}}, 4);
        game.moveLeft();
        assertEquals(8, game.getMax());
    }

    @Test
    public void testMoveLeftWithHandle1() {
        game.init(new int[][]{{1, 1}, {1, 2}});
        game.moveLeft();
        game.random(new int[][]{{1, 3}}, 2);
        game.moveLeft();
        game.random(new int[][]{{1, 3}}, 4);
        game.moveLeft();
        assertEquals(4, game.getMax());
    }

    @Test
    public void testMoveLeftWithHandle2() {
        game.init(new int[][]{{1, 1}, {1, 2}});
        game.moveLeft();
        game.random(new int[][]{{1, 3}}, 2);
        game.moveLeft();
        game.random(new int[][]{{1, 3}}, 4);
        game.moveLeft();
        game.random(new int[][]{{1, 3}}, 4);
        game.moveLeft();
        assertEquals(8, game.getMax());
    }

    @Test
    public void testMoveRight() {
        game.init(new int[][]{{1, 1}, {2, 1}});
        game.moveRight();
        assertEquals(2, game.getMax());
    }

    @Test
    public void testMoveRightWithCombine() {
        game.init(new int[][]{{1, 1}, {1, 2}});
        game.moveRight();
        assertEquals(4, game.getMax());
    }

    @Test
    public void testMoveUp() {
        game.init(new int[][]{{1, 1}, {1, 2}});
        game.moveUp();
        assertEquals(2, game.getMax());
    }

    @Test
    public void testMoveUpWithCombine() {
        game.init(new int[][]{{1, 1}, {2, 1}});
        game.moveUp();
        assertEquals(4, game.getMax());
    }

    @Test
    public void testMoveDown() {
        game.init(new int[][]{{1, 1}, {1, 2}});
        game.moveDown();
        assertEquals(2, game.getMax());
    }

    @Test
    public void testMoveDownWithCombine() {
        game.init(new int[][]{{1, 1}, {2, 1}});
        game.moveDown();
        assertEquals(4, game.getMax());
    }
}
