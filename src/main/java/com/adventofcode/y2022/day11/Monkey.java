package com.adventofcode.y2022.day11;

import java.util.*;

import static com.adventofcode.y2022.day11.Operation.*;

public class Monkey {

    private final List<Long> items;
    private final Operation operation;

    private final int test;

    private final int[] throwOptions;
    private int inspectedElements;

    private Monkey(List<Long> items, Operation operation, int test, int[] throwOptions) {
        this.items = items;
        this.operation = operation;
        this.test = test;
        this.throwOptions = throwOptions;
        this.inspectedElements = 0;
    }

    public List<Long> getItems() {
        return items;
    }

    public int getTest() {
        return test;
    }

    public int getInspectedElements() {
        return inspectedElements;
    }

    public void addInspected() {
        this.inspectedElements++;
    }

    public static Monkey parseMonkey(String monkey) {

        List<String> lines = Arrays.stream(monkey.split("\n")).map(String::trim).toList();
        return new Monkey(
                parseItems(lines.get(1)),
                parseOperation(lines.get(2)),
                parseTest(lines.get(3)),
                parseThrowOptions(lines.get(4), lines.get(5)));
    }

    private static int[] parseThrowOptions(String line1, String line2) {
        return new int[]{Integer.parseInt(line1.split("monkey")[1].trim()),
                Integer.parseInt(line2.split("monkey")[1].trim())
        };
    }

    private static int parseTest(String line) {
        return Integer.parseInt(line.split("by")[1].trim());

    }

    public void clearItems() {
        items.clear();
    }

    public long calcWorryLevel(int index, int lcm) {
        long worry = items.get(index);
        worry = operation.computeNext(worry);
        // For part 1:
        // return worry / 3;

        // For part 2
        return worry % lcm;
    }

    public void friendlyCatch(long element) {
        items.add(element);
    }

    public int friendlyYeet(long worry) {
        return runTest(worry) ? throwOptions[0] :
                throwOptions[1];
    }

    private boolean runTest(long value) {
        return value % test == 0;
    }

    private static List<Long> parseItems(String items) {
        String parsed = items.replaceAll("\\D", " ").trim().replaceAll(" + ", ",");
        List<Long> itemList = new ArrayList<>();
        String[] array = parsed.split(",");
        for (String a : array)
            itemList.add(Long.parseLong(a));
        return itemList;
    }
}
