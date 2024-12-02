package com.adventofcode.y2024.day2;

import com.adventofcode.utils.IOUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Part2 {
    public static void main(String[] args) throws IOException {
        var input = IOUtils.fileToLines("2024/day02input")
                .stream()
                .map(toIntList)
                .peek(System.out::println)
                .filter(mapToSafety)
                .count();

        System.out.println(input);
    }

    static Function<String, List<Integer>> toIntList = line ->
            Arrays.stream(line.split(" ")).map(Integer::parseInt).toList();

    static Predicate<List<Integer>> allIncOrDecr = list -> {
        boolean isIncreasing = true;
        boolean isDecreasing = true;

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1)) {
                isIncreasing = false;
            }
            if (list.get(i) >= list.get(i - 1)) {
                isDecreasing = false;
            }
        }

        return isIncreasing || isDecreasing;
    };

    static Predicate<List<Integer>> mapToSafety = list -> {
        if (isSafe(list)) return true;

        for (int i = 0; i < list.size(); i++) {
            var newList = removeLevel(list, i);
            if (isSafe(newList)) return true;
        }

        return false;
    };

    static boolean isSafe(List<Integer> list) {
        if (!allIncOrDecr.test(list)) return false;

        for (int i = 1; i < list.size(); i++) {
            int diff = Math.abs(list.get(i) - list.get(i - 1));
            if (diff < 1 || diff > 3) {
                return false;
            }
        }
        return true;
    }

    static List<Integer> removeLevel(List<Integer> list, int index) {
        return IntStream.range(0, list.size())
                .filter(i -> i != index)
                .mapToObj(list::get)
                .toList();
    }

}
