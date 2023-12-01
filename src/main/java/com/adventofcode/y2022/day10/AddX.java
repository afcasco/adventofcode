package com.adventofcode.y2022.day10;

public class AddX implements Instruction {

    private final int duration;
    private final int rValue;

    public AddX(int rValue) {
        this.duration = 2;
        this.rValue = rValue;
    }

    public int getrValue() {
        return rValue;
    }

    @Override
    public int getDuration() {
        return duration;
    }
}
