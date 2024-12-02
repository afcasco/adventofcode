package com.adventofcode.y2024.day1;

import com.adventofcode.utils.IOUtils;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class Part2 {
    public static void main(String[] args) throws IOException {
        var input = IOUtils.fileToLines("2024/day01input");

        var data = input.stream()
                .map(line -> line.split(" {3}"))
                .toList();

        List<Integer> left = data.stream().map(i -> Integer.valueOf(i[0])).sorted().toList();
        List<Integer> right = data.stream().map(i -> Integer.valueOf(i[1])).sorted().toList();

        var result = left.stream()
                .mapToInt( num -> Math.toIntExact(num * right.stream().filter(i -> Objects.equals(i, num)).count()))
                .sum();

        System.out.println(result);

    }
}
