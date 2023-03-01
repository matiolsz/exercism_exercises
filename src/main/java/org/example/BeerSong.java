package org.example;

public class BeerSong {

    static String[] songWords = new String[]{" bottles of beer on the wall, ",
            " bottles of beer.\nTake one down and pass it around, ", " bottles of beer on the wall.\n\n"};

    static String[] songWordsWhenThereIsOneBottle = new String[]{" bottle of beer on the wall, ",
            " bottle of beer.\nTake it down and pass it around, ", "no more bottles of beer on the wall.\n\n"};

    static String lastLineWhenThereIsOneBottle = " bottle of beer on the wall.\n\n";
    static String[] songLastWords = new String[]{
            "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, ",
            "99 bottles of beer on the wall.\n\n"};

    public String sing(int numberOfBottles, int verseNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int currentVerse = 0; currentVerse < verseNumber; currentVerse++) {
            int numberOfBottlesInVerse = numberOfBottles - currentVerse ;
            if (numberOfBottlesInVerse == 1) {
                stringBuilder.append(numberOfBottlesInVerse);
                stringBuilder.append(songWordsWhenThereIsOneBottle[0]);
                stringBuilder.append(numberOfBottlesInVerse);
                stringBuilder.append(songWordsWhenThereIsOneBottle[1]);
                stringBuilder.append(songWordsWhenThereIsOneBottle[2]);
            }
            if (numberOfBottlesInVerse != 0 && numberOfBottlesInVerse != 1) {
                stringBuilder.append(numberOfBottlesInVerse);
                stringBuilder.append(songWords[0]);
                stringBuilder.append(numberOfBottlesInVerse);
                stringBuilder.append(songWords[1]);
                stringBuilder.append(numberOfBottlesInVerse - 1);
                if (numberOfBottlesInVerse - 1 != 1) {
                    stringBuilder.append(songWords[2]);
                } else {
                    stringBuilder.append(lastLineWhenThereIsOneBottle);
                }
            }
            if (numberOfBottlesInVerse == 0) {
                stringBuilder.append(songLastWords[0]);
                stringBuilder.append(songLastWords[1]);

            }
        }
        return stringBuilder.toString();
    }

    public String singSong() {
        StringBuilder stringBuilder = new StringBuilder();
         stringBuilder.append(sing(99, 99));
        stringBuilder.append(songLastWords[0]);
        stringBuilder.append(songLastWords[1]);
        return stringBuilder.toString();

    }

}
