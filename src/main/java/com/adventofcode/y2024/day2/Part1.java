package com.adventofcode.y2024.day2;

import com.adventofcode.utils.IOUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Part1 {
    public static void main(String[] args) throws IOException {
        var input = IOUtils.fileToLines("2024/day02input")
                .stream()
                .map(toIntList)
                .peek(System.out::println)
                .map(mapToSafety)
                .mapToInt(Integer::valueOf)
                .peek(System.out::println)
                .sum();

        System.out.println(input);
    }

    static Function<String, List<Integer>> toIntList = line ->
            Arrays.stream(line.split(" ")).map(Integer::parseInt).toList();

    static Predicate<List<Integer>> allIncOrDecr = list -> {

        var isIncreasing = true;
        var isDecreasing = true;

        for (var i = 1; i < list.size(); i++) {
            if (list.get(i) >= list.get(i - 1)) {
                isDecreasing = false;
            } else if (list.get(i) <= list.get(i - 1)) {
                isIncreasing = false;
            }
        }
        return isIncreasing || isDecreasing;
    };

    static Function<List<Integer>, Integer> mapToSafety = list -> {

        if (!allIncOrDecr.test(list)) {
            return 0;
        }
        for (int i = 1; i < list.size(); i++) {
            if (Math.abs(list.get(i) - list.get(i - 1)) > 3 ||
                    Math.abs(list.get(i) - list.get(i - 1)) < 1)
                return 0;
        }
        return 1;
    };
}