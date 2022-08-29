package com.example.dice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.dice.dice.FraudDice;
import com.example.dice.dice.GeneralDice;
import com.example.dice.judge.Judge;
import com.example.dice.player.FraudDicePlayer;
import com.example.dice.player.GeneralDicePlayer;
import com.example.dice.recorder.Recoder;

public class Main {

    public static void main(String[] args) {
        Judge judge = new Judge(new Recoder());

        // Player 들과 Dice 간의 강결합이 존재하여 어쩔 수 없이 General / Fraud Player 로 형 변환을 할 수 밖에 없음
        GeneralDicePlayer generalDicePlayer = new GeneralDicePlayer("일반 사용자", new GeneralDice());
        FraudDicePlayer fraudDicePlayer = new FraudDicePlayer("현질 사용자", new FraudDice());

        judge.register(generalDicePlayer);
        judge.register(fraudDicePlayer);

        judge.startTheGame(5);
    }

}
