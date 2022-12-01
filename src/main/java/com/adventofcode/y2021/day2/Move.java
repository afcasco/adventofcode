package com.adventofcode.y2021.day2;

public class Move {
    private String command;
    private int units;

    public String getCommand() {
        return command;
    }

    public int getUnits() {
        return units;
    }

    public Move(String command, int units) {
        this.command = command;
        this.units = units;
    }

    @Override
    public String toString() {
        return this.command + " " + this.units;
    }
}
