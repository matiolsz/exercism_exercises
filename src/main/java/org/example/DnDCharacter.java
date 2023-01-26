package org.example;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DnDCharacter {

    private int s;
    private int d;
    private int c;
    private int i;
    private int w;
    private int ch;

    public DnDCharacter() {
        this.s = ability();
        this.d = ability();
        this.c = ability();
        this.i = ability();
        this.w = ability();
        this.ch = ability();
    }

    public int ability(){
        List fourRollDices = fourRollDices();
        Collections.sort(fourRollDices);
        return (int)fourRollDices.get(0) + (int)fourRollDices.get(1) + (int)fourRollDices.get(2) ;
    }

    public int generateDiceRoll(){
        return (int)(Math.random()*6+1);
    }

    public List fourRollDices() {
        ArrayList<Integer> diceRolls = new ArrayList<>();
       for( int i = 0 ; i < 4 ; i++ ) {
           diceRolls.add(generateDiceRoll());
       }
       return Arrays.asList(diceRolls.toArray());
    }

    public int modifier(int input) {
        return (int) Math.floor(((double) input-10.0)/2.0);
    }

    public int getStrength() {
        return this.s;
    }

    public int getDexterity() {
        return this.d;
    }

    public int getConstitution() {
        return this.c;
    }

    public int getIntelligence() {
        return this.i;
    }

    public int getWisdom() {
        return this.w;
    }

    public int getCharisma() {
        return this.ch;
    }

    public int getHitpoints() {
        return 10+modifier(this.c);
    }
}
