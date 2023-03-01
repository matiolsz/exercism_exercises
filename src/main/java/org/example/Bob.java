package org.example;

import java.util.Scanner;

public class Bob {

    public String hey(String string) {

        System.out.print("You: ");
        String input = string;

        if (input.endsWith("?")) { // if the input ends with a question mark
            return "Bob: Sure.";
        } else if (input.equals("")) { // if the input is empty or only contains whitespace
            return "Bob: Fine. Be that way!";
        } else if (input.toUpperCase().equals(input) && input.matches(".*[A-Z].*")) { // if the input is all uppercase and contains at least one letter
            if (input.endsWith("?")) { // if the input is a yelled question
                return "Bob: Calm down, I know what I'm doing!";
            } else { // if the input is just yelled
                return "Bob: Whoa, chill out!";
            }
        } else { // anything else
            return "Bob: Whatever.";
        }

    }
}

