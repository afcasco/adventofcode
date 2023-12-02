package com.adventofcode.y2023.day02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Part2 {
    public static void main(String[] args) throws IOException {

        long result = Files.readAllLines(Path.of("src/main/resources/2023/day02input"))
                .stream()
                .map(Game::parseGame)
                .mapToInt(Game::minimumCubesPower).sum();

        System.out.println(result);
    }
}
