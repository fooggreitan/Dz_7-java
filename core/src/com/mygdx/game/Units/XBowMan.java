package com.mygdx.game.Units;

public class XBowMan extends ShooterClass {

    public XBowMan(String name, int x, int y) {
        super(name, "Crossbowman", 10, 4, 3, 6, x, y, 16, new int[]{2, 3});
    }

    @Override
    public String getInfo() {
        return "Crossbowman";
    }

}
