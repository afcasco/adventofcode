package com.adventofcode.y2022;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IOUtils {
    public static List<List<Integer>> readDay01(String fileName) {
        var data = new ArrayList<List<Integer>>();

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


    public static List<String> readInputFile(String fileName) throws IOException {
        Path file = Path.of(System.getProperty("user.dir") +
                File.separator + "src" +
                File.separator + "main" +
                File.separator + "resources" +
                File.separator + fileName);
        return Files.readAllLines(file);
    }
}