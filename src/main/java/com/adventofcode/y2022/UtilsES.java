package com.adventofcode.y2022;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UtilsES {
    public static List<List<Integer>> readData(String fileName) {
        List<List<Integer>> data = new ArrayList<>();

        try {
            File file = new File(fileName);
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
        return data;
    }
}