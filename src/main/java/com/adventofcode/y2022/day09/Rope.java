package com.adventofcode.y2022.day09;

import java.util.HashSet;
import java.util.Set;

public class Rope {

    private final Coordinates head;
    private final Coordinates tail;
    private final Set<Coordinates> headKnownCords;

    public Rope() {
        this.head = new Coordinates();
        this.tail = new Coordinates();
        this.headKnownCords = new HashSet<>();
        this.headKnownCords.add(new Coordinates(0, 0));
    }

    public Set<Coordinates> getHeadKnownCords() {
        return headKnownCords;
    }

    public void applyMove(Move move) {
        for (int i = 0; i < move.getUnits(); i++) {
            head.move(move.getDirection());
            if (!Coordinates.touch(head, tail)) {
                tail.followHead(head);
                headKnownCords.add(new Coordinates(tail.getX(), tail.getY()));
            }
        }
    }
}