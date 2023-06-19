package org.example;

public class PhoneNumber {
    String phoneNumber;

    PhoneNumber(String phoneNumber) {
        if (phoneNumber.matches(".*[A-Za-z].*")) {
            throw new IllegalArgumentException("letters not permitted");
        }
        if (phoneNumber.matches(".*[@:!].*")) {
            throw new IllegalArgumentException("punctuations not permitted");
        }

        String cleanedUpString = phoneNumber.replaceAll("[^0-9]", "");
        cleanedUpString = cleanedUpString.replaceAll(" ", "");
        if (cleanedUpString.length() == 11 && cleanedUpString.charAt(0) == '1') {
            cleanedUpString = cleanedUpString.substring(1, 11);
        }

        if (cleanedUpString.length() > 11) {
            throw new IllegalArgumentException("more than 11 digits");
        }
        if (cleanedUpString.length() == 11 && cleanedUpString.charAt(1) == '0') {
            throw new IllegalArgumentException("area code cannot start with zero");
        }
        if (cleanedUpString.length() == 10 && cleanedUpString.charAt(3) == '0') {
            throw new IllegalArgumentException("exchange code cannot start with zero");
        }
        if (cleanedUpString.length() == 10 && cleanedUpString.charAt(3) == '1') {
            throw new IllegalArgumentException("exchange code cannot start with one");
        }
        if (cleanedUpString.charAt(0) == '1' && cleanedUpString.length() == 10) {
            throw new IllegalArgumentException("area code cannot start with one");
        }
        if (cleanedUpString.charAt(0) == '0' && cleanedUpString.length() == 10) {
            throw new IllegalArgumentException("area code cannot start with zero");
        }
        if (cleanedUpString.length() == 11 && cleanedUpString.charAt(0) != '1') {
            throw new IllegalArgumentException("11 digits must start with 1");
        }
        if (cleanedUpString.length() == 11 && cleanedUpString.charAt(0) == '1') {
            cleanedUpString = cleanedUpString.substring(1, 10);
        }
        if (cleanedUpString.length() == 10) {

            this.phoneNumber = cleanedUpString;
        } else {
            throw new IllegalArgumentException("incorrect number of digits");
        }
    }

    public String getNumber() {
        return phoneNumber;
    }
}
