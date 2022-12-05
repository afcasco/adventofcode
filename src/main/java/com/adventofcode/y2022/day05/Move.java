package com.adventofcode.y2022.day05;

public record Move(int quantity, int origin, int destination) {

    @Override
    public String toString() {
        return "move " + quantity + " from " + origin + " to " + destination;
    }
}