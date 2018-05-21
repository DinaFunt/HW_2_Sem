package com.company;

import java.util.Random;

public class ComputerPlayer extends BasePlayer {
    int Flag = 0;
    private Random rnd = new Random(System.currentTimeMillis());

    public void NextStep() {}

    void SetShips() {
        int SizeOfShip = 4;
        boolean H;
        int X;
        int Y;
        int i; //количество кораблей
        int j;
        for (i = 1; i < 5; i++) {
            for (j = 1; j <= i; j++) {
                do {
                    H = rnd.nextBoolean();
                    if (H) {
                        X = rnd.nextInt(10);
                        Y = rnd.nextInt(10 - SizeOfShip + 1);
                    } else {
                        X = rnd.nextInt(10 - SizeOfShip + 1);
                        Y = rnd.nextInt(10);
                    }
                }
                while (!(CanSetShip(X, Y, SizeOfShip, H)));
                SetShip(X, Y, SizeOfShip, H);
            }
            SizeOfShip--;
        }
    }
}
