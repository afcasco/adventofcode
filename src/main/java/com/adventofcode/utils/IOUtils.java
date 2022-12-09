package com.adventofcode.utils;

import com.adventofcode.y2022.day05.Move;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
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


    public static List<String> fileToLines(String fileName) throws IOException {
        Path file = Path.of(System.getProperty("user.dir") +
                File.separator + "src" +
                File.separator + "main" +
                File.separator + "resources" +
                File.separator + fileName);
        return Files.readAllLines(file);
    }

    public static List<String> parseCrates(String inputFile) throws IOException {
        List<String> input = fileToLines(inputFile);

        int lastCrateLine = (int) input.stream().filter(i -> i.startsWith("[")).count();

        List<String> crates = input.subList(0, lastCrateLine + 1);
        Collections.reverse(crates);

        List<String> list = crates.stream()
                .map(i -> i.replaceAll("\\[", "-"))
                .map(i -> i.replaceAll("]", "-"))
                .toList();
        List<String> normalized = new ArrayList<>();
        for (String s : list) {
            normalized.add(s + " ".repeat(35 - s.length()));
        }
        List<String> newList = new ArrayList<>();
        for (String s : normalized) {
            StringBuilder builder = new StringBuilder();
            for (int i = 1; i <= 33; i += 4) {
                if (Character.isAlphabetic(s.charAt(i))) {
                    builder.append(s.charAt(i));
                } else if (Character.isSpaceChar(s.charAt(i))) {
                    builder.append(" ");
                }
            }
            newList.add(builder.toString());
        }
        return newList;
    }

    public static List<Move> parseMoves(String inputFile) throws IOException {
        List<String> input = fileToLines(inputFile);
        input = input.subList(10, input.size());
        List<Move> result = new ArrayList<>();
        input.stream()
                .map(i -> i.split(" "))
                .map(i -> List.of(Integer.parseInt(i[1]), Integer.parseInt(i[3]) - 1, Integer.parseInt(i[5]) - 1))
                .forEach(i -> result.add(new Move(i.get(0), i.get(1), i.get(2))));
        return result;
    }
}