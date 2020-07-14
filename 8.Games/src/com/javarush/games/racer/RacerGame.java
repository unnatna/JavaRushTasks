package com.javarush.games.racer;

import com.javarush.engine.cell.*;
import com.javarush.games.racer.road.RoadManager;
import com.javarush.games.racer.road.RoadObject;

public class RacerGame extends Game {
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    public static final int CENTER_X = WIDTH / 2;
    public static final int ROADSIDE_WIDTH = 14;
    private static final int RACE_GOAL_CARS_COUNT = 5;

    private RoadMarking roadMarking;
    private PlayerCar player;
    private RoadManager roadManager;
    private FinishLine finishLine;
    private ProgressBar progressBar;

    private boolean isGameStopped;

    private int score;

    @Override
    public void initialize() {
        showGrid(false);
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.DARKGRAY, "GAME OVER", Color.DARKRED, 20);
        //showMessageDialog(Color.DARKGRAY, String.valueOf(roadManager.getPassedCarsCount()), Color.DARKRED, 20);
        stopTurnTimer();
        player.stop();

    }

    private void win() {
        isGameStopped = true;
        stopTurnTimer();
        //player.stop();
        showMessageDialog(Color.DARKGRAY, "WINNER, WINNER... CHIKEN DINER!!!", Color.DARKRED, 20);
    }

    private void createGame() {
        roadMarking = new RoadMarking();
        player = new PlayerCar();
        roadManager = new RoadManager();
        finishLine = new FinishLine();
        progressBar = new ProgressBar(RACE_GOAL_CARS_COUNT);
        isGameStopped = false;
        score = 3500;
        drawScene();
        setTurnTimer(40);
    }

    private void drawScene() {
        drawField();
        roadMarking.draw(this);
        player.draw(this);
        roadManager.draw(this);
        //if (finishLine.isVisible())
        finishLine.draw(this);
        progressBar.draw(this);
    }

    private void drawField() {
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                if (x == CENTER_X)
                    setCellColor(x, y, Color.WHITE);
                else if (x >= ROADSIDE_WIDTH && x < WIDTH - ROADSIDE_WIDTH)
                    setCellColor(x, y, Color.GRAY);
                else
                    setCellColor(x, y, Color.LIGHTGREEN);
            }

        }
    }

    @Override
    public void setCellColor(int x, int y, Color color) {
        if (x >= 0 && x < WIDTH && y >= 0 && y < HEIGHT)
            super.setCellColor(x, y, color);
    }

    @Override
    public void onTurn(int step) {
        if (roadManager.checkCrush(player) == true) {
            gameOver();
        }
        else {
            roadManager.generateNewRoadObjects(this);
            if (roadManager.getPassedCarsCount() >= RACE_GOAL_CARS_COUNT) {
                finishLine.show();

            }
            if (finishLine.isCrossed(player))
                win();
            else
                moveAll();
        }
        score -= 5;
        setScore(score);
        drawScene();
    }

    @Override
    public void onKeyPress(Key key) {
        if (key == Key.RIGHT)
            player.setDirection(Direction.RIGHT);

        if (key == Key.LEFT)
            player.setDirection(Direction.LEFT);

        if (key == Key.SPACE && isGameStopped)
            createGame();

        if (key == Key.UP)
            player.speed = 2;

    }

    @Override
    public void onKeyReleased(Key key) {
        if ((key.equals(Key.LEFT) && player.getDirection().equals(Direction.LEFT)) ||
            (key.equals(Key.RIGHT) && player.getDirection().equals(Direction.RIGHT)))
        switch (key) {
            case LEFT:
            case RIGHT:
                player.setDirection(Direction.NONE);
                break;

        }

        if (key == Key.UP)
            player.speed = 1;
    }

    private void moveAll() {
        roadManager.move(player.speed);
        roadMarking.move(player.speed);
        player.move();
        finishLine.move(player.speed);
        progressBar.move(roadManager.getPassedCarsCount());
    }
}
