package com.sodacar.dojo.bowling;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hu bosong
 * @date 2018/4/26
 */
public class Frame {

    private int score;

    private Status status;

    private List<Ball> balls;


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

    public List<Ball> getBalls() {
        balls = new ArrayList<>();
        return balls;
    }

    public void setBalls(List<Ball> balls) {
        this.balls = balls;
    }

    public enum Status {
        STRIKE,
        SPARE,
        OTHER
    }
}
