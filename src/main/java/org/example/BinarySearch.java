package org.example;

import java.util.List;

public class BinarySearch {

    List<Integer> list;
    public BinarySearch(List<Integer> input){
        this.list = input;
    }

    public int indexOf(int numberWeLookFor) throws ValueNotFoundException {
        int leftBorder = 0;
        int rightBorder = list.size()-1;
        int middlePoint = 0;
        while(leftBorder <= rightBorder) {
            middlePoint = (int) Math.floor((rightBorder+leftBorder) / 2);
            if(list.get(middlePoint) == numberWeLookFor){
                return middlePoint;
            } else if (numberWeLookFor > list.get(middlePoint)) {
                leftBorder = middlePoint + 1;
            } else {
                rightBorder = middlePoint -1;
            }
            if(leftBorder == rightBorder){
                return leftBorder;
            }
        }
throw new ValueNotFoundException("Value not in array");
    }
}
