package com.mygdx.game;

import com.mygdx.game.Units.*;


import java.util.ArrayList;
import java.util.Random;

public class Planner {

    public static final int GANG_SIZE = 10;
    public static ArrayList<Unit> teamWhite = new ArrayList<>();
    public static ArrayList<Unit> teamBlack = new ArrayList<>();

    public static void createTeams() {

        teamWhite = new ArrayList<>();
        teamBlack = new ArrayList<>();

        for (int i = GANG_SIZE; i > 0; i--) {
            switch (new Random().nextInt(4)) {
                case 0: teamWhite.add(new Monk(getName(), 1, i)); break;
                case 1: teamWhite.add(new XBowMan(getName(), 1, i)); break;
                case 2: teamWhite.add(new Spearman(getName(), 1, i)); break;
                default: teamWhite.add(new Peasant(getName(), 1, i));
            }
        }

        for (int i = GANG_SIZE; i > 0; i--) {
            switch (new Random().nextInt(4)) {
                case 0:  teamBlack.add(new Zoomer(getName(), 10, i)); break;
                case 1:  teamBlack.add(new Sniper(getName(), 10, i)); break;
                case 2:  teamBlack.add(new Robber(getName(), 10, i)); break;
                default: teamBlack.add(new Peasant(getName(), 10, i));
            }
        }

    }

    public static void makeStep() {

        teamBlack.sort((u1, u2) -> u2.getSpeed() - u1.getSpeed());

        teamWhite.sort((u1, u2) -> u2.getSpeed() - u1.getSpeed());

        for (int i = 0; i < GANG_SIZE; i++) {
            teamWhite.get(i).step(teamWhite, teamBlack);
            teamBlack.get(i).step(teamBlack, teamWhite);
        }
    }

    private static String getName() {
        return Names.values()[new Random().nextInt(Names.values().length)].toString();
    }

    public static boolean teamIsAlive(ArrayList<Unit>team) {
        for (Unit unit:team) {
            if (unit.isAlive()) return true;
        }
        return false;
    }

}
