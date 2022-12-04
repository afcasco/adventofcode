package com.adventofcode.y2022.day01;

import com.adventofcode.y2022.IOUtils;

public class Part1 {
    public static int solution() {
        var data = IOUtils.readDay01("day01input");

        return data.stream()
                .map(i -> i.stream()
                        .mapToInt(j -> j)
                        .sum())
                .mapToInt(i -> i)
                .max().orElse(-1);
    }
}