package com.adventofcode.y2022.day09;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Rope {
    public record Move(char direction, int units) {
    }

    private final Coordinates head;
    private final List<Coordinates> knots;
    private final int length;

    private final Set<Coordinates> tailKnownCords;

    public Rope(int length) {
        this.head = new Coordinates();
        this.length = length;
        knots = Stream.generate(Coordinates::new).limit(length).toList();
        this.tailKnownCords = Stream.of(new Coordinates()).collect(Collectors.toSet());
    }

    public void applyMove(Move move) {
        for (int i = 0; i < move.units(); i++) {
            head.move(move.direction());
            Coordinates tempKnot = head;
            for (Coordinates knot : knots) {
                knot.followHead(tempKnot);
                tempKnot = knot;
            }
            tailKnownCords.add(new Coordinates(knots.get(length - 1)));
        }
    }

    public Set<Coordinates> getTailKnownCords() {
        return tailKnownCords;
    }
}