package org.example;

import org.junit.Test;

import static org.junit.Assert.assertThrows;

public class NucleotideCounterTest {

    NucleotideCounter nucleotideCounter = new NucleotideCounter("GGG");

    @Test
    public void test() throws Exception {
        NucleotideCounter nucleotideCounter = new NucleotideCounter("GGG");
        System.out.println(nucleotideCounter.nucleotideCounts());
    }

    @Test
    public void testDnaStringHasInvalidNucleotides() {
        assertThrows(IllegalArgumentException.class, () -> new NucleotideCounter("AGXXACT"));
    }

}
