package org.example;

public class IsbnVerifier {
    boolean isValid(String stringToVerify) {
        if (stringToVerify.isBlank() || stringToVerify.isEmpty())
            return false;

        stringToVerify = stringToVerify.replace("-", "");

        if (stringToVerify.length() != 10) {
            return false;
        }

        int multiplier = 10;
        int sum = 0;

        for (char ch : stringToVerify.toCharArray()) {
            if(ch != 'X') {
                sum = sum +  Character.getNumericValue(ch) * multiplier;
            }
            if(ch == 'X' && multiplier == 1){
                sum = sum + (10 * multiplier);
            }
            if(!Character.isDigit(ch) && ch != 'X' && multiplier == 1){
                sum = sum + (10 * multiplier);
            }
            multiplier--;
        }
        return sum % 11 == 0;
    }

//    boolean isValid(String stringToVerify) {
//
//        //remove any hyphens
//        stringToVerify = stringToVerify.replaceAll("-", "");
//
////must be a 10 digit stringToVerify
//        if (stringToVerify.length() != 10) {
//            return false;
//        }
//
//        try {
//            int total = 0;
//            for (int i = 0; i < 9; i++) {
//                int digit = Integer.parseInt(stringToVerify.substring(i, i + 1));
//                total += ((10 - i) * digit);
//            }
//
//            String checksum = Integer.toString((11 - (total % 11)) % 11);
//            if ("10".equals(checksum)) {
//                checksum = "X";
//            }
//
//            return checksum.equals(stringToVerify.substring(9));
//        } catch (
//                NumberFormatException nfe) {
//            //to catch invalid stringToVerifys that contain non-numeric characters
//            return false;
//        }
//    }
    
    public static void main(String[] args) {
         IsbnVerifier isbnVerifier = new IsbnVerifier();
        System.out.println(isbnVerifier.isValid("359821507X"));
    }
}
