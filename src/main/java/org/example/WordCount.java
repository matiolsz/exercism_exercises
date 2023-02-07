package org.example;

import java.util.HashMap;
import java.util.Map;

public class WordCount {
    public Map<String, Integer> phrase(String input) {
        Map<String, Integer> map = new HashMap<>();
        String[] inputWords = input.split("[\\n\\r\\s,!.:]+");
        for (int i = 0; i < inputWords.length; i++) {
            inputWords[i] = inputWords[i].toLowerCase();
        }
        for (String word : inputWords) {
            word = deleteApostrophesWhenExists(word);
            if ((isItWord(word) || isItNumber(word) || isItWordWithApostrophe(word)) && word.length() > 0) {
                if (map.containsKey(word)) {
                    map.replace(word, map.get(word) + 1);
                } else {
                    map.put(word, 1);
                }
            }
        }
        return map;
    }

    public boolean isItNumber(String word) {
        for (char ch : word.toCharArray()) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }

    private String deleteApostrophesWhenExists(String word) {
        if (word.startsWith("'")) {
            word = word.substring(1);
        }
        if (word.endsWith("'")) {
            word = word.substring(0, word.length() - 1);
        }
        return word;
    }

    public boolean isItWord(String word) {

        for (char ch : word.toUpperCase().toCharArray()) {
            if ((int) ch < 65 || (int) ch > 90) {
                return false;
            }
        }
        return true;
    }

    public boolean isItWordWithApostrophe(String word) {
        int apostropheCounter = 0;
        for (char ch : word.toCharArray()) {
            if ((int) ch == 39) {
                apostropheCounter++;
            }
        }
        if (apostropheCounter == 1) {
            for (String s : word.split("'")) {
                if (!isItWord(s)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
