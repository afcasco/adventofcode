package com.adventofcode.y2022.day11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {

        // Get them monkeys into a list
        List<Monkey> monkeys = Arrays.stream(Files
                        .readString(Path.of("src/main/resources/day11sample")).
                        split("\n\n"))
                .map(Monkey::parseMonkey)
                .toList();

        // Set number of rounds
        int rounds = 20;

        for (int i = 0; i < rounds; i++) {
            // For every monkey
            for (Monkey monkey : monkeys) {
                // Check and throw every item
                IntStream.range(0, monkey.getItems().size()).forEach(item -> {
                    monkey.addInspected();
                    int newWorryLvl = monkey.calcWorryLevel(item);
                    int yeetTo = monkey.friendlyYeet(newWorryLvl);
                    monkeys.get(yeetTo).friendlyCatch(newWorryLvl);
                });
                // Clear current monkey item list, he got rid of everything
                monkey.clearItems();
            }
        }

        // Situation overview
        System.out.println("Overall monkey situation:");
        monkeys.forEach(System.out::println);

        // Top 2 business monkeys
        System.out.println("\nTop 2 monkey inspectors: ");
        monkeys.stream().map(Monkey::getInspectedElements)
                .sorted(Comparator.reverseOrder())
                .limit(2)
                .forEach(System.out::println);

        // Get and print monkeyBusiness level
        int monkeyBusiness = monkeys.stream()
                .map(Monkey::getInspectedElements)
                .sorted()
                .skip(monkeys.size() - 2)
                .mapToInt(i -> i)
                .reduce(1, (a, b) -> a * b);

        System.out.println("\nTroop business level: " + monkeyBusiness+"!");
    }
}