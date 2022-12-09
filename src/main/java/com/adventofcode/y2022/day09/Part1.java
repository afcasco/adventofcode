package com.adventofcode.y2022.day09;

import com.adventofcode.utils.IOUtils;

import java.io.IOException;
import java.util.List;

public class Part1 {
    public static void main(String[] args) throws IOException {

        List<Move> moves = IOUtils.readInputFile("day09input").stream().map(Move::new).toList();
        Rope rope = new Rope();
        moves.forEach(rope::applyMove);
        System.out.println(rope.getHeadKnownCords().size());
    }
}
