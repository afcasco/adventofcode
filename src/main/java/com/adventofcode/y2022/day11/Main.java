package com.adventofcode.y2022.day11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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

                for (int j = 0; j < monkey.getItems().size(); j++) {

                    monkey.increaseInspected();
                    int worry = monkey.getItems().get(j);
                    worry = monkey.getOperation().computeNext(worry);
                    worry /= 3;
                    int recipient = monkey.runTest(worry) ? monkey.getThrowOptions()[0] :
                            monkey.getThrowOptions()[1];
                    monkes.get(recipient).getItems().add(worry);
                }
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
