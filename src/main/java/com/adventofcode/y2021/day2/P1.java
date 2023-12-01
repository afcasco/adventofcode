package com.adventofcode.y2021.day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class P1 {
    public static void main(String[] args) {
        List<Move> moves = new ArrayList<>();
        try (Stream<String> data = Files.lines(Path.of("input2"))) {
            data.map(i -> i.split(" "))
                    .forEach(i -> moves.add(new Move(i[0], Integer.parseInt(i[1]))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Submarine sub = new Submarine();
        moves.forEach(sub::move);
        System.out.println(sub);
        System.out.println(sub.getDepth()*sub.getHorizontal());


    }


}
