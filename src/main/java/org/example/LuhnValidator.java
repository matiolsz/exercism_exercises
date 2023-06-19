package org.example;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
//import org.apache.commons.lang3.StringUtils;

public class LuhnValidator {

    boolean isValid(String candidate) {

        candidate = candidate.replace(" ", "");

        if (candidate.isEmpty() || !numberIsOnlyDigits(candidate)) {
            return false;
        }

            if(candidate.charAt(0)=='0' && candidate.length() == 1){
            return false;
        }

        char[] numbers = candidate.toCharArray();

        char[] newNumbers = new char[numbers.length];

        int counter = 0;

        int customCounter = 0;
        if (numbers.length % 2 != 0) {
            customCounter = 1;
        }

        for (char number : numbers) {
            if (customCounter % 2 == 0) {
                newNumbers[counter] = Integer.toString(doubleAndSubtractIfNecessary(Integer.parseInt(String.valueOf(number)))).charAt(0);
            } else {
                newNumbers[counter] = number;
            }
            counter++;
            customCounter++;
        }

        int sum = new String(newNumbers)
                .chars()
                .map(Character::getNumericValue)
                .sum();

        return sum % 10 == 0;
    }

    private int doubleAndSubtractIfNecessary(int number) {
        if (number * 2 > 9) {
            return number * 2 - 9;
        } else {
            return number * 2;
        }
    }

    private boolean numberIsOnlyDigits(String number) {
        return number
                .chars()
                .allMatch(Character::isDigit);
    }
}
