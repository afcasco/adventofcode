package com.adventofcode.y2022.day05;

import com.adventofcode.y2022.IOUtils;

import java.io.IOException;
import java.util.*;

public class Part1 {

    private static List<String> parseCrates(String inputFile) throws IOException {
        List<String> input = IOUtils.readInputFile(inputFile);

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

    private static List<Move> parseMoves(String inputFile) throws IOException {
        List<String> input = IOUtils.readInputFile(inputFile);
        input = input.subList(10, input.size());
        List<Move> result = new ArrayList<>();
        input.stream()
                .map(i -> i.split(" "))
                .map(i -> List.of(Integer.parseInt(i[1]), Integer.parseInt(i[3]) - 1, Integer.parseInt(i[5]) - 1))
                .forEach(i -> result.add(new Move(i.get(0), i.get(1), i.get(2))));
        return result;
    }

    public static String result(String inputFile) throws IOException {
        CrateContainer crateContainer = new CrateContainer();
        crateContainer.fillCrates(parseCrates(inputFile));
        parseMoves(inputFile).forEach(crateContainer::moveElements);
        StringBuilder builder = new StringBuilder();
        crateContainer.getAllCrates().stream().map(Crate::getTopElement).forEach(builder::append);
        return builder.toString();
    }
}