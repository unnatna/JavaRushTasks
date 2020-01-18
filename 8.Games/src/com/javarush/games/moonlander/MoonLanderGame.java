package com.javarush.games.moonlander;

import com.javarush.engine.cell.*;

public class MoonLanderGame extends Game{
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    private Rocket rocket;
    private GameObject landscape;
    private GameObject platform;

    private int score;

    private boolean isUpPressed;
    private boolean isLeftPressed;
    private boolean isRightPressed;
    private boolean isGameStopped;

    @Override
    public void initialize() {
        super.initialize();
        setScreenSize(WIDTH, HEIGHT);
        createGame();
        showGrid(false);
    }

    private void createGame() {
        isUpPressed = false;
        isLeftPressed = false;
        isRightPressed = false;
        isGameStopped = false;
        createGameObjects();
        drawScene();
        setTurnTimer(50);
        score = 1000;
    }

    private void createGameObjects() {
        this.rocket = new Rocket(WIDTH / 2.0, 0);
        this.landscape = new GameObject(0, 25, ShapeMatrix.LANDSCAPE);
        this.platform = new GameObject(23, MoonLanderGame.HEIGHT - 1, ShapeMatrix.PLATFORM);
    }

    private void drawScene() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                setCellColor(i, j, Color.ORANGE);
            }
        }
        rocket.draw(this);
        landscape.draw(this);
    }

    @Override
    public void onTurn(int step) {
        if (score > 0)
            score--;
        rocket.move(isUpPressed, isLeftPressed, isRightPressed);
        check();
        setScore(score);
        drawScene();
    }

    @Override
    public void setCellColor(int x, int y, Color color) {
        if ((x >= 0 && x < WIDTH) && (y >= 0 && y < HEIGHT))
            super.setCellColor(x, y, color);
    }

    @Override
    public void onKeyPress(Key key) {
        //super.onKeyPress(key);
        if (key.equals(Key.UP))
            isUpPressed = true;
        else if (key.equals(Key.LEFT)) {
            isLeftPressed = true;
            isRightPressed = false;
        } else if (key.equals(Key.RIGHT)) {
            isLeftPressed = false;
            isRightPressed = true;
        } else if (key.equals(Key.SPACE) && isGameStopped)
            createGame();
    }

    @Override
    public void onKeyReleased(Key key) {
        //super.onKeyReleased(key);
        if (key.equals(Key.UP))
            isUpPressed = false;
        else if (key.equals(Key.LEFT))
            isLeftPressed = false;
        else if (key.equals(Key.RIGHT))
            isRightPressed = false;
    }

    private void check() {
        if (!(rocket.isCollision(platform) && rocket.isStopped()) && rocket.isCollision(landscape))
            gameOver();
        if (rocket.isStopped() && rocket.isCollision(platform))
            win();
    }

    private void win() {
        rocket.land();
        isGameStopped = true;
        showMessageDialog(Color.ORANGE,"WIN!!!", Color.RED, 25);
        stopTurnTimer();
    }

    private void gameOver() {
        rocket.crash();
        isGameStopped = true;
        showMessageDialog(Color.ORANGE,"LOOSE!!!", Color.RED, 25);
        stopTurnTimer();
        score = 0;
    }


}
