package com.sodacar.dojo.bowling;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

/**
 * @author Hu bosong
 * @date 2018/4/26
 */
public class Game {

    private static int index = 1;

    private static int score = 0;

    Map<Integer, Integer> map = new HashMap<>();

    private List<Frame> frames;

    public Game() {
        frames = asList(new Frame(), new Frame(), new Frame(),
                new Frame(), new Frame(), new Frame(), new Frame(),
                new Frame(), new Frame(), new Frame());
    }

    public void roll(int pins) {
        score += pins;
        if(pins == 10 && index == 1) {
            frames.get(0).setStatus(Frame.Status.STRIKE);
            map.put(index, pins);
        }
        index++;
    }

    public int score() {
        return score;
    }

    public List<Frame> getFrame() {
        return frames;
    }

    public void setFrame(List<Frame> frame) {
        this.frames = frame;
    }
}
