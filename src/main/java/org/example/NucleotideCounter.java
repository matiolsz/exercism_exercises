package org.example;

import java.util.HashMap;
import java.util.Map;

public class NucleotideCounter {

    public NucleotideCounter(String dna) throws IllegalArgumentException {
        this.dna = dna;
        this.map = nucleotideCounts();
    }

    ;

    private String dna;

    private Map<Character, Integer> map;

    public Map<Character, Integer> nucleotideCounts() throws IllegalArgumentException {
        HashMap<Character, Integer> nucleotides = new HashMap<>();
        if (dna.matches("[ACGT]+") || dna.length()==0) {
            nucleotides.put('A', countOccurrences(dna, 'A'));

            nucleotides.put('C', countOccurrences(dna, 'C'));

            nucleotides.put('G', countOccurrences(dna, 'G'));

            nucleotides.put('T', countOccurrences(dna, 'T'));

        } else {
            throw new IllegalArgumentException("contains not valid chars");
        }
        return nucleotides;
    }


    public Integer countOccurrences(String input, char character) {
        return Math.toIntExact(input.chars()
                .filter(ch -> ch == character)
                .count());
    }

}