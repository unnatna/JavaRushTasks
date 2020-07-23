package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.engine.cell.*;
import com.javarush.games.spaceinvaders.Direction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ship extends GameObject {
    private List<int[][]> frames;

    private int frameIndex;
    private boolean loopAnimation;

    Direction direction = Direction.DOWN;
    public boolean isAlive = true;

    public Ship(double x, double y) {
        super(x, y);
    }

    public void setStaticView(int[][] viewFrame){
        setMatrix(viewFrame);
        frames = new ArrayList<int[][]>();
        frames.add(viewFrame);
        frameIndex = 0;
    }

    public Bullet fire() {
        return null;
    }

    public void kill() {
        isAlive = false;
    }

    public void setAnimatedView(boolean isLoopAnimation, int[][]... viewFrames) {
        loopAnimation = isLoopAnimation;
        setMatrix(viewFrames[0]);
        frames = Arrays.asList(viewFrames);
        frameIndex = 0;
    }

    public void nextFrame() {
        frameIndex ++;
        if (loopAnimation && frameIndex >= frames.size()) {
            frameIndex = 0;
        }
        if (frameIndex < frames.size())
            matrix = frames.get(frameIndex);
    }

    @Override
    public void draw(Game game) {
        super.draw(game);
        nextFrame();
    }

    public boolean isVisible() {
        if (!isAlive && frameIndex >= frames.size())
            return false;
        else
            return true;
    }
}
