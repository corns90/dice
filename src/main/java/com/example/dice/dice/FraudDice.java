package com.example.dice.dice;

import com.example.dice.util.RandomUtils;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FraudDice implements Dice {
    @Getter
    private Mode mode = Mode.NORMAL;

    @Override
    public int roll() {
        Range numberOfDiceRange = this.mode.getRange();
        return RandomUtils.getRandomValue(numberOfDiceRange.getMin(), numberOfDiceRange.getMax());
    }

    public void setMode(Mode mode) {
        log.info("사기주사위의 모드가 {}로 변경되었습니다. ", mode);
        this.mode = mode;
    }

    @Getter
    @RequiredArgsConstructor
    public enum Mode {
        STRONG(new Range(5, 6)), NORMAL(new Range(1, 6)), WEAKNESS(new Range(1, 2));

        private final Range range;
    }

    @Getter
    @RequiredArgsConstructor
    private static class Range {
        private final int min;
        private final int max;
    }
}
