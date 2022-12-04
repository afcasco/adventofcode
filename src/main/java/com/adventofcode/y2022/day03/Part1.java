package com.adventofcode.y2022.day03;

import com.adventofcode.y2022.IOUtils;

import java.util.List;

public class Part1 {

    public static void main(String[] args) {
        List<String> data = IOUtils.readInputFile("day03input"); // Read all lines as list
        int result = data.stream()
                .map(ln -> new String[]{ln.substring(0, ln.length() / 2), ln.substring(ln.length() / 2)})
                .map(strArray -> {
                    for (char c : strArray[0].chars().mapToObj(c -> (char) c).toList()) {
                        if (strArray[1].indexOf(c) != -1) {
                            return c;
                        }
                    }
                    return '-';
                })
                .mapToInt(c -> c > 96 ? c - 96 : c - 38)
                .sum();
        System.out.println(result);
    }
}