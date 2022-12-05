package com.adventofcode.y2022.day05;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Crate {
    private final List<String> content;

    public Crate() {
        this.content = new ArrayList<>();
    }

    public List<String> removeElements(int num) {
        List<String> removed = new ArrayList<>();
        IntStream.range(0, num).forEach(i -> {
            removed.add(content.get(content.size() - 1));
            content.remove(content.size() - 1);
        });
        return removed;
    }

    public void addElements(List<String> elements) {
        content.addAll(elements);
    }

    public void addElements9001(List<String> elements){
        for(int i=elements.size()-1;i>=0;i--){
            content.add(elements.get(i));
        }
    }

    public void addElement(String element) {
        content.add(element);
    }

    public String getTopElement() {
        return content.get(content.size() - 1);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (String element : content) {
            builder.append(element).append(",");
        }
        return builder.toString();
    }
}