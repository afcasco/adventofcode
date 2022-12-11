package com.adventofcode.y2022.day11;

public class Operation {

    private final char operator;
    private final int value;

    private Operation(char operator, int value) {
        this.operator = operator;
        this.value = value;
    }

    public int computeNext(int old) {
        int operand = value == -1 ? old : value;
        return switch (operator) {
            case '+' -> old + operand;
            case '*' -> old * operand;
            default -> 0;
        };
    }

    public static Operation parseOperation(String op) {
        op = op.split("=")[1].trim();
        String[] parts = op.split(" ");
        return new Operation(parts[1].charAt(0), parts[2].equals("old") ? -1 : Integer.parseInt(parts[2]));
    }

    @Override
    public String toString() {
        return "old " + operator + " " + value;
    }


}
