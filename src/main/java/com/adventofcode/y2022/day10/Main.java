package com.adventofcode.y2022.day10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Instruction> instructions = Files.readAllLines(Path.of("src/main/resources/day10input"))
                .stream()
                .map(Instruction::getInstruction)
                .toList();

        Device device = new Device();
        device.load(instructions);
        System.out.println("Part 1 result: " + device.getStrengthSignals().stream().mapToInt(i -> i).sum());

        System.out.println("-".repeat(40));
        System.out.println(device.getDisplayBuffer());
    }
}
