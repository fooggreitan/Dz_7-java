package com.mygdx.game.fileS;



import com.mygdx.game.Planner;
import com.mygdx.game.Units.Unit;

import java.util.*;

public class Main {

    public static final int GANG_SIZE = 10;
    public static ArrayList<Unit> teamWhite = new ArrayList<>();
    public static ArrayList<Unit> teamBlack = new ArrayList<>();

    public static void main(String[] args) {

        Planner.createTeams();

        Scanner scanner = new Scanner(System.in);
        while (Planner.teamIsAlive(teamWhite) && Planner.teamIsAlive(teamBlack)) {
            ConsoleView.view();
            Planner.makeStep();
            scanner.nextLine();
        }
        ConsoleView.view();

    }

}