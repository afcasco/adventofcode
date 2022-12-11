package com.adventofcode.y2022.day11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {

        // Get them monkeys into a list
        List<Monkey> monkeys = Arrays.stream(Files
                        .readString(Path.of("src/main/resources/day11input")).
                        split("\n\n"))
                .map(Monkey::parseMonkey)
                .toList();

        // Set number of rounds
        int rounds = 10000;
        // Get monkey tests lcm
        int monkeyTestLCM = monkeys.stream().map(Monkey::getTest).reduce(1, (a, b) -> a * b);

        for (int i = 0; i < rounds; i++) {
            // For every monkey
            for (Monkey monkey : monkeys) {
                // Check and throw every item
                IntStream.range(0, monkey.getItems().size()).forEach(item -> {
                    monkey.addInspected();
                    long newWorryLvl = monkey.calcWorryLevel(item, monkeyTestLCM);
                    int yeetTo = monkey.friendlyYeet(newWorryLvl);
                    monkeys.get(yeetTo).friendlyCatch(newWorryLvl);
                });
                // Clear current monkey item list, he got rid of everything
                monkey.clearItems();
            }
        }

        // Get and print monkeyBusiness level
        long monkeyBusiness = monkeys.stream()
                .map(Monkey::getInspectedElements)
                .sorted()
                .skip(monkeys.size() - 2)
                .map(Long::valueOf)
                .reduce(1L, (a, b) -> a * b);

        System.out.println("\nTroop business level: " + monkeyBusiness + "!");
    }
}