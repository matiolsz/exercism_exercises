package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class AnagramTest {


    @Test
    public void mapCreatedIsValid(){
        Anagram anagram = new Anagram();
        Map<Character, Integer> expectedLetters = new HashMap<>();
        Map<Character, Integer> actualLetters = new HashMap<>();

        String word = "anagram";

        expectedLetters.put('a', 3);
        expectedLetters.put('n', 1);
        expectedLetters.put('g', 1);
        expectedLetters.put('r', 1);
        expectedLetters.put('m', 1);

        actualLetters = anagram.makeMapOfLetters(word);

        Assert.assertEquals(expectedLetters, actualLetters);
    }

    @Test
    public void selectValidAnagram(){
        Anagram anagram = new Anagram("nanba");
        String bananAnagram = "nanba";

        ArrayList<String> words = new ArrayList<>(List.of(new String[] {"deszcz", "slonce", "banan"}));


        ArrayList<String> expectedBananAnagram = anagram.match(words);
        ArrayList<String> actualBananAnagram = new ArrayList<>(List.of(new String[] {"banan"}));

        Assert.assertEquals(expectedBananAnagram, actualBananAnagram);

    }

    @Test
    public void testIdenticalWordRepeatedIsNotAnagram() {
        Anagram detector = new Anagram("go");
        Assert.assertTrue((detector.match(Collections.singletonList("go Go GO"))).isEmpty());
    }

}
