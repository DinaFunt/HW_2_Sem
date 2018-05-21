package com.company;

import java.util.*;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;

public class Main {

    public static void main(String[] Args) {

        MutablePicoContainer Pica = new DefaultPicoContainer();

        Scanner in = new Scanner(System.in);
        ComputerPlayer Opponent;

        System.out.println("enter the number of the selected opponent:\n" + "1) Random\n " + "2) Smart\n" + "3) Your own variant\n");
        int TypeOfOpponent = in.nextInt();

        ServiceLoader<ComputerPlayer> serviceLoader =
                ServiceLoader.load(ComputerPlayer.class);

        switch (TypeOfOpponent) {
            case 1:
                Pica.addComponent(RandomPlayer.class);
                break;
            case 2:
                Pica.addComponent(Smart.class);
                break;
            case 3:

                Pica.addComponent(serviceLoader.findFirst());
                break;
            default:
                System.out.print("We're sorry. You enter wrong number so your opponent'll be stupid. :\\ \n");
                Pica.addComponent(RandomPlayer.class);
        }

        Pica.addComponent(ProcessGame.class);
        ProcessGame pg = (ProcessGame) Pica.getComponent(ProcessGame.class);

        pg.Game();
    }
}
