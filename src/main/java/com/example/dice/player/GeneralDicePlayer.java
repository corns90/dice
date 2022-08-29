package com.example.dice.player;

import com.example.dice.dice.Dice;
import lombok.Getter;

@Getter
public class GeneralDicePlayer extends DicePlayer {
    private Dice dice;
    public GeneralDicePlayer(String name, Dice dice) {
        super(name);
        this.dice = dice;
    }

    @Override
    public int roll() {
        return this.dice.roll();
    }
}
