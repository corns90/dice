package com.example.dice.judge;

import java.util.ArrayList;
import java.util.List;

import com.example.dice.player.DicePlayer;
import com.example.dice.player.FraudDicePlayer;
import com.example.dice.recorder.Recoder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class Judge {
    private static final int MAXIMUM_NUMBER_OF_PLAYERS = 2;
    private static final List<DicePlayer> PLAYER_LIST = new ArrayList<>();

    private final Recoder recoder;

    public void register(DicePlayer player) {
        if (PLAYER_LIST.size() >= MAXIMUM_NUMBER_OF_PLAYERS) {
            throw new RuntimeException("풀방 입니다. 참석이 불가능 합니다.");
        }
        log.info("{}님이 게임에 참석하였습니다.", player.getName());
        if (player instanceof FraudDicePlayer) {
            for (DicePlayer registeredPlayer : PLAYER_LIST) {
                ((FraudDicePlayer) player).observeTheOtherPlayer(registeredPlayer);
            }
        }
        PLAYER_LIST.add(player);
    }

    public void startTheGame(int numberOfGames) {
        log.info("----- 게임을 시작합니다. -----");

        for (int i = 1; i <= numberOfGames; i ++) {
            for (DicePlayer dicePlayer : PLAYER_LIST) {
                int score = dicePlayer.roll();
                dicePlayer.addScore(score);
            }
            recoder.recode(PLAYER_LIST);
        }
        log.info("----- 게임이 끝났습니다. -----");

        log.info("승자는 {} 입니다.", judge().getName());
    }

    public DicePlayer judge() {
        DicePlayer winner = null;
        for (DicePlayer player : PLAYER_LIST) {
            if (winner == null || winner.getScore() < player.getScore()) {
                winner = player;
            }
        }
        return winner;
    }

    public int getMaximumNumberOfPlayers() {
        return MAXIMUM_NUMBER_OF_PLAYERS;
    }

}
