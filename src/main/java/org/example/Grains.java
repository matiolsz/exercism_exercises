package org.example;

import java.math.BigInteger;

public class Grains {

    public Grains() {
        createBoard();
    }
    BigInteger[] grainsOnSquare = new BigInteger[64];

    void createBoard() {
        BigInteger number = BigInteger.ONE;
        for(int i = 0 ; i < 64 ; i++ ){
            grainsOnSquare[i] = number;
            number = number.add(number);
        }
    }

    void display10thElement(){
        System.out.println(grainsOnSquare[10]);
    }

    BigInteger grainsOnSquare(final int square) {
        if (square > 0 && square <= 64) {
            return grainsOnSquare[square - 1];
        }else {
            throw new IllegalArgumentException("square must be between 1 and 64");
        }
    }

    BigInteger grainsOnBoard() {
        BigInteger sum = BigInteger.ZERO;
        for(int i = 0 ; i < 64 ; i++ ){
            sum = sum.add(grainsOnSquare[i]);
        }
        return sum;
    }

//    public static void main(String[] args) {
//        Grains grains = new Grains();
//        grains.display10thElement();
//    }

}

