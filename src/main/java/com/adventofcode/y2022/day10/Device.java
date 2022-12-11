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
            crtPos = 0;
            displayBuffer.append("\n");
        }

        // if sliding sprite (register+-1) equals crtPos draw # else draw _
        if (crtPos == register || crtPos == register + 1 || crtPos == register - 1) {
            displayBuffer.append("#");
        } else {
            displayBuffer.append("_");
        }
        crtPos++;
    }
}
