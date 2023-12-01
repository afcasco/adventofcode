package com.adventofcode.y2022.day05;

import com.adventofcode.utils.IOUtils;

import java.io.IOException;
import java.util.stream.Collectors;

public class Part2 {

    public static String result(String inputFile) throws IOException {
        CrateContainer crateContainer = new CrateContainer();
        crateContainer.fillCrates(IOUtils.parseCrates(inputFile));
        IOUtils.parseMoves(inputFile).forEach(crateContainer::moveWithCrate9001);
        return crateContainer.getAllCrates().stream().map(Crate::getTopElement).collect(Collectors.joining());
    }
}