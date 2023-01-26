package org.example;

import java.util.Arrays;

public class RotationalCipher {

    int shiftKey;

    public RotationalCipher(int shiftKey) {
        this.shiftKey = shiftKey;
    }

    public String rotate(String data) {
        char[] oldWord = data.toCharArray();
        char[] newWord = new char[data.length()];
        int i = 0;
        for (char ch : oldWord) {
            if ((int) ch >= 97 && (int) ch <= 122) {
                newWord[i] = transformSmallLetter(ch, shiftKey);
            } else if ((int) ch >= 65 && (int) ch <= 90) {
                newWord[i] = transformBigLetter(ch, shiftKey);
            } else {
                newWord[i] = ch;

            }
            i++;
        }
        StringBuilder builder = new StringBuilder();
        for (char value : newWord) {
            builder.append(value);
        }

        return builder.toString();
    }

    //    97-122
    public char transformSmallLetter(char ch, int shiftKey) {
        int asciiNumber = ch + shiftKey;
        if (asciiNumber > 122) {
            return (char) (97 + asciiNumber - 122 - 1);
        } else {
            return (char) asciiNumber;
        }
    }

    //  65-90
    public char transformBigLetter(char ch, int shiftKey) {

        int asciiNumber = ch + shiftKey;
        if (asciiNumber > 90) {
            return (char) (65 + asciiNumber - 90 - 1);
        } else {
            return (char) asciiNumber;
        }
    }
}



