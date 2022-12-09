package com.adventofcode.y2022.day04;

import com.adventofcode.utils.IOUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Part2 {

    private static List<Integer> joinSections(String str) {
        int[] values = new int[]{Integer.parseInt(str.split("-")[0]), Integer.parseInt(str.split("-")[1])};
        List<Integer> sections = new ArrayList<>();
        for (int i = values[0]; i <= values[1]; i++) {
            sections.add(i);
        }
        return sections;
    }

    public static int result() throws IOException {
        List<String> data = IOUtils.fileToLines("day04input");
        return (int) data.stream().map(str -> str.split(","))
                .map(i -> List.of(joinSections(i[0]), joinSections(i[1])))
                .map(i -> i.get(0).removeAll(i.get(1)))
                .filter(i -> i)
                .count();
    }
}