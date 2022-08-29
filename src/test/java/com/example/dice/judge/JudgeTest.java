package com.example.dice.judge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.dice.dice.GeneralDice;
import com.example.dice.player.GeneralDicePlayer;
import com.example.dice.recorder.Recoder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class JudgeTest {

    @Test
    @DisplayName("최대 참석 가능 인원수가 넘으면 오류가 발생한다.")
    void registerOverflowTest() {
        // given
        Judge judge = new Judge(new Recoder());

        for (int i = 0; i < judge.getMaximumNumberOfPlayers(); i++) {
            judge.register(new GeneralDicePlayer("player" + i, new GeneralDice()));
        }

        // when & then
        Assertions.assertThrows(RuntimeException.class, () -> {
            judge.register(new GeneralDicePlayer("player_overflow", new GeneralDice()));
        });
    }
}
