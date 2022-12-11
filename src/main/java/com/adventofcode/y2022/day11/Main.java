package com.adventofcode.y2022.day11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        String input = Files.readString(Path.of("src/main/resources/day11sample"));
        String[] monkeys = input.split("\n\n");
        // Get a list with all the monkeys
        List<Monkey> monkes = new ArrayList<>();
        for (String monkey : monkeys) {
            monkes.add(Monkey.parseMonkey(monkey));
        }

        for (int i = 0; i < monkes.size(); i++) {
            System.out.println("index: " + i + " " + monkes.get(i));
        }

        System.out.println(monkes.size());
        int rounds = 1;
        for (int i = 0; i < rounds; i++) {
            for (Monkey monkey : monkes) {

                for (int j = 0; j < monkey.getItems().size(); j++) {
                    // inspect item and throw to another monkey fore every item
                    int worry = monkey.getItems().get(j);
                    worry = monkey.getOperation().computeNext(worry);
                    worry /= 3;
                    int recipient = monkey.runTest(worry) ? monkey.getThrowOptions()[0] :
                            monkey.getThrowOptions()[1];

                    System.out.println("throw to: "+recipient);
                }

            }

        }


    }
}
