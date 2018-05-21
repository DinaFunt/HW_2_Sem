package com.company;

import java.util.Random;

public class Smart extends ComputerPlayer {
    private int PosX = 0;
    private int PosY = 0;
    private int Side = 0;
    private int Mark = 0;
    private Random rnd = new Random(System.currentTimeMillis());

    private void AroundShip(int X1, int X2, int Y1, int Y2) {
        int i;
        int j;
        if (X1 > X2) {
            int C;
            C = X1;
            X1 = X2;
            X2 = C;
        }

        if (Y1 > Y2) {
            int C;
            C = Y1;
            Y1 = Y2;
            Y2 = C;
        }

        for (i = X1 - 1; i <= X2 + 1; i++) {
            for (j = Y1; j <= Y2; j++) {
                if (i < SIZE_OF_FIELD && i >=0 && j < SIZE_OF_FIELD && j >=0 && OpponentField[i][j] != Killed) {
                    OpponentField[i][j] = Sea;
                }
            }
        }
    }

    @Override
    public void NextStep() {

        if (Flag == 1) {

            if (Mark == 0) {
                PosX = X;
                PosY = Y;
            }
            else {
                X = PosX;
                Y = PosY;
            }

            switch (Side) {
                case 0:
                    if (PosY + 1 < SIZE_OF_FIELD && OpponentField[X][PosY + 1] == Empty) {
                        Y = PosY + 1;
                        Mark++;
                        break;
                    }
                    else {
                        Side++;
                    }
                case 1:
                    if (PosX + 1 < SIZE_OF_FIELD && OpponentField[PosX + 1][Y] == Empty) {
                        X = PosX + 1;
                        Mark++;
                        break;
                    }
                    else {
                        Side++;
                    }
                case 2:
                    if (PosY - 1 >= 0 && OpponentField[X][PosY - 1] == Empty) {
                        Y = PosY - 1;
                        Mark++;
                        break;
                    }
                    else {
                        Side++;
                    }
                case 3:
                    if (PosX - 1 >= 0 && OpponentField[PosX - 1][Y] == Empty) {
                        X = PosX - 1;
                        Mark++;
                        break;
                    }
                    else {
                        Flag = 0;
                        Side = 0;
                        Mark = 0;
                        AroundShip(X, PosX, Y, PosY);
                        do {
                            X = rnd.nextInt(10);
                            Y = rnd.nextInt(10);
                        }
                        while (OpponentField[X][Y] != Empty);
                    }
            }
        }
        else if (Flag > 1 && OpponentField[X][Y] == Killed) {

            switch (Side) {
                case 0:
                    if (Y + 1 < SIZE_OF_FIELD && OpponentField[X][Y + 1] == Empty) {
                        Y++;
                        break;
                    }
                    else if (PosY - 1 >= 0 && OpponentField[X][PosY - 1] == Empty) {
                        int C;
                        C = PosY;
                        PosY = Y;
                        Y = C - 1;
                        Side = 2;
                        break;
                    }
                    else {
                        AroundShip(X, PosX, Y, PosY);
                        do {
                            X = rnd.nextInt(10);
                            Y = rnd.nextInt(10);
                        }
                        while (OpponentField[X][Y] != Empty);
                        Flag = 0;
                        Mark = 0;
                        Side = 0;
                        break;

                    }
                case 1:
                    if (X + 1 < SIZE_OF_FIELD && OpponentField[X + 1][Y] == Empty) {
                        X++;
                        break;
                    }
                    else if (PosX - 1 >= 0 && OpponentField[PosX - 1][Y] == Empty) {
                        int C;
                        C = PosX;
                        PosX = X;
                        X = C - 1;
                        Side = 3;
                        break;
                    }
                    else {
                        AroundShip(X, PosX, Y, PosY);
                        do {
                            X = rnd.nextInt(10);
                            Y = rnd.nextInt(10);
                        }
                        while (OpponentField[X][Y] != Empty);
                        Flag = 0;
                        Mark = 0;
                        Side = 0;
                        break;

                    }
                case 2:
                    if (Y - 1 >= 0 && OpponentField[X][Y - 1] == Empty) {
                        Y--;
                        break;
                    }
                    else {
                        AroundShip(X, PosX, Y, PosY);
                        do {
                            X = rnd.nextInt(10);
                            Y = rnd.nextInt(10);
                        }
                        while (OpponentField[X][Y] != Empty);
                        Flag = 0;
                        Mark = 0;
                        Side = 0;
                        break;
                    }
                case 3:
                    if (X - 1 >= 0 && OpponentField[X - 1][Y] == Empty) {
                        X--;
                        break;
                    }
                    else {
                        AroundShip(X, PosX, Y, PosY);
                        do {
                            X = rnd.nextInt(10);
                            Y = rnd.nextInt(10);
                        }
                        while (OpponentField[X][Y] != Empty);
                        Flag = 0;
                        Mark = 0;
                        Side = 0;
                        break;
                    }
            }
        }
        else if (Flag > 1 && OpponentField[X][Y] != Killed) {
            switch (Side) {
                case 0:
                    if (PosY - 1 >= 0 && OpponentField[X][PosY - 1] == Empty) {
                        int C;
                        C = PosY;
                        PosY = Y;
                        Y = C - 1;
                        Side = 2;
                        break;
                    }
                    else {
                        AroundShip(X, PosX, Y, PosY);
                        do {
                            X = rnd.nextInt(10);
                            Y = rnd.nextInt(10);
                        }
                        while (OpponentField[X][Y] != Empty);
                        Flag = 0;
                        Mark = 0;
                        Side = 0;
                        break;

                    }
                case 1:
                    if (PosX - 1 >= 0 && OpponentField[PosX - 1][Y] == Empty) {
                        int C;
                        C = PosX;
                        PosX = X;
                        X = C - 1;
                        Side = 3;
                        break;
                    }
                    else {
                        AroundShip(X, PosX, Y, PosY);
                        do {
                            X = rnd.nextInt(10);
                            Y = rnd.nextInt(10);
                        }
                        while (OpponentField[X][Y] != Empty);
                        Flag = 0;
                        Mark = 0;
                        Side = 0;
                        break;

                    }
                case 2:
                    AroundShip(X, PosX, Y, PosY);
                    do {
                        X = rnd.nextInt(10);
                        Y = rnd.nextInt(10);
                    }
                    while (OpponentField[X][Y] != Empty);
                    Flag = 0;
                    Mark = 0;
                    Side = 0;
                    break;
                case 3:
                    AroundShip(X, PosX, Y, PosY);
                    do {
                        X = rnd.nextInt(10);
                        Y = rnd.nextInt(10);
                    }
                    while (OpponentField[X][Y] != Empty);
                    Flag = 0;
                    Mark = 0;
                    Side = 0;
                    break;
            }
        }
        else {
            do {
                X = rnd.nextInt(10);
                Y = rnd.nextInt(10);
            }
            while (OpponentField[X][Y] != Empty);
        }

    }
}