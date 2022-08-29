package com.example.dice.player;

import com.example.dice.dice.Dice;
import com.example.dice.dice.FraudDice;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FraudDicePlayer extends DicePlayer {
    @Getter
    private final FraudDice dice;
    private DicePlayer otherPlayer;

    public FraudDicePlayer(String name, Dice dice) {
        super(name);
        this.dice = (FraudDice) dice;
    }

    public void observeTheOtherPlayer(DicePlayer otherPlayer) {
        this.otherPlayer = otherPlayer;
    }

    @Override
    public int roll() {
        if (otherPlayer != null) {
            log.info("{}의 점수를 염탐합니다.", otherPlayer.getName());
            changeOfAttitude(otherPlayer.getScore());
        }
        return this.dice.roll();
    }

    private void changeOfAttitude(int otherPlayerScore) {
        if (this.score - otherPlayerScore >= 6) {
            this.dice.setMode(FraudDice.Mode.WEAKNESS);
        } else if (this.score - otherPlayerScore < 0) {
            this.dice.setMode(FraudDice.Mode.STRONG);
        } else {
            this.dice.setMode(FraudDice.Mode.NORMAL);
        }
    }
}
