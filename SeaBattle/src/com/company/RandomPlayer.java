package com.company;

import java.util.Random;

public class RandomPlayer extends ComputerPlayer {
    private Random rnd = new Random(System.currentTimeMillis());

    @Override
    public void NextStep() {
        do {
            X = rnd.nextInt(10);
            Y = rnd.nextInt(10);
        }
        while (OpponentField[X][Y] != Empty);

    }
}
