package com.adventofcode.y2022.day09;

public class Move {

    private final char direction;
    private final int units;

    public Move(String move) {
        this.direction = move.charAt(0);
        this.units = Integer.parseInt(move.substring(2));
    }

    public char getDirection() {
        return direction;
    }

    public int getUnits() {
        return units;
    }
}