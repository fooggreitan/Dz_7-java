package com.mygdx.game.Units;

public class Zoomer extends Magician {

    public Zoomer(String name, int x, int y) {
        super(name, "Zoomer", 30, 9, 12, 17, x, y, 5);
    }

    @Override
    public String getInfo() {
        return "Zoomer";
    }

}
