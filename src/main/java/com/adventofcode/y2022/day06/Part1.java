package com.adventofcode.y2022.day06;

import com.adventofcode.utils.IOUtils;

import java.io.IOException;
import java.util.stream.IntStream;

public class Part1 {

    public static int findStartOfPacket(String input) throws IOException {
        String data = IOUtils.readInputFile(input).get(0);
        return IntStream.range(0, data.length())
                .skip(4)
                .filter(i -> data.substring(i - 4, i).chars().distinct().count() == 4)
                .findFirst().orElse(-1);
    }
}