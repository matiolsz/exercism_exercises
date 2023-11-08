package org.example;

public class BottleSong {

    String recite(int startBottles, int takeDown) {
        StringBuilder stringBuilder = new StringBuilder();
        int counter = 0;
        for (int i = startBottles; i > 0; i--) {
            stringBuilder.append(oneLine(startBottles, i));
            counter++;
            if (counter == takeDown) {
                break;
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
//    TODO: zrob enum jako np: One = 1;
//    odliczanie od i = startBottles
//    counter od 0 idacy az do takedown. gdy counter == takeDown konczymy .

    String oneLine(int startBottle, int currentBottle) {
        if (currentBottle == 1) {
            return "One green bottle hanging on the wall,\n" +
                    "One green bottle hanging on the wall,\n" +
                    "And if one green bottle should accidentally fall,\n" +
                    "There'll be no green bottles hanging on the wall.\n";
        }
        if (currentBottle == 2) {
            return "Two green bottle hanging on the wall,\n" +
                    "Two green bottle hanging on the wall,\n" +
                    "And if one green bottle should accidentally fall,\n" +
                    "There'll be one green bottle hanging on the wall.\n";

        } else
            return
                    changeNumberToString(currentBottle) + " green bottles hanging on the wall,\n" +
                            changeNumberToString(currentBottle) + " green bottles hanging on the wall,\n" +
                            "And if " + "one" + " green bottle should accidentally fall,\n" +
                            "There'll be " + changeNumberToString(currentBottle - 1).toLowerCase() + " green bottles hanging on the wall.\n";

    }

    private String changeNumberToString(int number) {
        switch (number) {
            case 1:
                return "One";
            case 2:
                return "Two";
            case 3:
                return "Three";
            case 4:
                return "Four";
            case 5:
                return "Five";
            case 6:
                return "Six";
            case 7:
                return "Seven";
            case 8:
                return "Eight";
            case 9:
                return "Nine";
            case 10:
                return "Ten";
            default:
                return "baaals";
        }
    }

    //    Ten green bottles hanging on the wall,
//    Ten green bottles hanging on the wall,
//    And if one green bottle should accidentally fall,
//    There'll be nine green bottles hanging on the wall.
    public static void main(String[] args) {
        BottleSong bottleSong = new BottleSong();
        System.out.println(bottleSong.recite(10, 2));
    }
}
