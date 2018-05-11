import java.util.*;

public class User extends BasePlayer{
    private Scanner in = new Scanner(System.in);

    void GetShips() {
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
        X = in.nextInt();
        Y = in.nextInt();
    }

    private void Show() {
        int i;
        int j;
        for (i = 0; i < SIZE_OF_FIELD; i++) {
            for (j = 0; j < SIZE_OF_FIELD; j++) {
                if (OwnField[i][j] == 0) {
                    System.out.print("." + " ");
                }
                else {
                    if (OwnField[i][j] == 1) {
                        System.out.print("O" + " ");
                    }
                    else if (OwnField[i][j] == 2 ){
                        System.out.print("X" + " ");
                    }
                    else if (OwnField[i][j] == 3) {
                        System.out.print("*" + " ");
                    }

                }
            }
            System.out.println();
        }
    }

    void ShowOpponent() {
        int i;
        int j;
        for (i = 0; i < SIZE_OF_FIELD; i++) {
            for (j = 0; j < SIZE_OF_FIELD; j++) {
                if (OwnField[i][j] == 0) {
                    System.out.print("." + " ");
                }
                else {
                    if (OwnField[i][j] == 1) {
                        System.out.print("O" + " ");
                    }
                    else if (OwnField[i][j] == 2 ){
                        System.out.print("X" + " ");
                    }
                    else if (OwnField[i][j] == 3) {
                        System.out.print("*" + " ");
                    }

                }
            }
            System.out.print("\t");
            for (j = 0; j < SIZE_OF_FIELD; j++) {
                if (OpponentField[i][j] == 0) {
                    System.out.print("." + " ");
                }
                else {
                    if (OpponentField[i][j] == 1) {
                        System.out.print("O" + " ");
                    }
                    else if (OpponentField[i][j] == 2 ){
                        System.out.print("X" + " ");
                    }
                    else if (OpponentField[i][j] == 3) {
                        System.out.print("*" + " ");
                    }

                }
            }
            System.out.println();
        }
    }
}
