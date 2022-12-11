package com.adventofcode.y2022.day10;

import java.util.ArrayList;
import java.util.List;

public class Device {

    private int cycle;
    private int register;
    private int displayPosX;
    private final List<Integer> points = List.of(20, 60, 100, 140, 180, 220);
    private final StringBuilder display;
    private final List<Integer> strengthSignals;

    public StringBuilder getDisplay() {
        return display;
    }

    public List<Integer> getStrengthSignals() {
        return strengthSignals;
    }

    public Device() {
        register = 1;
        cycle = 0;
        displayPosX = 0;
        strengthSignals = new ArrayList<>();
        display = new StringBuilder();
    }

    public void load(List<Instruction> instructions) {
        for (Instruction instruction : instructions) {
            runCMD(instruction);
            if (instruction instanceof AddX) {
                register +=  ((AddX) instruction).getrValue();
            }
        }
    }

    private void runCMD(Instruction instruction) {
        // run instruction through all needed cicles
        for (int i = 0; i < instruction.getDuration(); i++) {
            drawPixel();
            cycle++;
            // Only add signals in the cycles given in the points list
            if (points.contains(cycle)) {
                strengthSignals.add(cycle * register);
            }
        }
    }

    private void drawPixel() {
        // every 40th cycle add a new line and reset horizontal pos to 0
        if (points.contains(cycle - 20)) {
            displayPosX = 0;
            display.append("\n");
        }

        // if sliding sprite (register+-1) equals crtPos draw # else draw _
        if (displayPosX == register || displayPosX == register + 1 || displayPosX == register - 1) {
            display.append("#");
        } else {
            display.append("_");
        }
        displayPosX++;
    }
}
