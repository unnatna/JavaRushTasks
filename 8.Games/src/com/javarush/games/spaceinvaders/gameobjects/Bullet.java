package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;
import com.javarush.games.spaceinvaders.Direction;
import com.javarush.games.spaceinvaders.ShapeMatrix;

public class Bullet extends GameObject {
    private int dy;
    public boolean isAlive = true;

    public Bullet(double x, double y, Direction direction) {
        super(x, y);
        this.setMatrix(ShapeMatrix.BULLET);
        if (direction == Direction.UP)
            dy = -1;
        else dy = 1;
    }

    public void move(){
        this.y += dy;
    }

    public void draw(Game game) {
        game.setCellValueEx((int) x, (int) y, Color.NONE, "▼", Color.CYAN, 100);
    }

    public void kill() {
        isAlive = false;
    }
}