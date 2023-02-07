package org.example;


import java.util.HashSet;
import java.util.Set;

public class Robot {

    String name;

    static Set<String>  names = new HashSet<>();

    public Robot(){
        this.name = generateName();
    }

    public String getName() {
        return this.name;
    }

    public void reset(){
        String newName = generateName();
        if(!this.name.equals(newName)) {
            this.name = newName;
        }else{
            reset();
        }
    }

    private String generateName(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(generateLetter());
        stringBuilder.append(generateLetter());
        stringBuilder.append(generateNumber());
        stringBuilder.append(generateNumber());
        stringBuilder.append(generateNumber());
        if(names.contains(stringBuilder.toString())){
            return generateName();
        }
        names.add(stringBuilder.toString());
        return stringBuilder.toString();
    }


    //  65-90
    private char generateLetter(){

        // define the range
        int max = 90;
        int min = 65;
        int range = max - min + 1;

        int asciiNumberForLetter = (int)(Math.random() * range) + min;

        return (char)asciiNumberForLetter;
    }

    private int generateNumber(){

        // define the range
        int max = 9;
        int min = 0;
        int range = max - min + 1;

        // generate random numbers within 1 to 10
        int asciiNumberForLetter = (int)(Math.random() * range) + min;

        return asciiNumberForLetter;
    }

}
