package com.javarush.games.spaceinvaders;

import com.javarush.engine.cell.*;
import com.javarush.games.spaceinvaders.gameobjects.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SpaceInvadersGame extends Game {
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    public static final int COMPLEXITY = 5;
    private static final int STAR_COUNT = 8;
    private static final int PLAYER_BULLETS_MAX = 10;

    private boolean isGameStopped;
    private int animationsCount;
    private int score;

    private EnemyFleet enemyFleet;

    private List<Star> stars;
    private List<Bullet> enemyBullets;
    private List<Bullet> playerBullets;

    private PlayerShip playerShip;

    private Boss boss;

    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    private void drawField() {
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                setCellValueEx(x, y, Color.BLACK, "");
            }
        }

        for (Star star:
             stars) {
            star.draw(this);
        }

    }

    private void createGame() {
        enemyBullets = new ArrayList<Bullet>();
        playerBullets = new ArrayList<Bullet>();
        enemyFleet = new EnemyFleet();
        playerShip = new PlayerShip();
        isGameStopped = false;
        animationsCount = 0;
        score = 0;
        createStars();
        drawScene();
        setTurnTimer(40);
    }

    private void drawScene() {
        drawField();
        for (Bullet bullet:
                enemyBullets) {
            bullet.draw(this);
        }
        for (Bullet bullet:
                playerBullets) {
            bullet.draw(this);
        }
        enemyFleet.draw(this);
        playerShip.draw(this);
    }

    private void createStars() {
        stars = new ArrayList<Star>();

        for (int i = 0; i < STAR_COUNT; i++) {
            stars.add(new Star(getRandomNumber(WIDTH), getRandomNumber(HEIGHT)));
        }
    }

    @Override
    public void onTurn(int step) {
        Bullet bullet = enemyFleet.fire(this);
        if (bullet != null)
            enemyBullets.add(bullet);
        moveSpaceObjects();
        check();
        setScore(score);
        drawScene();
    }

    private void moveSpaceObjects() {
        enemyFleet.move();
        for (Bullet bullet:
                enemyBullets) {
            bullet.move();
        }
        for (Bullet bullet:
                playerBullets) {
            bullet.move();
        }
        playerShip.move();
        setScore(score);
    }

    private void removeDeadBullets() {
        Iterator iterator = enemyBullets.iterator();
        while(iterator.hasNext()){
            Bullet bullet = (Bullet) iterator.next();
            if (!bullet.isAlive || bullet.y >= HEIGHT - 1)
                iterator.remove();
        }
        iterator = playerBullets.iterator();
        while(iterator.hasNext()){
            Bullet bullet = (Bullet) iterator.next();
            if (!bullet.isAlive || bullet.y + bullet.height < 0)
                iterator.remove();
        }
    }

    private void check() {
        playerShip.verifyHit(enemyBullets);
        score += enemyFleet.verifyHit(playerBullets);
        removeDeadBullets();
        if (enemyFleet.getShipsCount() == 0) {
            playerShip.win();
            stopGameWithDelay();
        }

        enemyFleet.deleteHiddenShips();
        if (!playerShip.isAlive) {
            stopGameWithDelay();
        }

        if (enemyFleet.getBottomBorder() >= playerShip.y) {
            playerShip.kill();
        }

    }

    private void stopGame(boolean isWin) {
        isGameStopped = true;
        stopTurnTimer();
        if (isWin)
            showMessageDialog(Color.GRAY, "WINNER!!!", Color.GREEN, 100);
        else
            showMessageDialog(Color.GRAY, "LOOSER!!!", Color.RED, 100);
    }

    private void stopGameWithDelay() {
        animationsCount++;
        if (animationsCount >= 10)
            stopGame(playerShip.isAlive);
    }

    @Override
    public void onKeyPress(Key key) {
        switch (key) {
            case LEFT:
                playerShip.setDirection(Direction.LEFT);
                break;
            case RIGHT:
                playerShip.setDirection(Direction.RIGHT);
                break;
            case ENTER:
                if (isGameStopped)
                    createGame();
                break;
            case SPACE:
                    Bullet bullet = playerShip.fire();
                    if (bullet != null && playerBullets.size() < PLAYER_BULLETS_MAX)
                        playerBullets.add(bullet);
                    break;
        }
    }

    @Override
    public void onKeyReleased(Key key) {
        if ((key == Key.LEFT && playerShip.getDirection() == Direction.LEFT) ||
                (key == Key.RIGHT && playerShip.getDirection() == Direction.RIGHT))
            playerShip.setDirection(Direction.UP);
    }

    @Override
    public void setCellValueEx(int x, int y, Color cellColor, String value) {
        if ((x < 0) || (y < 0) || (x >= WIDTH) || (y >= HEIGHT)) {
            return;
        }
        super.setCellValueEx(x, y, cellColor, value);
    }


}
