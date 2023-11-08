package org.example;

import java.util.Scanner;

public class Bob {

    public String hey(String string) {

        if (string.isBlank()) {
            throw new IllegalArgumentException("blank input");
        }
        if (string.endsWith("?")) {
            return "Sure.";
        }
        if (string.endsWith("?") && string.matches("[^a-z]+")) {
            return "Calm down, I know what I'm doing!";
        }
        if (string.matches("[^a-z]+")) {
            return "Whoa, chill out!";
        }
        if (string.contains("bob")) {
            return "Fine. Be that way!";
        } else {
            return "Whatever.";
        }
    }
}

