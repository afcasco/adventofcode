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

        // Parse input into list of monkeys
        String[] monkeys = Files.readString(Path.of("src/main/resources/day11sample")).split("\n\n");
        List<Monkey> monkes = Arrays.stream(monkeys).map(Monkey::parseMonkey).toList();

        // Set number of rounds
        int rounds = 20;


        for (int i = 0; i < rounds; i++) {
            // For every monkey
            for (Monkey monkey : monkes) {

                // Check and throw every item
                IntStream.range(0, monkey.getItems().size()).forEach(item -> {
                    monkey.addInspected();
                    int newWorryLvl = monkey.calcWorryLevel(item);
                    int yeetTo = monkey.friendlyYeet(newWorryLvl);
                    monkes.get(yeetTo).friendlyCatch(newWorryLvl);
                });
                // Clear current monkey item list, he got rid of everything
                monkey.getItems().clear();
            }
        }

        // Print each monkey details at the end of the run
        for (int i = 0; i < monkes.size(); i++) {
            System.out.println("index: " + i + " " + monkes.get(i));
        }

        // Get and print monkeyBusiness
        int monkeyBusiness = monkes.stream()
                .map(Monkey::getInspectedElements).sorted(Comparator.reverseOrder())
                .mapToInt(i -> i)
                .limit(2).reduce(1, (a, b) -> a * b);
        System.out.println(monkeyBusiness);

    }
}