package org.example;

import java.util.HashMap;

public class ResistorColorDuo {

    HashMap<String, Integer> resColors;

    public ResistorColorDuo(){
        this.resColors = new HashMap<>();
        resColors.put("Black".toLowerCase(), 0);
        resColors.put("Brown".toLowerCase(), 1);
        resColors.put("Red".toLowerCase(), 2);
        resColors.put("Orange".toLowerCase(), 3);
        resColors.put("Yellow".toLowerCase(), 4);
        resColors.put("Green".toLowerCase(), 5);
        resColors.put("Blue".toLowerCase(), 6);
        resColors.put("Violet".toLowerCase(), 7);
        resColors.put("Grey".toLowerCase(), 8);
        resColors.put("White".toLowerCase(), 9);
    }

    public int value(String[] colors) {
        if(colors.length==1){
            return valueForColor(colors[0]);
        } else {
            return Integer.parseInt(valueForColor(colors[0]).toString() + valueForColor(colors[1]).toString());
        }
    }

    private Integer valueForColor(String color){
        return this.resColors.get(color);
    }

}
