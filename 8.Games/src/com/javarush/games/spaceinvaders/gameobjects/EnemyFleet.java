package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.games.spaceinvaders.Direction;
import com.javarush.games.spaceinvaders.ShapeMatrix;
import com.javarush.engine.cell.*;
import com.javarush.games.spaceinvaders.SpaceInvadersGame;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EnemyFleet extends GameObject{
    private static final int ROWS_COUNT = 3;
    private static final int COLUMNS_COUNT = 10;
    private static final int STEP = ShapeMatrix.ENEMY.length + 1;
    private Direction direction = Direction.RIGHT;
    private int SPEED = 1;

    private List<EnemyShip> ships;

    public EnemyFleet() {
        super(0, 0);
        createShips();
    }

    private void createShips() {
        ships = new ArrayList<EnemyShip>();
        for (int i = 0; i < COLUMNS_COUNT; i++) {
            for (int j = 0; j < ROWS_COUNT; j++) {
                ships.add(new EnemyShip((x + i) * STEP, (y + j) * STEP + 12));
            }
        }

        Boss boss = new Boss(STEP * COLUMNS_COUNT / 2 - ShapeMatrix.BOSS_ANIMATION_FIRST.length / 2 - 1, 5);
        ships.add(boss);
    }

    public void draw(Game game){
        for (EnemyShip enemyShip:
             ships) {
            enemyShip.draw(game);
        }
    }

    public void move(){
        if (ships.size() != 0) {
            if (direction == Direction.RIGHT && getRightBorder() > SpaceInvadersGame.WIDTH) {
                for (EnemyShip enemyShip :
                        ships) {
                    enemyShip.move(Direction.DOWN, getSpeed());
                }
                direction = Direction.LEFT;
            }
            if (direction == Direction.LEFT && getLeftBorder() < 0) {
                for (EnemyShip enemyShip :
                        ships) {
                    enemyShip.move(Direction.DOWN, getSpeed());
                }
                direction = Direction.RIGHT;
            }
            for (EnemyShip enemyShip :
                    ships) {
                enemyShip.move(direction, getSpeed());
            }
        }
    }

    private double getSpeed() {
        return Math.min(2.0, 3.0 / ships.size());
    }

    private double getLeftBorder() {
        double result = ships.get(0).x;
        for (EnemyShip enemyShip:
             ships) {
            if (enemyShip.x <= result)
                result = enemyShip.x;
        }
        return result;
    }

    private double getRightBorder() {
        double result = ships.get(0).x + ships.get(0).width;
        for (EnemyShip enemyShip:
             ships) {
            if (enemyShip.x + enemyShip.width >= result)
                result = enemyShip.x + enemyShip.width;
        }
        return result;
    }

    public Bullet fire(Game game) {
        if (game.getRandomNumber(100 / SpaceInvadersGame.COMPLEXITY) > 0 || ships.size() == 0)
            return null;
        else
            return ships.get(game.getRandomNumber(ships.size())).fire();
    }

    public void deleteHiddenShips() {
        Iterator iterator = ships.iterator();
        while(iterator.hasNext()){
            Ship ship = (Ship) iterator.next();
            if (!ship.isVisible())
                iterator.remove();
        }
    }

    public int verifyHit(List<Bullet> bullets) {
        if (bullets.size() == 0)
            return 0;
        int result = 0;
        for (EnemyShip ship:
             ships) {
            for (Bullet bullet:
                 bullets) {
                if (ship.isCollision(bullet) && ship.isAlive && bullet.isAlive) {
                    result += ship.score;
                    ship.kill();
                    bullet.kill();

                }
            }

        }

        return result;
    }

    public double getBottomBorder() {
        if (ships.size() > 0) {
        double result = ships.get(0).y + ships.get(0).height;
        for (Ship ship:
             ships) {
            result = Math.max(result, ship.y + ship.height);
        }
        return result;
        }
        return SpaceInvadersGame.HEIGHT;
    }

    public int getShipsCount() {
        return ships.size();
    }

}
