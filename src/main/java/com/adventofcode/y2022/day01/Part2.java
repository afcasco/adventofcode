package com.adventofcode.y2022.day01;

import com.adventofcode.y2022.UtilsES;

import java.util.Comparator;
import java.util.List;

public class Part2 {

    public static int solution(){
        List<List<Integer>> data = UtilsES.readData("day01input");
        return data.stream()
                .map(list -> list.stream()
                        .mapToInt(num -> num)
                        .sum())
                .mapToInt(sum -> sum)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .mapToInt(i -> i)
                .sum();
    }
}