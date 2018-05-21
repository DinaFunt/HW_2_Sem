package com.company;

public class ProcessGame {
    private ComputerPlayer Opponent;

    public ProcessGame(ComputerPlayer Opponent) {
        this.Opponent = Opponent;
    }

    public void Game() {
        boolean a;
        Opponent.SetShips();
        User User = new User();
        User.SetShips();

        System.out.print("You start first!\n");

        do {
            System.out.print("Enter X, Y.\n");
            User.NextStep();
            if (User.Count == 0) {
                break;
            }
            a = Opponent.Hit(User.X, User.Y);
            User.Result(a, User.X, User.Y);

            while (a) {
                System.out.print("You hit the ship. Enter X, Y again.\n");
                User.NextStep();
                if (User.Count == 0) {
                    break;
                }
                a = Opponent.Hit(User.X, User.Y);
                User.Result(a, User.X, User.Y);
            }

            Opponent.NextStep();
            if (Opponent.Count == 0) {
                break;
            }
            a = User.Hit(Opponent.X, Opponent.Y);
            Opponent.Result(a, Opponent.X, Opponent.Y);
            while (a) {
                Opponent.Flag++;
                Opponent.NextStep();
                if (Opponent.Count == 0) {
                    break;
                }
                a = User.Hit(Opponent.X, Opponent.Y);
                Opponent.Result(a, Opponent.X, Opponent.Y);
            }

            System.out.println();

        }
        while (Opponent.Count != 0 && User.Count != 0);

        if (Opponent.Count == 0) {
            System.out.print("You lose!\n");
        }
        else {
            System.out.print("You win!\n");
        }
    }

}