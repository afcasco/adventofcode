package com.adventofcode.y2022.day01;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class P1 {
    public static void main(String[] args) {
        List<List<Integer>> data = new ArrayList<>();

        try {
            File file = new File("input1");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                List<Integer> calories = new ArrayList<>();
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (line.isEmpty()) {
                        break;
                    } else {
                        calories.add(Integer.parseInt(line));
                    }
                }
                data.add(calories);

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        int result = data.stream()
                .map(i -> i.stream().mapToInt(j -> j).sum()).mapToInt(i -> i)
                .max().orElse(-1);
        System.out.println(result);
    }
}
