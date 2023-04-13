package com.mygdx.game.Units;

public class Robber extends InfantClass {

    public Robber(String name, int x, int y) {
        super(name, "Robber", 10, 6, 3, 8, x, y, new int[]{2, 4});
    }


    @Override
    public String getInfo() {
        return "Robber";
    }

}
