package com.adventofcode.y2022.day01;

import com.adventofcode.y2022.UtilsES;

import java.util.List;

public class P1 {
    public static int day01solution() {
        List<List<Integer>> data = UtilsES.readData("input1");

        return data.stream()
                .map(i -> i.stream()
                        .mapToInt(j -> j)
                        .sum())
                .mapToInt(i -> i)
                .max().orElse(-1);
    }
}
