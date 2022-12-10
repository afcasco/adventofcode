package com.adventofcode.y2022.day10;

import java.util.ArrayList;
import java.util.List;

public class Device {

    private int cycle;
    private int register;
    private int crtPos;
    private final List<Integer> points = List.of(20, 60, 100, 140, 180, 220);
    private final StringBuilder displayBuffer;
    private final List<Integer> strengthSignals;

    public StringBuilder getDisplayBuffer() {
        return displayBuffer;
    }

    public List<Integer> getStrengthSignals() {
        return strengthSignals;
    }

    public Device() {
        register = 1;
        cycle = 0;
        crtPos = 0;
        strengthSignals = new ArrayList<>();
        displayBuffer = new StringBuilder();
    }

    public void load(List<Instruction> instructions) {
        for (Instruction instruction : instructions) {
            if (instruction instanceof Noop) {
                runCycle(instruction.getDuration());
            } else {
                AddX add = (AddX) instruction;
                // addX
                runCycle(add.getDuration());
                register += add.getrValue();
            }
        }
    }

    private void runCycle(int n) {
        // run n cycles
        for (int i = 0; i < n; i++) {
            draw();
            cycle++;
            // Only add signals in the cycles given in the points list
            if (points.contains(cycle)) {
                strengthSignals.add(cycle * register);
            }
        }
    }

    private void draw() {
        // every 40th cycle add a new line and reset horizontal pos to 0
        if (points.contains(cycle - 20)) {
            crtPos = 0;
            displayBuffer.append("\n");
        }

        if (crtPos == register || crtPos == register + 1 || crtPos == register - 1) {
            displayBuffer.append("#");
        } else {
            displayBuffer.append("_");
        }
        crtPos++;
    }
}
