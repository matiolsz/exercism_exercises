package org.example;

import java.util.ArrayList;
import java.util.List;

public class Flattener {

    ArrayList<Object> outputList = new ArrayList<>();

    public ArrayList<Object> flatten(List<Object> list){
        for(Object o: list){
            if (o instanceof List){
                outputList = flatten((List) o);
                continue;
            }
            if (o == (null)){
                continue;
            }
            outputList.add(o);
        }
        return outputList;
    }

}
