package com.example.dice.util;

import java.util.Random;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.NONE)
public class RandomUtils {
    private static final Random random = new Random();

    public static int getRandomValue(int max) {
        return random.nextInt(max) + 1;
    }

    public static int getRandomValue(int min, int max) {
        return (int)((Math.random() * (max - min + 1)) + min);
    }
}
