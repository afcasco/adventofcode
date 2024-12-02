package com.adventofcode.y2024.day1;

import com.adventofcode.utils.IOUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Part1 {
    public static void main(String[] args) throws IOException {
        var input = IOUtils.fileToLines("2024/day01input");

         var data = input.stream()
                .map(line -> line.split(" {3}"))
                 .toList();

        List<Integer> left = data.stream().map(i-> Integer.valueOf(i[0])).sorted().toList();
        List<Integer> right = data.stream().map(i-> Integer.valueOf(i[1])).sorted().toList();

        var result = IntStream.range(0, data.size())
                .map(i-> right.get(i) - left.get(i))
                .map(Math::abs)
                .sum();

        System.out.println(result);


    }
}
