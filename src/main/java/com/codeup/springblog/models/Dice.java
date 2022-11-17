package com.codeup.springblog.models;

public class Dice {

    final int sides = 6;

//    private int number;

    public int roll(){
        return (int) (Math.random()*sides) +1;
    }
//
//    public int getNumber() {
//        return number;
//    }
//
//    public void setNumber(int number) {
//        this.number = number;
//    }
}
