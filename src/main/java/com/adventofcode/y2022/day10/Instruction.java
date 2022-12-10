package com.adventofcode.y2022.day10;

public interface Instruction {

    int getDuration();

    static Instruction getInstruction(String instruction) {
        if (instruction.startsWith("n")) {
            return new Noop();
        }
        int value = Integer.parseInt(instruction.split(" ")[1]);
        return new AddX(value);
    }
}
