package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Anagram {

    String word;
    Map<Character, Integer> lettersOfWord;

    public Anagram(String word){
        this.word = word;
        this.lettersOfWord = makeMapOfLetters(word);
    }

    public Anagram(){

    }

    Map<Character, Integer> makeMapOfLetters(String word){
        if(!word.matches("[a-zA-Z ]+")) throw new IllegalArgumentException("string contains characters different than" +
                "letters");
        if(word.isEmpty()) throw new IllegalArgumentException("string is empty");

        return word.chars()
                  .filter(Character::isLetter)
                  .map(Character::toLowerCase)
                  .boxed()
                  .collect(Collectors.toMap(
                          c -> (char) c.intValue(),
                          c -> 1,
                          Integer::sum
                  ));
    }

    ArrayList<String> match(List<String> list){
        ArrayList<String> anagrams = new ArrayList<>();
        for(String wordFromList: list){
            if(makeMapOfLetters(wordFromList).equals(this.lettersOfWord)){
                if(!this.word.equalsIgnoreCase(wordFromList)) {
                    anagrams.add(wordFromList);
                }
            }
        }
        return anagrams;
    }

}
