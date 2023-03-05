package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class LargestSeriesProductCalculator {

    String string;

    LargestSeriesProductCalculator(String inputNumber) {
        if ( inputNumber.length()>0 &&!inputNumber.matches("[0-9]+")){
            throw new IllegalArgumentException("String to search may only contain digits.", new IllegalArgumentException());
        }
        this.string = inputNumber;
    }

    long calculateLargestProductForSeriesLength(int numberOfDigits) {

        if(numberOfDigits == 0){
            return 1;
        }
        if(numberOfDigits > this.string.length()){
            throw new IllegalArgumentException("Series length must be less than or equal to the length of the string to search.", new IllegalArgumentException());
        }
        if(numberOfDigits < 0){
            throw new IllegalArgumentException("Series length must be non-negative.", new IllegalArgumentException());
        }

        char[] chars = string.toCharArray();
        long max = 0;
        Long multipliedVal = 1L;
        ArrayList<Long> fewElements = new ArrayList<Long>();
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < numberOfDigits; j++) {
                if(i + numberOfDigits > chars.length){
                    continue;
                }
                fewElements.add(Long.parseLong(String.valueOf(chars[i+j])));
            }
            for( Long l : fewElements){
                multipliedVal *= l ;
            }
            if( multipliedVal>max && multipliedVal!=1L ){
                max = multipliedVal;
            }
            fewElements.clear();
            multipliedVal = 1L;
        }
        return max;
    }
}
