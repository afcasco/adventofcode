package com.adventofcode.y2022.day09;

import com.adventofcode.utils.IOUtils;

import java.io.IOException;
import java.util.List;

public class Part1 {
    public static void main(String[] args) throws IOException {

        List<Rope.Move> moves = IOUtils.fileToLines("day09input").stream()
                .map(ln -> new Rope.Move(ln.charAt(0), Integer.parseInt(ln.substring(2))))
                .toList();

        // Part 1
        Rope part1rope = new Rope(1);
        moves.forEach(part1rope::applyMove);
        System.out.println("Length 1 rope: " + part1rope.getTailKnownCords().size());

        // Part 2
        Rope part2rope = new Rope(9);
        moves.forEach(part2rope::applyMove);
        System.out.println("Length 9 rope: " + part2rope.getTailKnownCords().size());
    }
}