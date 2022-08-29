package com.example.dice.dice;

import com.example.dice.util.RandomUtils;

public class GeneralDice implements Dice{
    @Override
    public int roll() {
        return RandomUtils.getRandomValue(6);
    }
}
