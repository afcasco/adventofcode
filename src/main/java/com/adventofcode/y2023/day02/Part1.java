package com.adventofcode.y2023.day02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Part1 {
    public static void main(String[] args) throws IOException {

        int red = 12;
        int blue = 14;
        int green = 13;

        long result = Files.readAllLines(Path.of("src/main/resources/2023/day02input"))
                .stream()
                .map(Game::parseGame)
                .filter(game -> game.isPossible(red,blue,green))
                .mapToInt(Game::getId).sum();

        System.out.println(result);
    }
}
