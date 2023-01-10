package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PigLatinTranslator {

    public String translate(String input) {
        List<String> words = Arrays.asList(input.split(" "));
        ArrayList<String> outputWords = new ArrayList<>();
        for (String word : words) {
            String startWord = word;
            word = rule1Transformation(word);
            if (wordIsChanged(startWord, word)) {
                outputWords.add(word);
                continue;
            }
            word = rule3Transformation(word);
            if (wordIsChanged(startWord, word)) {
                outputWords.add(word);
                continue;
            }
            word = rule2Transformation(word);
            if (wordIsChanged(startWord, word)) {
                outputWords.add(word);
                continue;
            }
            word = rule4Transformation(word);
            if (wordIsChanged(startWord, word)) {
                outputWords.add(word);
                continue;
            }
            outputWords.add(word);
        }
        return String.join(" ", outputWords);
    }

    boolean wordIsChanged(String startName, String name) {
        return !startName.equals(name);
    }

    public String rule1Transformation(String word) {
        String firstTwoChars = "";
        if (word.length() > 2) {
            firstTwoChars = word.substring(0, 2);
            if (firstTwoChars.equals("xr") || firstTwoChars.equals("yt") || startsWithVowel(word)) {
                return word.concat("ay");
            }
        }
        return word;
    }

    public boolean startsWithVowel(String word) {
        List<String> vowels = Arrays.asList("a", "e", "i", "o", "u");
        for (String vowel : vowels) {
            if (word.startsWith(vowel)) return true;
        }
        return false;
    }

    public String rule2Transformation(String word) {
        List beginingConsonantSounds = Arrays.asList("ch", "qu", "b", "m", "r", "s", "t", "g", "n", "p", "c", "h", "f", "d", "l", "k", "j", "w", "y", "z", "v", "x", "q");
        if (word.length() > 1 && !word.substring(1).contains("y")) {
            for (int i = 0; i < beginingConsonantSounds.size(); i++) {
                if (word.startsWith(beginingConsonantSounds.get(i).toString())) {
                        word = word.substring(beginingConsonantSounds.get(i).toString().length());
                    return word.concat(beginingConsonantSounds.get(i).toString() + "ay");
                }
            }
        }
        return word;
    }

    public String rule3Transformation(String word) {
        List beginingConsonantSounds = Arrays.asList("ch", "qu", "b", "m", "r", "s", "t", "g", "n", "p", "c", "h", "f", "d", "l", "k", "j", "w", "y", "z", "v", "x", "q");
        if (word.length() > 1 && !word.contains("y")) {
            for (int i = 0; i < beginingConsonantSounds.size(); i++) {
                if (word.startsWith(beginingConsonantSounds.get(i).toString().concat("qu"))) {
                        word = word.substring(beginingConsonantSounds.get(i).toString().length()+2);
                    return word.concat(beginingConsonantSounds.get(i).toString() + "qu" + "ay");
                }
            }
        }
        return word;
    }

    public String rule4Transformation(String word) {
        List beginingConsonantSounds = Arrays.asList("ch", "qu", "b", "m", "r", "s", "t", "g", "n", "p", "c", "h", "f", "d", "l", "k", "j", "w", "y", "z", "v", "x", "q");
        if (word.length() > 2) {
            for (int i = 0; i < beginingConsonantSounds.size(); i++) {
                if (word.startsWith(beginingConsonantSounds.get(i).toString())) {
                    if (word.contains("y")) {
                        return word.substring(word.indexOf("y")) + word.substring(0, word.indexOf("y")) + "ay";
                    }
                }
            }
        }

        if (word.length() == 2 && word.endsWith("y")) {
            return "y" + word.substring(0, 1) + "ay";
        }

        return word;
    }
}
