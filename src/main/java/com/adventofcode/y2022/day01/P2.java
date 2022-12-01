package com.adventofcode.y2022.day01;

import com.adventofcode.y2022.UtilsES;

import java.util.Comparator;
import java.util.List;

public class P2 {

    public static int day02solution(){
        List<List<Integer>> data = UtilsES.readData("input1");
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