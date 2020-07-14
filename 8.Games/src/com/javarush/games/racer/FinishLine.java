package com.javarush.games.racer;

public class FinishLine extends GameObject {
    public boolean isVisible() {
        return isVisible;
    }

    private boolean isVisible = false;

    public FinishLine() {
        super(RacerGame.ROADSIDE_WIDTH, -1 * ShapeMatrix.FINISH_LINE.length, ShapeMatrix.FINISH_LINE);
    }

    public void show() {
        this.isVisible = true;
    }

    public void move(int boost) {
        if (isVisible) {
            this.y += boost;
        }
    }

    public boolean isCrossed(PlayerCar player) {
        return player.y < this.y;
    }
}
