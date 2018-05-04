package com.sodacar.dojo;

import com.sodacar.dojo.bowling.Game;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Hu bosong
 * @date 2018/4/26
 */
public class BowlingTest {

    private Game game = new Game();

    @Test
    public void rollingOneScore() {
        game.roll(1);
        assertEquals(game.score(), 1);
    }

    @Test
    public void rollingTwoScore() {
        game.roll(2);
        assertEquals(game.score(), 2);
    }

    @Test
    public void rollingOneThenOneScoreTwo() {
        for (int i = 0; i < 2; i++)
            game.roll(1);
        assertEquals(game.score(), 2);
    }

    @Test
    public void rollingASpareThenRollingOneScore() {
        game.roll(4);
        game.roll(6);
        game.roll(1);
        assertEquals(game.score(), 12);
    }

    @Test
    public void rollingOneThenOneThenFiveTwiceThenOne() {
        game.roll(1);
        game.roll(5);
        game.roll(5);
        game.roll(1);
        assertEquals(12, game.score());
    }

    @Test
    public void rollingOneOneThenSpareThenOne() {
        game.roll(1);
        game.roll(1);
        game.roll(5);
        game.roll(5);
        game.roll(1);
        assertEquals(14, game.score());
    }

    @Test
    public void rollingStrikeThenOneOne() {
        game.roll(10);
        game.roll(1);
        game.roll(1);
        assertEquals(14, game.score());
    }

    @Test
    public void rolingOneOneOne() {
        game.roll(1);
        game.roll(1);
        game.roll(1);
        assertEquals(3, game.score());
    }

    @Test
    public void rollingOneOneStrikeThenOneOne(){
        game.roll(1);
        game.roll(1);
        game.roll(10);
        game.roll(1);
        game.roll(1);
        assertEquals(16, game.score());
    }
}
