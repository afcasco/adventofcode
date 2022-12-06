package com.adventofcode.y2022.day06;

import com.adventofcode.utils.IOUtils;

import java.io.IOException;
import java.util.stream.IntStream;

public class Part2 {

    public static int findStartOfMessage(String input) throws IOException {
        String data = IOUtils.readInputFile(input).get(0);
        return IntStream.range(0, data.length())
                .skip(14)
                .filter(i -> data.substring(i - 14, i).chars().distinct().count() == 14)
                .findFirst().orElse(-1);
    }
}