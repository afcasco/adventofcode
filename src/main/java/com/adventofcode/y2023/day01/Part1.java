package com.adventofcode.y2023.day01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Part1 {
    public static void main(String[] args) throws IOException {

        Function<String, String> elfCalibrationParser = line -> {
            if (line.length() == 2) {
                return line;
            }
            if (line.length() == 1) {
                return line.repeat(2);
            }

            return line.substring(0, 1).concat(line.substring(line.length() - 1));
        };

        Function<String, String> elfNaNDiscard = line -> line.chars()
                .mapToObj(c -> (char) c)
                .filter(Character::isDigit)
                .map(Object::toString)
                .collect(Collectors.joining());

        long sum = Files.readAllLines(Path.of("src/main/resources/2023/day01input"))
                .stream()
                .map(elfNaNDiscard.andThen(elfCalibrationParser))
                .mapToInt(Integer::parseInt)
                .sum();

        System.out.println(sum);
    }
}