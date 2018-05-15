import java.util.Scanner;

public class Main {

    public static void main(String[] Args) {
        boolean a;
        Scanner in = new Scanner(System.in);
        ComputerPlayer Opponent;

        System.out.println("enter the number of the selected opponent:\n" + "1) Random\n " + "2) Smart\n");
        int TypeOfOpponent = in.nextInt();

        if (TypeOfOpponent == 1) {
            Opponent = new RandomPlayer();
        }
        else if (TypeOfOpponent == 2) {
            Opponent = new Smart();
        }
        else {
            System.out.print("We're sorry. You enter wrong number so your opponent'll be stupid. :\\ \n");
            Opponent = new RandomPlayer();
        }

        Opponent.SetShips();
        User User = new User();
        User.GetShips();

        System.out.print("You start first!\n");

        do {
            User.ShowOpponent();
            System.out.print("Enter X, Y.\n");
            User.NextStep();
            if (User.Count == 0) {
                break;
            }
            a = Opponent.Hit(User.X, User.Y);
            User.Result(a, User.X, User.Y);

            while (a) {
                User.ShowOpponent();
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
