package com.adventofcode.y2022.day04;

import com.adventofcode.y2022.IOUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Part1 {

    private static List<Integer> transform(String str){
        int[] values = new int[]{Integer.parseInt(str.split("-")[0]), Integer.parseInt(str.split("-")[1])};
        List<Integer> sections = new ArrayList<>();
        for (int i = values[0]; i <= values[1]; i++) {
            sections.add(i);
        }
        return sections;
    }

    public static int result() throws IOException {
        List<String> data = IOUtils.readInputFile("day04input");
        return (int) data.stream()
                .map(input -> List.of(transform(input.split(",")[0]),transform(input.split(",")[1])))
                .filter(list ->
                        new HashSet<>(list.get(0)).containsAll(list.get(1))
                                || new HashSet<>(list.get(1)).containsAll(list.get(0)))
                .count();
    }
}