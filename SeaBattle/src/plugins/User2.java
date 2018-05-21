package plugins;

import com.company.ComputerPlayer;
import java.util.Scanner;

public class User2 extends ComputerPlayer {
    private Scanner in = new Scanner(System.in);


    public void Print() {
        System.out.print("I'n working! Let's play with your friend\n");
    }

    void SetShips() {
        int X;
        int Y;
        int i;
        int SizeOfShip = 4;
        boolean Horizontal;
        int j;
        for (i = 1; i < 5; i++) {
            for (j = 1; j <= i; j++) {
                System.out.print("Size of ship = " + SizeOfShip + "\n");
                do {
                    System.out.print("Enter: X, Y coordinate of upper left cell " +
                            "and true in case of your ship is horizontal and false in other case\n");
                    X = in.nextInt();
                    Y = in.nextInt();
                    Horizontal = in.nextBoolean();
                }
                while (!CanSetShip(X, Y, SizeOfShip, Horizontal));
                SetShip(X, Y, SizeOfShip, Horizontal);
                Show();
            }
            SizeOfShip--;
        }
    }

    public void NextStep() {
        ShowOpponent();
        X = in.nextInt();
        Y = in.nextInt();
    }

    private void Show() {
        int i;
        int j;
        for (i = 0; i < SIZE_OF_FIELD; i++) {
            for (j = 0; j < SIZE_OF_FIELD; j++) {
                switch (OwnField[i][j]) {
                    case Empty:
                        System.out.print("." + " ");
                        break;
                    case Deck:
                        System.out.print("O" + " ");
                        break;
                    case Killed:
                        System.out.print("X" + " ");
                        break;
                    case Sea:
                        System.out.print("*" + " ");
                        break;
                }
            }
            System.out.println();
        }
    }

    private void ShowOpponent() {
        int i;
        int j;
        for (i = 0; i < SIZE_OF_FIELD; i++) {
            for (j = 0; j < SIZE_OF_FIELD; j++) {
                switch (OwnField[i][j]) {
                    case Empty:
                        System.out.print("." + " ");
                        break;
                    case Deck:
                        System.out.print("O" + " ");
                        break;
                    case Killed:
                        System.out.print("X" + " ");
                        break;
                    case Sea:
                        System.out.print("*" + " ");
                        break;
                }
            }
            System.out.print("\t");
            for (j = 0; j < SIZE_OF_FIELD; j++) {
                switch (OpponentField[i][j]) {
                    case Empty:
                        System.out.print("." + " ");
                        break;
                    case Deck:
                        System.out.print("O" + " ");
                        break;
                    case Killed:
                        System.out.print("X" + " ");
                        break;
                    case Sea:
                        System.out.print("*" + " ");
                        break;
                }
            }
            System.out.println();
        }
    }
}
