package com.adventofcode.y2022.day07;

import com.adventofcode.utils.IOUtils;

import java.io.IOException;

import java.nio.file.Path;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        // Reads input and loads into the ElfFileSystem
        List<String> data = IOUtils.readInputFile("day07input");
        ElfFileSystem fs = new ElfFileSystem(data);

        //  Generates a map with all the paths in the ElfFileSystem with its whole size
        Map<Path, Integer> pathSize = new HashMap<>();
        fs.getElfFileSystemPaths().forEach(i -> pathSize.put(i, fs.getPathContentSize(i)));

        // --------- Part 1, my input answer 1350966 ---------
        int part1 = pathSize.values().stream().filter(i -> i <= 100000).mapToInt(i -> i).sum();
        System.out.println("Part 1: " + part1);

        //  --------- Part 2, my input answer 6296435 ---------
        int usedSpace = pathSize.values().stream()
                .sorted(Comparator.reverseOrder())
                .limit(1)
                .findFirst()
                .orElse(-1);

        int neededSpace = 30000000 - 70000000 + usedSpace;

        int part2 = pathSize.values().stream().filter(i -> i >= neededSpace)
                .mapToInt(i -> i)
                .sorted()
                .limit(1).findFirst().orElse(-1);
        System.out.println("Part 2: " + part2);
    }
}