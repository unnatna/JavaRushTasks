package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.engine.cell.*;

public class Star extends GameObject {
    private static final String STAR_SIGN = "☆";

    public Star(double x, double y) {
        super(x, y);
    }

    @Override
    public void draw(Game game) {
        game.setCellValueEx((int) x, (int) y, Color.NONE, "☆", Color.ORANGE, 100);
    }
}
