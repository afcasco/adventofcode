package com.adventofcode.y2022.day10;

public class Noop implements Instruction {

    private final int duration;

    public Noop() {
        this.duration = 1;
    }

    public int getDuration() {
        return duration;
    }
}
