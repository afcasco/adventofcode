package com.adventofcode.y2022.day07;

import java.nio.file.Path;

public class FSElement {

    private final int size;
    private final Path path;

    public long getSize() {
        return size;
    }

    public Path getPath() {
        return path;
    }

    public FSElement(String fileName, Path path) {
        if (Character.isDigit(fileName.charAt(0))) {
            this.size = Integer.parseInt(fileName.split(" ")[0]);
        } else {
            this.size = 0;
        }
        this.path = path;
    }
}