package com.adventofcode.y2022.day08;

import com.adventofcode.utils.IOUtils;

import java.io.IOException;
import java.util.List;


public class Part1 {

    public static void main(String[] args) throws IOException {
        List<String> data = IOUtils.fileToLines("day08input");
        int visibleTrees = 0;
        int[][] patch = new int[99][99];
        for (int i = 0; i < 99; i++) {
            for (int j = 0; j < 99; j++) {
                patch[i][j] = data.get(i).charAt(j) - 48;
            }
        }

        for (int i = 0; i < 99; i++) {
            for (int j = 0; j < 99; j++) {
                if (visibleFromLeft(i, j, patch) || visibleFromRight(i, j, patch)
                        || visibleFromTop(i, j, patch) || visibleFromBottom(i, j, patch)) {
                    visibleTrees++;
                }
            }
        }

        System.out.println("Elfvisibilitymeter counted " + visibleTrees + " visible trees on this patch");
    }

    static boolean visibleFromTop(int row, int col, int[][] patch) {
        boolean clear = true;
        int i = row - 1;
        while (i >= 0 && clear) {
            clear = patch[i][col] < patch[row][col];
            i--;
        }
        return clear;
    }

    static boolean visibleFromBottom(int row, int col, int[][] patch) {
        boolean clear = true;
        int i = row + 1;
        while (i < patch.length && clear) {
            clear = patch[i][col] < patch[row][col];
            i++;
        }
        return clear;
    }

    static boolean visibleFromLeft(int row, int col, int[][] patch) {
        boolean clear = true;
        int i = col - 1;
        while (i >= 0 && clear) {
            clear = patch[row][i] < patch[row][col];
            i--;
        }
        return clear;
    }

    static boolean visibleFromRight(int row, int col, int[][] patch) {
        boolean clear = true;
        int i = col + 1;
        while (i < patch.length && clear) {
            clear = patch[row][i] < patch[row][col];
            i++;
        }
        return clear;
    }
}