package com.sodacar.dojo.bowling;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author Hu bosong
 * @date 2018/4/26
 */
public class Game {

    private static int index = 0;

    private List<Frame> frames;

    public Game() {
        frames = asList(new Frame(), new Frame(), new Frame(),
                new Frame(), new Frame(), new Frame(), new Frame(),
                new Frame(), new Frame(), new Frame());
    }

    public void roll(int pins) {
        if (pins == 10) {
            frames.get(index).setStatus(Frame.Status.STRIKE);
            frames.get(index).getBalls().add(new Ball(pins));
            frames.get(index).setScore(pins);
            index++;
        } else {

            frames.get(index++).getBalls().add(new Ball(pins));
            frames.get(index - 1).setScore(pins);
        }
    }


    public boolean isStrike(int pins) {
        if (pins == 10) {
            return true;
        }
        return false;
    }

    public int score() {
        return frames.stream().map(Frame::getScore).reduce(0, Integer::sum);
    }

    public List<Frame> getFrame() {
        return frames;
    }

    public void setFrame(List<Frame> frame) {
        this.frames = frame;
    }
}
