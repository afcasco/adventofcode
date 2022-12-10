package com.adventofcode.y2022.day10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Integer> points = List.of(20, 60, 100, 140, 180, 220);
    static int register = 1;
    static int cycle = 0;
    static int crtPos = 0;
    static StringBuilder crtImage = new StringBuilder();

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Path.of("src/main/resources/day10input"));
        List<Integer> strengths = new ArrayList<>();


        for (String line : lines) {

            if (line.contains("noop")) {
                draw();
                cycle++;
                if (points.contains(cycle)) {
                    strengths.add(register * cycle);
                }
            } else {
                for (int i = 0; i < 2; i++) {
                    draw();
                    cycle++;
                    if (points.contains(cycle)) {
                        strengths.add(register * cycle);
                    }
                }
                register += Integer.parseInt(line.split(" ")[1]);
            }
        }
        System.out.println(strengths);
        System.out.println(strengths.stream().mapToInt(i -> i).sum());
        System.out.println(crtImage);
    }

    private static void draw() {
        if (points.contains(cycle - 20)) {
            crtPos = 0;
            crtImage.append("\n");
        }

        if (crtPos == register || crtPos == register + 1 || crtPos == register - 1) {
            crtImage.append("#");
        } else {
            crtImage.append(" ");
        }
        System.out.println("register: " + register);
        System.out.println("crtPos: " + crtPos);
        crtPos++;
    }
}