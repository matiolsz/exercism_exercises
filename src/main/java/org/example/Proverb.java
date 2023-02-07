package org.example;

//For want of a nail the shoe was lost.
//And all for the want of a nail.

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Proverb {

    private final String[] words;

    public Proverb(String[] words) {
        this.words = words;
    }

    public String recite() {
        return IntStream.range(0, words.length)
                .mapToObj(this::format)
                .collect(Collectors.joining("\n"));

    }

    private String format(int s) {
        return s != words.length - 1 ?
                "For want of a " + words[s] + " the " + words[s + 1] + " was lost."
                : "And all for the want of a " + words[0] + ".";
    }

}
