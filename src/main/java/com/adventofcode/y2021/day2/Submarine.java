package com.adventofcode.y2021.day2;

public class Submarine {
    private int horizontal;
    private int depth;

    public int getHorizontal() {
        return horizontal;
    }

    public int getDepth() {
        return depth;
    }

    public Submarine() {
        this.horizontal = 0;
        this.depth = 0;
    }

    public void move(Move move) {
        switch (move.getCommand()) {
            case "forward" -> this.horizontal += move.getUnits();
            case "up" -> this.depth -= move.getUnits();
            case "down" -> this.depth += move.getUnits();
        }
    }

    @Override
    public String toString(){
        return "Final position:\n" + this.horizontal+"\n"+this.depth;
    }
}