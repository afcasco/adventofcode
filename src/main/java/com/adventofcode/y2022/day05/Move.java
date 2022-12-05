package com.adventofcode.y2022.day05;

public class Move {
    private final int quantity;
    private final int origin;
    private final int destination;

    public Move(int quantity, int from, int to) {
        this.quantity = quantity;
        this.origin = from;
        this.destination = to;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getOrigin() {
        return origin;
    }

    public int getDestination() {
        return destination;
    }

    @Override
    public String toString() {
        return "move " + quantity + " from " + origin + " to " + destination;
    }
}