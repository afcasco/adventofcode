package com.adventofcode.y2022.day10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> input = Files.readAllLines(Path.of("src/main/resources/day10input"));
        Device device = new Device();
        device.loadInstructions(input);

        System.out.println("Part 1 result: " + device.getStrengthSignals().stream().mapToInt(i -> i).sum());

        System.out.println("-".repeat(40));
        System.out.println(device.getCrtImage());
        System.out.println(device.getStrengthSignals());
    }
}
