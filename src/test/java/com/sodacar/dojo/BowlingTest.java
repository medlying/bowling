package com.sodacar.dojo;

import com.sodacar.dojo.bowling.Frame;
import com.sodacar.dojo.bowling.Game;
import com.sodacar.dojo.bowling.Pin;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Hu bosong
 * @date 2018/4/26
 */
public class BowlingTest {

    @Test
    public void testIsStrike() {
        Game game = new Game();
        game.roll(10);
        assertEquals(game.score(), 10);
    }

}
