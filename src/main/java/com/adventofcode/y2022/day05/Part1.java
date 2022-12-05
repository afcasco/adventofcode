package com.adventofcode.y2022.day05;

import com.adventofcode.utils.IOUtils;

import java.io.IOException;

public class Part1 {

    public static String result(String inputFile) throws IOException {
        CrateContainer crateContainer = new CrateContainer();
        crateContainer.fillCrates(IOUtils.parseCrates(inputFile));
        IOUtils.parseMoves(inputFile).forEach(crateContainer::moveElements);
        StringBuilder builder = new StringBuilder();
        crateContainer.getAllCrates().stream().map(Crate::getTopElement).forEach(builder::append);
        return builder.toString();
    }
}