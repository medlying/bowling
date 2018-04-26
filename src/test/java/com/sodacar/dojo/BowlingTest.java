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
        Frame frame = game.getFrame().get(0);
        Pin pin = frame.getPins().get(0);
        game.roll(10);
        assertEquals(game.score(), 10);
        assertTrue(frame.getStatus() == Frame.Status.STRIKE);
    }

}
