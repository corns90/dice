package com.example.dice.player;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public abstract class DicePlayer {
    protected String name;
    protected int score;

    public DicePlayer(String name) {
        log.info("{}가 생성되었습니다.", name);
        this.name = name;
        this.score = 0;
    }

    public void addScore(int score) {
        this.score += score;
    }

    public abstract int roll();

}
