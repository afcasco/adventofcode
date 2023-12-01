package com.adventofcode.y2022.day08;

import com.adventofcode.utils.IOUtils;

import java.io.IOException;
import java.util.List;

// my answer 313200
public class Part2 {

    private static final int ROWS = 99;
    private static final int COLS = 99;
    private static final int[][] PATCH = new int[ROWS][COLS];

    public static void main(String[] args) throws IOException {
        // Get data into int array
        List<String> data = IOUtils.fileToLines("day08input");
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                PATCH[i][j] = data.get(i).charAt(j) - 48;
            }
        }

        // Check each position scenic score and keep the highest
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < PATCH.length; i++) {
            for (int j = 0; j < PATCH.length; j++) {
                int current = visibleFromTop(i, j) * visibleFromBottom(i, j)
                        * visibleFromLeft(i, j) * visibleFromRight(i, j);
                if (current > max) {
                    max = current;
                }
            }
        }
        System.out.println("max: " + max);
    }

    static int visibleFromTop(int row, int col) {
        boolean clear = true;
        int range = 0;
        int i = row - 1;
        while (i >= 0 && clear) {
            clear = PATCH[i][col] < PATCH[row][col];
            range++;
            i--;
        }
        return range;
    }

    static int visibleFromBottom(int row, int col) {
        boolean clear = true;
        int range = 0;
        int i = row + 1;
        while (i < PATCH.length && clear) {
            clear = PATCH[i][col] < PATCH[row][col];
            range++;
            i++;
        }
        return range;
    }

    static int visibleFromLeft(int row, int col) {
        boolean clear = true;
        int range = 0;
        int i = col - 1;
        while (i >= 0 && clear) {
            clear = PATCH[row][i] < PATCH[row][col];
            range++;
            i--;
        }
        return range;
    }

    static int visibleFromRight(int row, int col) {
        boolean clear = true;
        int range = 0;
        int i = col + 1;
        while (i < PATCH.length && clear) {
            clear = PATCH[row][i] < PATCH[row][col];
            range++;
            i++;
        }
        return range;
    }
}