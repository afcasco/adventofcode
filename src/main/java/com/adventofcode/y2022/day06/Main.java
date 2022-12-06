package com.adventofcode.y2022.day06;

import com.adventofcode.utils.IOUtils;

import java.io.IOException;
import java.util.stream.IntStream;

public class Main {

    public static int findStart(String input, int length) throws IOException {
        String data = IOUtils.readInputFile(input).get(0);
        return IntStream.range(length, data.length()).parallel()
                .filter(i -> data.substring(i - length, i).chars().distinct().count() == length)
                .findFirst().orElse(-1);
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Part 1 result: " + findStart("day06input", 4));
        System.out.println("Part 2 result: " + findStart("day06input", 14));
    }
}