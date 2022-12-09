package com.adventofcode.y2022.day09;

import com.adventofcode.utils.IOUtils;

import java.io.IOException;
import java.util.List;

public class Part1 {
    public static void main(String[] args) throws IOException {

        List<Move> moves = IOUtils.readInputFile("day09sample").stream().map(Move::new).toList();
        Rope rope = new Rope();

        Coordinates a = new Coordinates(5,1);
        Coordinates b = new Coordinates(3,0);
        System.out.println(Coordinates.touch(a,b));

    }
}
