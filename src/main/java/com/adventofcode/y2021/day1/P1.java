package com.adventofcode.y2021.day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class P1 {
    public static void main(String[] args) {
        List<Integer> data;
        try (Stream<String> givenData = Files.lines(Path.of("day01input"))) {
            data = givenData.map(Integer::parseInt).toList();
            System.out.println("reading file...");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int result = IntStream.range(1, data.size()).map(i -> data.get(i) > data.get(i - 1) ? 1 : 0).sum();
        System.out.println(result);
    }
}
