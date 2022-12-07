package com.adventofcode.y2022.day07;

import com.adventofcode.utils.IOUtils;

import java.io.IOException;

import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

        // Reads input and loads it into the ElfFileSystem using the constructor.
        List<String> data = IOUtils.readInputFile("day07input");
        ElfFileSystem fs = new ElfFileSystem(data);

        //  Generates a map, keys are all the ElfFileSystem paths, values are all the path contents size added.
        Map<Path, Integer> pathSize = fs.getElfFileSystemPaths().stream()
                .collect(Collectors.toMap(i -> i, fs::getPathContentSize));

        // --------- Part 1, my input answer 1350966 ---------
        int part1 = pathSize.values().stream().filter(i -> i < 100000).mapToInt(i -> i).sum();
        System.out.println("Part 1: " + part1);

        //  --------- Part 2, my input answer 6296435 ---------
        int neededSpace = pathSize.values().stream()
                .sorted(Comparator.reverseOrder()).limit(1)
                .findFirst().orElse(-1) + 30000000 - 70000000;

        int part2 = pathSize.values().stream().filter(i -> i >= neededSpace)
                .mapToInt(i -> i)
                .sorted()
                .limit(1).findFirst().orElse(-1);
        System.out.println("Part 2: " + part2);
    }
}