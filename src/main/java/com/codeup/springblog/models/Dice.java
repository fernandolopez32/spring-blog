package com.codeup.springblog.models;

public class Dice {
//    my model for this guessing game of dice
    final int sides = 6;
    public int roll(){
        return (int) (Math.random()*sides) +1;
    }
}
// MODEL