package com.adventofcode.y2022.day09;

import java.util.Set;

public class Rope {

    private final Coordinates head;
    private final Coordinates tail;
    Set<Coordinates> headKnownCords;

    public Rope(){
        this.head = new Coordinates();
        this.tail = new Coordinates();
    }

    public void applyMove(Move move){
        for(int i=0;i<move.getUnits();i++){
            head.move(move.getDirection());
            System.out.println(head);
        }
    }
}
