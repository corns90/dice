package com.example.dice.recorder;

import java.util.List;

import com.example.dice.dice.FraudDice;
import com.example.dice.player.DicePlayer;
import com.example.dice.player.FraudDicePlayer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Recoder {
    public void recode(List<DicePlayer> playerList) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (DicePlayer player : playerList) {
            sb.append(player.getName());
            sb.append(" : ");
            sb.append(player.getScore());
            sb.append(" ");
            if (player instanceof FraudDicePlayer) {
                FraudDice fraudDice = ((FraudDicePlayer)player).getDice();
                sb.append(String.format("[%s]", fraudDice.getMode()));
            }
        }
        sb.append("]");

        System.out.println(sb);
    }
}
