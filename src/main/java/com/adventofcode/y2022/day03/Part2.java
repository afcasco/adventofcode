package com.adventofcode.y2022.day03;

import com.adventofcode.utils.IOUtils;

import java.io.IOException;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

public class Part2 {
    public static void main(String[] args) throws IOException {
        List<String> data = IOUtils.fileToLines("day03input");
        List<Character> alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".chars()
                .mapToObj(c -> (char) c)
                .toList();

        Function<String[], Character> allContain = strA -> (char) alphabet.stream()
                .filter(i -> strA[0].indexOf(i) != -1 && strA[1].indexOf(i) != -1 && strA[2].indexOf(i) != -1)
                .findFirst().orElse(' ');

        int result = IntStream.iterate(0, i -> i + 3)
                .limit(data.size() / 3)
                .mapToObj(i -> new String[]{data.get(i), data.get(i + 1), data.get(i + 2)})
                .map(allContain)
                .mapToInt(c -> c > 96 ? c - 96 : c - 38)
                .sum();

        System.out.println(result);
    }
}