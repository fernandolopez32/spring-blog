package com.codeup.springblog.models;

public class Dice {

    final int sides = 6;

    public int roll(){
        return (int) (Math.random()*sides) +1;
    }
}
