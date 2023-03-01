package org.example;


import java.util.ArrayList;
import java.util.List;

public class ProteinTranslator {

    static String proteinFrom(String codon){
        switch (codon) {
            case "AUG": {
                return "Methionine";
            }
            case "UUU": case "UUC": {
                return "Phenylalanine";
            }
            case "UUA": case "UUG": {
                return "Leucine";
            }
            case "UCU": case "UCC": case "UCA": case "UCG":{
                return "Serine";
            }
            case "UAU": case "UAC": {
                return "Tyrosine";
            }
            case "UGU": case "UGC": {
                return "Cysteine";
            }
            case "UGG": {
                return "Tryptophan";
            }
            case "UAA": case "UAG": case "UGA":{
                return "STOP";
            }
            default:
                return "";

        }
    }

    public List<String> translate(String rnaSequence) {

        int chunkSize = 3;

        ArrayList<String> proteins = new ArrayList<>();

        for(int i = 0; i < rnaSequence.length() ; i+=chunkSize) {
            int endIndex = Math.min(i+chunkSize, rnaSequence.length());
            String currentChunk = rnaSequence.substring(i, endIndex);
            if(proteinFrom(currentChunk).equals("STOP")){
                break;
            }
            proteins.add(proteinFrom(currentChunk));
        }
        return proteins;
    }
}
