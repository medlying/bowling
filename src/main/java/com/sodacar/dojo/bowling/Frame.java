package com.sodacar.dojo.bowling;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author Hu bosong
 * @date 2018/4/26
 */
public class Frame {

    private int score;

    private Status status;

    private List<Pin> pins;


    public Frame() {
        pins = asList(new Pin(), new Pin());
    }

    public Status getStatus() {
        return status;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Pin> getPins() {
        return pins;
    }

    public void setPins(List<Pin> pins) {
        this.pins = pins;
    }

    public enum Status {
        STRIKE,
        SPARE,
        OTHER
    }
}
