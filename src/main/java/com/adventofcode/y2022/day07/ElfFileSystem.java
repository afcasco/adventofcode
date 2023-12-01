package com.adventofcode.y2022.day07;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.*;

public class ElfFileSystem {

    private final List<FSElement> elements;
    private Path currentPath;

    public ElfFileSystem(List<String> data) {
        currentPath = Path.of(File.separator);
        elements = new ArrayList<>();
        for (String line : data) {
            if (line.startsWith("$ cd")) {
                setPath(line.split(" ")[2]);
            } else if (!line.startsWith("$ ls")) {
                elements.add(new FSElement(line, currentPath));
            }
        }
    }

    private void setPath(String goTo) {
        if (goTo.equals("..")) {
            currentPath = currentPath.getParent();
        } else if (goTo.equals("/")) {
            currentPath = Path.of(File.separator);
        } else {
            currentPath = Path.of(currentPath.toString() + File.separator + goTo);
        }
    }

    public int getPathContentSize(Path path) {
        return elements.stream()
                .filter(element->element.getPath().startsWith(path))
                .mapToInt(FSElement::getSize).sum();
    }

    public Set<Path> getFolders() {
        return elements.stream().map(FSElement::getPath).collect(toSet());
    }
}