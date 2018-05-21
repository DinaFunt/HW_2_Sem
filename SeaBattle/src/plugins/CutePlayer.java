package plugins;

import com.company.ComputerPlayer;

import java.util.Random;

public class CutePlayer extends ComputerPlayer {
    private Random rnd = new Random(System.currentTimeMillis());

    public void Print() {
        System.out.print("I'm working and I'm full of love ^^\n");
    }

    @Override
    public void NextStep() {
        System.out.print("You're the best player I've ever seen! It's an honor to play with you! I'm so happy!\n");
        do {
            X = rnd.nextInt(10);
            Y = rnd.nextInt(10);
        }
        while (OpponentField[X][Y] != Empty);

    }
}
