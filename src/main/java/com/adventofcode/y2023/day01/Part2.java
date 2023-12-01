package com.adventofcode.y2023.day01;

import com.adventofcode.utils.IOUtils;

import java.io.IOException;
import java.util.function.Function;

public class Part2 {
    public static void main(String[] args) throws IOException {


        Function<String, String> elfCalibrationParser = line -> {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < line.length(); i++) {
                if (Character.isDigit(line.charAt(i))) {
                    builder.append(line.charAt(i));
                }
                if (line.indexOf("zero") == i || line.lastIndexOf("zero") == i) {
                    builder.append("0");
                }
                if (line.indexOf("one") == i || line.lastIndexOf("one") == i) {
                    builder.append("1");
                }
                if (line.indexOf("two") == i || line.lastIndexOf("two") == i) {
                    builder.append("2");
                }
                if (line.indexOf("three") == i || line.lastIndexOf("three") == i) {
                    builder.append("3");
                }
                if (line.indexOf("four") == i || line.lastIndexOf("four") == i) {
                    builder.append("4");
                }
                if (line.indexOf("five") == i || line.lastIndexOf("five") == i) {
                    builder.append("5");
                }
                if (line.indexOf("six") == i || line.lastIndexOf("six") == i) {
                    builder.append("6");
                }
                if (line.indexOf("seven") == i || line.lastIndexOf("seven") == i) {
                    builder.append("7");
                }
                if (line.indexOf("eight") == i || line.lastIndexOf("eight") == i) {
                    builder.append("8");
                }
                if (line.indexOf("nine") == i || line.lastIndexOf("nine") == i) {
                    builder.append("9");
                }
            }
            return builder.toString();
        };

        long sum = IOUtils.fileToLines("2023/day01input").stream()
                .map(elfCalibrationParser)
                .map(line -> line.substring(0, 1).concat(line.substring(line.length() - 1)))
                .mapToInt(Integer::parseInt)
                .sum();

        System.out.println(sum);
    }
}