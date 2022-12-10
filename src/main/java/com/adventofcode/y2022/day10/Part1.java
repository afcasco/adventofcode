package com.adventofcode.y2022.day10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Part1 {
    public static void main(String[] args) throws IOException {
        List<Integer> points = List.of(20, 60, 100, 140, 180, 220);
        List<String> lines = Files.readAllLines(Path.of("src/main/resources/day10input"));
        List<Integer> strengths = new ArrayList<>();

        int register = 1;
        int cycle = 1;
        boolean changeCycle;

        for (String line : lines) {

            if (line.contains("noop")) {
                cycle++;
            } else {
                for (int i = 0; i < 2; i++) {
                    if (points.contains(cycle)) {
                        strengths.add(register * cycle);

                    }
                    changeCycle = i % 2 == 0;
                    cycle++;
                    if (!changeCycle) {
                        register += Integer.parseInt(line.split(" ")[1]);
                    }
                }
            }
        }
        System.out.println(strengths);
        System.out.println(strengths.stream().mapToInt(i -> i).sum());
    }
}
